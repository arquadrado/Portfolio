package org.academiadecodigo.antonio.sokoban;


import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.*;
import java.util.ArrayList;


public class Game implements KeyboardHandler {

    private boolean running = false;
    private int cellSize = 50;
    private int col = 20;
    private int row = 17;
    private Text label;
    private Player player;
    private Tile[][] grid;
    private ArrayList<Box> boxes;
    private ArrayList<Storage> storagePoints;
    private ArrayList<Wall> walls;
    private Keyboard keyboard;
    private Picture picture;
    private boolean levelComplete = false;
    private int level = 1;
    private int moves = 0;
    private int totalMoves = 0;
    private int pushes = 0;
    private int totalPushes = 0;
    private FileReader fileReader;
    boolean frame = true;
    boolean newGame;
    private boolean canUndo = true;

    // starts the game
    public void start(){

        createGrid(col, row);

        createKeyboard();
        picture = new Picture(0, 0, "resources/startgame.png");
        picture.draw();
    }



    public void run() {
        running = true;
        picture.delete();
        //create map
        try {
            createLevel();
            spawnBoxes();
            createPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create a new label to keep stats
        createLabel();

    }

    public void createGrid(int col, int row){
        grid = new Tile[row][col];

        for(int i = 0; i < row; i++){
            grid[i] = new Tile[col];
            for(int j = 0; j < col; j++){
                grid[i][j] = new Tile(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

    }
    public void createLevel() throws IOException {
        boxes = new ArrayList<>();
        storagePoints = new ArrayList<>();
        walls = new ArrayList<>();
        try {
            fileReader = new FileReader("maps/map-level-" + level + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){
                int character = fileReader.read();
                if(character == '#'){
                    grid[i][j].createWall();
                    walls.add(new Wall(j, i, cellSize));
                } else if(character == 'p' || character == '$'){
                    grid[i][j].createStoragePoint();
                    storagePoints.add(new Storage(j, i, cellSize));
                } else  {
                    grid[i][j].createEmptySpace();
                }
            }
        }

    }

    public void spawnBoxes() throws IOException {
        boxes = new ArrayList<>();

        try {
            fileReader = new FileReader("maps/map-level-" + level + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){
                int character = fileReader.read();
                 if(character == 'x' || character == '$'){
                    grid[i][j].createBox();
                    boxes.add(new Box(j, i, cellSize));
                }
            }
        }

    }


    public void deleteLevel() throws IOException {
        int boxIndex = 0;
        int storageIndex = 0;
        int wallIndex = 0;

        while(boxIndex < boxes.size()){
            boxes.get(boxIndex++).picture.delete();
            storagePoints.get(storageIndex++).picture.delete();
        }
        while(wallIndex < walls.size()){
            walls.get(wallIndex++).picture.delete();
        }
        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){
                if(grid[i][j].isBox() || grid[i][j].isWall() || grid[i][j].isStoragePoint()){
                    grid[i][j].removeObject();
                }
            }
        }

    }
    public void createPlayer() throws IOException {
        try {
            fileReader = new FileReader("maps/map-level-" + level + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){
                int character = fileReader.read();
                if(character == 'j'){
                   player = new Player(j, i, cellSize);
                }
            }
        }
    }

    public void createLabel(){

        label = new Text(2, 2, "Level: " + level + " Moves: " + moves + " Pushes: " + pushes + " Total moves: " + totalMoves + " Total pushes: " + totalPushes);
        label.draw();

    }

    public void loadGame(){
        try {
            fileReader = new FileReader("saves/savegame.txt");
            BufferedReader buffer = new BufferedReader(fileReader);
            String line = buffer.readLine();

            System.out.println(line);

            this.level = Integer.parseInt(line);

            System.out.println("load" + level);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGame(){

            try {
                //fileWriter = new PrintWriter("saves/savegame.txt", "UTF-8");
                FileWriter fileWriter = new FileWriter("saves/savegame.txt");
                fileWriter.write(new Integer(level).toString());
                fileWriter.close();
                System.out.println("Saving...");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }




    }

    public void createKeyboard(){
        // define keyboard events
        keyboard = new Keyboard(this);

        KeyboardEvent[] event = new KeyboardEvent[12];

        for(int i = 0; i < event.length; i++){

            event[i] = new KeyboardEvent();
            if(i == 0)event[i].setKey(KeyboardEvent.KEY_W);
            if(i == 1)event[i].setKey(KeyboardEvent.KEY_S);
            if(i == 2)event[i].setKey(KeyboardEvent.KEY_A);
            if(i == 3)event[i].setKey(KeyboardEvent.KEY_D);
            if(i == 4)event[i].setKey(KeyboardEvent.KEY_R);
            if(i == 5)event[i].setKey(KeyboardEvent.KEY_Z);
            if(i == 6)event[i].setKey(KeyboardEvent.KEY_SPACE);
            if(i == 7)event[i].setKey(KeyboardEvent.KEY_L);
            if(i == 8)event[i].setKey(KeyboardEvent.KEY_K);
            if(i == 9)event[i].setKey(KeyboardEvent.KEY_H);
            if(i == 10)event[i].setKey(KeyboardEvent.KEY_UP);
            if(i == 11)event[i].setKey(KeyboardEvent.KEY_DOWN);
            event[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event[i]);


        }
    }

    // updates the label
    public void updateLabel(){

        label.delete();
        label = new Text(2, 2, "Level: " + level + " Moves: " + moves + " Pushes: " + pushes + " Total moves: " + totalMoves + " Total pushes: " + totalPushes);
        label.draw();
    }

    /**
     * Checks the cell next to the given object in a certain direction
     * @param gameObject
     * @param direction
     * @returns 0 if empty, 1 if box or -1 if wall
     */
    public int checkSurroundings(GameObject gameObject, Direction direction){
        int col = gameObject.getCol();
        int row = gameObject.getRow();
        switch (direction){
                case UP:
                    if(isWall(col, row - 1))return -1;
                    if(isBox(col, row - 1)) return 1;
                    break;
                case DOWN:
                    if(isWall(col, row + 1))return -1;
                    if(isBox(col, row + 1)) return 1;
                    break;
                case RIGHT:
                    if(isWall(col + 1, row))return -1;
                    if(isBox(col + 1, row)) return 1;
                    break;
                case LEFT:
                    if(isWall(col - 1, row))return -1;
                    if(isBox(col - 1, row)) return 1;
                    break;
        }
       return 0;
    }

    public Box getNextBox(Direction direction){
        Box boxToReturn = null;
        for(Box box : boxes){

            int boxCol = box.getCol();
            int boxRow = box.getRow();

            switch (direction){
                case UP:
                    if(boxCol == player.getCol() && boxRow == player.getRow() - 1)
                         boxToReturn = box;
                    break;
                case DOWN:
                    if(boxCol == player.getCol() && boxRow == player.getRow() + 1)
                        boxToReturn = box;
                    break;
                case RIGHT:
                    if(boxCol == player.getCol() + 1 && boxRow == player.getRow())
                        boxToReturn = box;
                    break;
                case LEFT:
                    if(boxCol == player.getCol() - 1 && boxRow == player.getRow())
                        boxToReturn = box;
                    break;
            }
        }
        return boxToReturn;
    }

    public boolean canMove(GameObject gameObject, Direction direction){

        switch(gameObject.getId()){
            case PLAYER:
                if(checkSurroundings(gameObject, direction) < 0 ){
                    return false;
                }else if(checkSurroundings(gameObject, direction) == 0){
                    return true;
                } else {
                    return canMove(getNextBox(direction), direction);
                }
            case BOX:
                return checkSurroundings(gameObject, direction) == 0;
        }
        return true;
    }

    public boolean isWall(int col, int row){
        return grid[row][col].isWall();
    }

    public boolean isBox(int col, int row){
        return grid[row][col].isBox();
    }

    public void move(GameObject gameObject, Direction direction){

        switch (direction){
            case UP:
                updatePosition(gameObject, 0, -1);
                if(gameObject.getId() == ID.BOX){
                    updateBox(gameObject);
                }
                break;
            case DOWN:
                updatePosition(gameObject, 0, 1);
                if(gameObject.getId() == ID.BOX){
                    updateBox(gameObject);
                }
                break;
            case LEFT:
                updatePosition(gameObject, -1, 0);
                if(gameObject.getId() == ID.BOX){
                    updateBox(gameObject);
                }
                break;
            case RIGHT:
                updatePosition(gameObject, 1, 0);
                if(gameObject.getId() == ID.BOX){
                    updateBox(gameObject);
                }
                break;
        }

        System.out.println("Col: " + gameObject.getLastCol() + " Row: " + gameObject.getLastRow());
    }

    public  void updatePosition(GameObject gameObject, int wayX, int wayY){
        int col = gameObject.getCol();
        int row = gameObject.getRow();
        gameObject.setLastPosition(col, row);
        System.out.println("moving");
        gameObject.picture.translate(cellSize * wayX, cellSize * wayY);
        gameObject.setPosition(gameObject.getCol() + wayX, gameObject.getRow() + wayY);
    }

    public void updateBox(GameObject gameObject){
        grid[gameObject.getRow()][gameObject.getCol()].createBox();
        grid[gameObject.getLastRow()][gameObject.getLastCol()].removeObject();
        onPlace();
        levelStatus();
    }

    // checks if boxes are stored
    public void onPlace(){
        for(int i = 0; i < boxes.size(); i++){
            for(int j = 0; j < storagePoints.size(); j++){
                if(boxes.get(i).getCol() == storagePoints.get(j).getCol() && boxes.get(i).getRow() == storagePoints.get(j).getRow()){
                    boxes.get(i).picture.load("resources/box1.png");
                    boxes.get(i).setStored(true);
                    break;
                } else if(boxes.get(i).isStored()){
                    boxes.get(i).picture.load("resources/box2.png");
                    boxes.get(i).setStored(false);
                }
            }
        }
    }

    public boolean levelStatus(){

        for(int i = 0; i < boxes.size(); i++){
            if (!boxes.get(i).isStored()){
                levelComplete = false;
                return false;
            }
        }
        levelComplete = true;
        level++;
        picture = new Picture(0, 0, "resources/levelac2.png");
        picture.draw();
        return true;
    }


    // print player's current position and last position
    public void printPositions() {
        System.out.println("Current col: " + player.getCol() + " Current row: " + player.getRow());
        System.out.println("Last col: " + player.getLastCol() + " Last row: " + player.getLastRow());
        System.out.println("==========================================");

    }

    public void resetLevel(){
        pushes = 0;
        moves = 0;
        if(levelComplete) {
            picture.delete();
        }
        label.delete();
        player.picture.delete();
        try {
            deleteLevel();
            createLevel();
            spawnBoxes();
            createPlayer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        createLabel();


    }

    public void undo(){
        
    }

    public Box getBox(){

        for(Box box : boxes){

            if(player.getCol() == box.getCol() && player.getRow() == box.getRow()){
                return box;
            }
        }
        return null;
    }

    public void updateMoves(Direction direction){
        switch (direction){
            case UP:
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "top1.png", "resources/" + player.chooseChar() +"top2.png"));
                break;
            case DOWN:
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "bot1.png", "resources/" + player.chooseChar() +"bot2.png"));
                break;
            case LEFT:
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "left1.png", "resources/" + player.chooseChar() +"left2.png"));
                break;
            case RIGHT:
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "right1.png", "resources/" + player.chooseChar() +"right2.png"));
        }
        moves++;
        totalMoves++;
        updateLabel();
    }
    public void updatePushes(){
        pushes++;
        totalPushes++;
        updateLabel();
    }
    @Override
    public void keyPressed(KeyboardEvent e) {

        if(e.getKey() == KeyboardEvent.KEY_W && canMove(player, Direction.UP)){

            move(player, Direction.UP);
            updateMoves(Direction.UP);
            if(getBox() != null){
                move(getBox(), Direction.UP);
                updatePushes();
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_S && canMove(player, Direction.DOWN)){



            move(player, Direction.DOWN);
            updateMoves(Direction.DOWN);
            if(getBox() != null){
                move(getBox(), Direction.DOWN);
                updatePushes();
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_A && canMove(player, Direction.LEFT)){

            move(player, Direction.LEFT);
            updateMoves(Direction.LEFT);
            if(getBox() != null){
                move(getBox(), Direction.LEFT);
                updatePushes();
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_D && canMove(player, Direction.RIGHT)) {

            move(player, Direction.RIGHT);
            updateMoves(Direction.RIGHT);
            if(getBox() != null){
                move(getBox(), Direction.RIGHT);
                updatePushes();
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_R){
            resetLevel();
        }

        if(e.getKey() == KeyboardEvent.KEY_Z) {
            try {
                deleteLevel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.out.println("ctrl z");
        }
        if(e.getKey() == KeyboardEvent.KEY_SPACE){
            if(levelComplete){
                resetLevel();
                levelComplete = false;
                picture.delete();
            }
            if(!running){
                if(newGame){
                    run();
                    System.out.println("New Game");
                } else {
                    loadGame();
                    run();
                    System.out.println("Load Game");
                }
            }

            System.out.println("Space pressed");
        }
        if(e.getKey() == KeyboardEvent.KEY_H){
            if(levelComplete){
                saveGame();
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_L){
            loadGame();
            run();
            System.out.println("Load Game");
        }
        if(e.getKey() == KeyboardEvent.KEY_K){
            run();
            System.out.println("New Game");
        }
        if(e.getKey() == KeyboardEvent.KEY_UP || e.getKey() == KeyboardEvent.KEY_DOWN){


            String image1 = "resources/loadgame.png";
            String image2 = "resources/startgame.png";

            if(frame){
                newGame = false;
                picture.load(image1);
            } else{
                newGame = true;
                picture.load(image2);
            }
            frame = !frame;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        game.start();
    }
}
