package org.academiadecodigo.antonio.sokoban;


import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game implements KeyboardHandler {

    private Window window;
    private Text label;
    private Player player;
    private Box[] boxes;
    private boolean[][] boxGrid = new boolean[14][20];
    private Storage[] storagePoints;
    private Keyboard keyboard;
    private Picture picture;
    private boolean levelComplete = false;
    private int level = 1;
    private int moves = 0;
    private int totalMoves = 0;
    private int pushes = 0;
    private int totalPushes = 0;
    private boolean canUndo = true;

    // starts the game
    public void start(){

        window = new Window(20, 14, 50);
        run();
    }



    public void run() {

        //create map
        window.createWalls(level);

        // create storage points for boxes
        createStorage();

        // creates a new player
        createPlayer();

        // create the boxes
        spawnBoxes();

        // create a new label to keep stats
        createLabel();

        createKeyboard();




    }

    public void createPlayer(){
        switch (level){
            case 1:
                player = new Player(11, 10, window.getCellSize());
                break;
            case 2:
                player = new Player(11, 6, window.getCellSize());
                break;
            case 3:
                player = new Player(15, 3, window.getCellSize());
                break;
            case 4:
                player = new Player(10, 11, window.getCellSize());
                break;
            case 5:
                player = new Player(15, 8, window.getCellSize());
                break;
            case 6:
                player = new Player(13, 3, window.getCellSize());
                break;
            case 7:
                player = new Player(5, 2, window.getCellSize());
                break;
        }
    }

    public void createLabel(){

        label = new Text(2, 2, "Level: " + level + " Moves: " + moves + " Pushes: " + pushes + " Total moves: " + totalMoves + " Total pushes: " + totalPushes);
        label.draw();

    }

    public void spawnBoxes(){
        switch (level){
            case 1:
                boxes = new Box[6];
                boxes[0] = new Box(5, 4, window.getCellSize());
                boxGrid[4][5] = true;
                boxes[1] = new Box(7, 5, window.getCellSize());
                boxGrid[5][7] = true;
                boxes[2] = new Box(7, 6, window.getCellSize());
                boxGrid[6][7] = true;
                boxes[3] = new Box(5, 6, window.getCellSize());
                boxGrid[6][5] = true;
                boxes[4] = new Box(5, 9, window.getCellSize());
                boxGrid[9][5] = true;
                boxes[5] = new Box(2, 9, window.getCellSize());
                boxGrid[9][2] = true;
                break;
            case 2:
                boxes = new Box[10];
                boxes[0] = new Box(10, 5, window.getCellSize());
                boxes[1] = new Box(11, 4, window.getCellSize());
                boxes[2] = new Box(14, 4, window.getCellSize());
                boxes[3] = new Box(14, 7, window.getCellSize());
                boxes[4] = new Box(13, 8, window.getCellSize());
                boxes[5] = new Box(15, 8, window.getCellSize());
                boxes[6] = new Box(13, 9, window.getCellSize());
                boxes[7] = new Box(15, 9, window.getCellSize());
                boxes[8] = new Box(11, 9, window.getCellSize());
                boxes[9] = new Box(8, 9, window.getCellSize());
                break;
            case 3:
                boxes = new Box[11];

                boxes[0] = new Box(11, 4, window.getCellSize());
                boxes[1] = new Box(11, 5, window.getCellSize());
                boxes[2] = new Box(11, 6, window.getCellSize());
                boxes[3] = new Box(11, 7, window.getCellSize());
                boxes[4] = new Box(11, 8, window.getCellSize());
                boxes[5] = new Box(10, 9, window.getCellSize());
                boxes[6] = new Box(13, 9, window.getCellSize());
                boxes[7] = new Box(14, 8, window.getCellSize());
                boxes[8] = new Box(13, 6, window.getCellSize());
                boxes[9] = new Box(14, 5, window.getCellSize());
                boxes[10] = new Box(13, 4, window.getCellSize());
                break;
            case 4:
                boxes = new Box[20];

                boxes[0] = new Box(2, 4, window.getCellSize());
                boxes[1] = new Box(3, 4, window.getCellSize());
                boxes[2] = new Box(4, 4, window.getCellSize());
                boxes[3] = new Box(6, 4, window.getCellSize());
                boxes[4] = new Box(9, 4, window.getCellSize());
                boxes[5] = new Box(8, 3, window.getCellSize());
                boxes[6] = new Box(10, 3, window.getCellSize());
                boxes[7] = new Box(3, 5, window.getCellSize());
                boxes[8] = new Box(9, 5, window.getCellSize());
                boxes[9] = new Box(2, 6, window.getCellSize());
                boxes[10] = new Box(3, 6, window.getCellSize());
                boxes[11] = new Box(6, 6, window.getCellSize());
                boxes[12] = new Box(8, 6, window.getCellSize());
                boxes[13] = new Box(10, 6, window.getCellSize());
                boxes[14] = new Box(3, 7, window.getCellSize());
                boxes[15] = new Box(6, 10, window.getCellSize());
                boxes[16] = new Box(3, 11, window.getCellSize());
                boxes[17] = new Box(4, 11, window.getCellSize());
                boxes[18] = new Box(6, 11, window.getCellSize());
                boxes[19] = new Box(7, 11, window.getCellSize());
                break;
            case 5:
                boxes = new Box[12];

                boxes[0] = new Box(12, 3, window.getCellSize());
                boxes[1] = new Box(15, 4, window.getCellSize());
                boxes[2] = new Box(11, 6, window.getCellSize());
                boxes[3] = new Box(14, 6, window.getCellSize());
                boxes[4] = new Box(10, 7, window.getCellSize());
                boxes[5] = new Box(12, 7, window.getCellSize());
                boxes[6] = new Box(13, 7, window.getCellSize());
                boxes[7] = new Box(10, 8, window.getCellSize());
                boxes[8] = new Box(13, 8, window.getCellSize());
                boxes[9] = new Box(12, 9, window.getCellSize());
                boxes[10] = new Box(11, 10, window.getCellSize());
                boxes[11] = new Box(13, 10, window.getCellSize());
                break;
            case 6:
                boxes = new Box[10];

                boxes[0] = new Box(12, 5, window.getCellSize());
                boxes[1] = new Box(13, 5, window.getCellSize());
                boxes[2] = new Box(13, 6, window.getCellSize());
                boxes[3] = new Box(13, 7, window.getCellSize());
                boxes[4] = new Box(12, 8, window.getCellSize());
                boxes[5] = new Box(13, 9, window.getCellSize());
                boxes[6] = new Box(12, 10, window.getCellSize());
                boxes[7] = new Box(9, 10, window.getCellSize());
                boxes[8] = new Box(10, 9, window.getCellSize());
                boxes[9] = new Box(9, 8, window.getCellSize());
                break;
            case 7:
                boxes = new Box[11];
                boxes[0] = new Box(3, 4, window.getCellSize());
                boxes[1] = new Box(9, 2, window.getCellSize());
                boxes[2] = new Box(10, 2, window.getCellSize());
                boxes[3] = new Box(5, 3, window.getCellSize());
                boxes[4] = new Box(9, 5, window.getCellSize());
                boxes[5] = new Box(2, 6, window.getCellSize());
                boxes[6] = new Box(2, 7, window.getCellSize());
                boxes[7] = new Box(4, 7, window.getCellSize());
                boxes[8] = new Box(6, 7, window.getCellSize());
                boxes[9] = new Box(2, 9, window.getCellSize());
                boxes[10] = new Box(3, 9, window.getCellSize());
                break;
        }


    }

    public void deleteBoxes(){
        for(int i = 0; i < boxes.length; i++){
            boxes[i].picture.delete();
        }
        for(int i = 0; i < Window.getRow(); i++){
            for(int j = 0; j < Window.getCol(); j++){
                boxGrid[i][j] = false;
            }
        }


    }

    public void createStorage(){
        switch (level){
            case 1:
                storagePoints = new Storage[6];

                storagePoints[0] = new Storage(16, 8, window.getCellSize());
                storagePoints[1] = new Storage(17, 8, window.getCellSize());
                storagePoints[2] = new Storage(16, 9, window.getCellSize());
                storagePoints[3] = new Storage(17, 9, window.getCellSize());
                storagePoints[4] = new Storage(16, 10, window.getCellSize());
                storagePoints[5] = new Storage(17, 10, window.getCellSize());
                break;
            case 2:
                storagePoints = new Storage[10];

                storagePoints[0] = new Storage(5, 7, window.getCellSize());
                storagePoints[1] = new Storage(6, 7, window.getCellSize());
                storagePoints[2] = new Storage(5, 6, window.getCellSize());
                storagePoints[3] = new Storage(6, 6, window.getCellSize());
                storagePoints[4] = new Storage(5, 5, window.getCellSize());
                storagePoints[5] = new Storage(6, 5, window.getCellSize());
                storagePoints[6] = new Storage(5, 4, window.getCellSize());
                storagePoints[7] = new Storage(6, 4, window.getCellSize());
                storagePoints[8] = new Storage(5, 3, window.getCellSize());
                storagePoints[9] = new Storage(6, 3, window.getCellSize());
                break;
            case 3:
                storagePoints = new Storage[11];

                storagePoints[0] = new Storage(2, 8, window.getCellSize());
                storagePoints[1] = new Storage(3, 8, window.getCellSize());
                storagePoints[2] = new Storage(4, 8, window.getCellSize());
                storagePoints[3] = new Storage(5, 8, window.getCellSize());
                storagePoints[4] = new Storage(3, 9, window.getCellSize());
                storagePoints[5] = new Storage(4, 9, window.getCellSize());
                storagePoints[6] = new Storage(5, 9, window.getCellSize());
                storagePoints[7] = new Storage(2, 10, window.getCellSize());
                storagePoints[8] = new Storage(3, 10, window.getCellSize());
                storagePoints[9] = new Storage(4, 10, window.getCellSize());
                storagePoints[10] = new Storage(5, 10, window.getCellSize());
                break;
            case 4:
                storagePoints = new Storage[20];

                storagePoints[0] = new Storage(14, 1, window.getCellSize());
                storagePoints[1] = new Storage(15, 1, window.getCellSize());
                storagePoints[2] = new Storage(16, 1, window.getCellSize());
                storagePoints[3] = new Storage(17, 1, window.getCellSize());
                storagePoints[4] = new Storage(14, 2, window.getCellSize());
                storagePoints[5] = new Storage(15, 2, window.getCellSize());
                storagePoints[6] = new Storage(16, 2, window.getCellSize());
                storagePoints[7] = new Storage(17, 2, window.getCellSize());
                storagePoints[8] = new Storage(14, 3, window.getCellSize());
                storagePoints[9] = new Storage(15, 3, window.getCellSize());
                storagePoints[10] = new Storage(16, 3, window.getCellSize());
                storagePoints[11] = new Storage(17, 3, window.getCellSize());
                storagePoints[12] = new Storage(14, 4, window.getCellSize());
                storagePoints[13] = new Storage(15, 4, window.getCellSize());
                storagePoints[14] = new Storage(16, 4, window.getCellSize());
                storagePoints[15] = new Storage(17, 4, window.getCellSize());
                storagePoints[16] = new Storage(14, 5, window.getCellSize());
                storagePoints[17] = new Storage(15, 5, window.getCellSize());
                storagePoints[18] = new Storage(16, 5, window.getCellSize());
                storagePoints[19] = new Storage(17, 5, window.getCellSize());
                break;
            case 5:
                storagePoints = new Storage[12];

                storagePoints[0] = new Storage(2, 6, window.getCellSize());
                storagePoints[1] = new Storage(3, 6, window.getCellSize());
                storagePoints[2] = new Storage(4, 6, window.getCellSize());
                storagePoints[3] = new Storage(5, 6, window.getCellSize());
                storagePoints[4] = new Storage(2, 7, window.getCellSize());
                storagePoints[5] = new Storage(3, 7, window.getCellSize());
                storagePoints[6] = new Storage(4, 7, window.getCellSize());
                storagePoints[7] = new Storage(5, 7, window.getCellSize());
                storagePoints[8] = new Storage(2, 8, window.getCellSize());
                storagePoints[9] = new Storage(3, 8, window.getCellSize());
                storagePoints[10] = new Storage(4, 8, window.getCellSize());
                storagePoints[11] = new Storage(5, 8, window.getCellSize());
                break;
            case 6:
                storagePoints = new Storage[10];

                storagePoints[0] = new Storage(5, 3, window.getCellSize());
                storagePoints[1] = new Storage(6, 3, window.getCellSize());
                storagePoints[2] = new Storage(5, 4, window.getCellSize());
                storagePoints[3] = new Storage(6, 4, window.getCellSize());
                storagePoints[4] = new Storage(5, 5, window.getCellSize());
                storagePoints[5] = new Storage(6, 5, window.getCellSize());
                storagePoints[6] = new Storage(5, 6, window.getCellSize());
                storagePoints[7] = new Storage(6, 6, window.getCellSize());
                storagePoints[8] = new Storage(5, 7, window.getCellSize());
                storagePoints[9] = new Storage(6, 7, window.getCellSize());

                break;
            case 7:
                storagePoints = new Storage[11];

                storagePoints[0] = new Storage(10, 6, Window.getCellSize());
                storagePoints[1] = new Storage(9, 6, Window.getCellSize());
                storagePoints[2] = new Storage(10, 7, Window.getCellSize());
                storagePoints[3] = new Storage(9, 7, Window.getCellSize());
                storagePoints[4] = new Storage(8, 7, Window.getCellSize());
                storagePoints[5] = new Storage(10, 8, Window.getCellSize());
                storagePoints[6] = new Storage(9, 8, Window.getCellSize());
                storagePoints[7] = new Storage(8, 8, Window.getCellSize());
                storagePoints[8] = new Storage(10, 9, Window.getCellSize());
                storagePoints[9] = new Storage(9, 9, Window.getCellSize());
                storagePoints[10] = new Storage(8, 9, Window.getCellSize());
                break;
        }


    }

    public void deleteStorage() {
        for (int i = 0; i < storagePoints.length; i++) {
            storagePoints[i].picture.delete();

        }

    }

    public void createKeyboard(){
        // define keyboard events
        keyboard = new Keyboard(this);

        KeyboardEvent[] event = new KeyboardEvent[7];

        for(int i = 0; i < event.length; i++){

            if(player.getId() == ID.PLAYER){
                event[i] = new KeyboardEvent();
                if(i == 0)event[i].setKey(KeyboardEvent.KEY_W);
                if(i == 1)event[i].setKey(KeyboardEvent.KEY_S);
                if(i == 2)event[i].setKey(KeyboardEvent.KEY_A);
                if(i == 3)event[i].setKey(KeyboardEvent.KEY_D);
                if(i == 4)event[i].setKey(KeyboardEvent.KEY_R);
                if(i == 5)event[i].setKey(KeyboardEvent.KEY_Z);
                if(i == 6)event[i].setKey(KeyboardEvent.KEY_SPACE);
                event[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(event[i]);
            }

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

    public Box boxNext(Direction direction){
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
                    return canMove(boxNext(direction), direction);
                }
            case BOX:
                return checkSurroundings(gameObject, direction) == 0;
        }
        return true;
    }

    public boolean isWall(int col, int row){
        return window.getGrid()[row][col];
    }

    public boolean isBox(int col, int row){
        return boxGrid[row][col];
    }

    public void move(GameObject gameObject, Direction direction){
        int col = gameObject.getCol();
        int row = gameObject.getRow();
        gameObject.setLastPosition(col, row);
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


    }

    public  void updatePosition(GameObject gameObject, int wayX, int wayY){
        gameObject.picture.translate(Window.getCellSize() * wayX, Window.getCellSize() * wayY);
        gameObject.setPosition(gameObject.getCol() + wayX, gameObject.getRow() + wayY);


    }

    public void updateBox(GameObject gameObject){
        boxGrid[gameObject.lastRow][gameObject.lastCol] = false;
        boxGrid[gameObject.row][gameObject.col] = true;
        onPlace();
        levelStatus();
    }

    // checks if boxes are stored
    public void onPlace(){
        for(int i = 0; i < boxes.length; i++){
            for(int j = 0; j < storagePoints.length; j++){
                if(boxes[i].getCol() == storagePoints[j].getCol() && boxes[i].getRow() == storagePoints[j].getRow()){
                    boxes[i].picture.load("resources/box1.png");
                    boxes[i].setStored(true);
                    break;
                } else if(boxes[i].isStored()){
                    boxes[i].picture.load("resources/box2.png");
                    boxes[i].setStored(false);
                }
            }
        }

    }

    public boolean levelStatus(){

        for(int i = 0; i < boxes.length; i++){
            if (!boxes[i].isStored()){
                levelComplete = false;
                return false;
            }
        }
        levelComplete = true;
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
        deleteBoxes();
        deleteStorage();
        createLabel();
        createStorage();
        spawnBoxes();
        createPlayer();

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
            System.out.println("ctrl z");
            undo();
        }
        if(e.getKey() == KeyboardEvent.KEY_SPACE){
            if(levelComplete){
                level++;
                Window.deleteWall();
                Window.createWalls(level);
                resetLevel();
                levelComplete = false;
                picture.delete();
                System.out.println("Space pressed");
            }
            System.out.println("Space pressed");
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
