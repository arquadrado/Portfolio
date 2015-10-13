package org.academiadecodigo.antonio.sokoban;


import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;


public class Game implements KeyboardHandler {

    private boolean running = false;
    private int col = 20;
    private int row = 17;
    private Text label;
    protected Grid grid;
    private Player player;
    private ArrayList<Box> boxes;
    private Keyboard keyboard;
    private Picture picture;
    private boolean levelComplete = false;
    protected static int level = 1;
    private int moves = 0;
    private int totalMoves = 0;
    private int pushes = 0;
    private int totalPushes = 0;
    private FileReader fileReader;
    boolean frame = true;
    boolean newGame = true;

    // starts the game
    public void start(){

        createKeyboard();
        picture = new Picture(0, 0, "resources/startgame.png");
        picture.draw();

    }



    public void run() {
        running = true;
        picture.delete();
        grid = new Grid(col, row);
        //create map
        try {
            spawnBoxes(this);
            createPlayer(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create a new label to keep stats
        createLabel();

    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public Grid getGrid() {
        return grid;
    }

    public void spawnBoxes(Game game) throws IOException {
        boxes = new ArrayList<>();

        /*URL url = Game.class.getResource("maps/map-level");
        InputStreamReader in = new InputStreamReader(url.openStream());
        in.read();*/

        try {
            fileReader = new FileReader("maps/map-level-" + level + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){
                int character = fileReader.read();
                if(character == 'x' || character == '$'){
                    grid.tile()[i][j].createBox();
                    System.out.println(character);
                    boxes.add(new Box(j, i, game));
                }
            }
        }

    }

    public void deleteBoxes(){
        int boxIndex = 0;
         while(boxIndex < boxes.size()){
            boxes.get(boxIndex++).picture.delete();
        }
    }


    public void createPlayer(Game game) throws IOException {
        try {
            fileReader = new FileReader("maps/map-level-" + level + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < row; i++){

            for(int j = 0; j < col; j++){
                int character = fileReader.read();
                if(character == 'j'){
                   player = new Player(j, i, game);
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

        ArrayList<KeyboardEvent> event = new ArrayList();
        for(int i = 0; i < 9; i++){
            event.add(new KeyboardEvent());
            if(i == 0)event.get(i).setKey(KeyboardEvent.KEY_W);
            if(i == 1)event.get(i).setKey(KeyboardEvent.KEY_S);
            if(i == 2)event.get(i).setKey(KeyboardEvent.KEY_A);
            if(i == 3)event.get(i).setKey(KeyboardEvent.KEY_D);
            if(i == 4)event.get(i).setKey(KeyboardEvent.KEY_R);
            if(i == 5)event.get(i).setKey(KeyboardEvent.KEY_SPACE);
            if(i == 6)event.get(i).setKey(KeyboardEvent.KEY_K);
            if(i == 7)event.get(i).setKey(KeyboardEvent.KEY_UP);
            if(i == 8)event.get(i).setKey(KeyboardEvent.KEY_DOWN);
            event.get(i).setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event.get(i));
        }


/*
        KeyboardEvent[] event = new KeyboardEvent[12];

        for(int i = 0; i < event.length; i++){

            event[i] = new KeyboardEvent();

            event[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(event[i]);
        }*/
    }

    // updates the label
    public void updateLabel(){

        label.delete();
        label = new Text(2, 2, "Level: " + level + " Moves: " + moves + " Pushes: " + pushes + " Total moves: " + totalMoves + " Total pushes: " + totalPushes);
        label.draw();
    }

    // checks if boxes are stored
    public void onPlace(){
        for(int i = 0; i < boxes.size(); i++){
            for(int j = 0; j < getGrid().storagePoints.size(); j++){
                if(boxes.get(i).getCol() == getGrid().storagePoints.get(j).getCol() && boxes.get(i).getRow() == getGrid().storagePoints.get(j).getRow()){
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

    public void resetLevel(){
        pushes = 0;
        moves = 0;
        if(levelComplete)picture.delete();
        label.delete();
        player.picture.delete();
        deleteBoxes();
        try {
            grid.deleteLevel();
            grid.createLevel();
            spawnBoxes(this);
            createPlayer(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        createLabel();
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

        if(e.getKey() == KeyboardEvent.KEY_W && running){

            if(player.canMove(Direction.UP) ){
                player.move(Direction.UP);
                updateMoves(Direction.UP);
                if(getBox() != null){
                    getBox().move(Direction.UP);
                    updatePushes();
                }
            }

        }
        if(e.getKey() == KeyboardEvent.KEY_S && running){

            if(player.canMove(Direction.DOWN) ){
                player.move(Direction.DOWN);
                updateMoves(Direction.DOWN);
                if(getBox() != null){
                    getBox().move(Direction.DOWN);
                    updatePushes();
                }
            }

        }
        if(e.getKey() == KeyboardEvent.KEY_A && running){

            if(player.canMove(Direction.LEFT) ){
                player.move(Direction.LEFT);
                updateMoves(Direction.LEFT);
                if(getBox() != null){
                    getBox().move(Direction.LEFT);
                    updatePushes();
                }
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_D && running) {

            if(player.canMove(Direction.RIGHT) ){
                player.move(Direction.RIGHT);
                updateMoves(Direction.RIGHT);
                if(getBox() != null){
                    getBox().move(Direction.RIGHT);
                    updatePushes();
                }
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_R && running){
            resetLevel();
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
        }
        if(e.getKey() == KeyboardEvent.KEY_W){
            if(levelComplete){
                saveGame();
            }
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
