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
    private Storage[] storagePoints;
    private Keyboard keyboard;
    private CollisionDetector collisionDetector;
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

        createCollisionDetector();



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
                boxes[1] = new Box(7, 5, window.getCellSize());
                boxes[2] = new Box(7, 6, window.getCellSize());
                boxes[3] = new Box(5, 6, window.getCellSize());
                boxes[4] = new Box(5, 9, window.getCellSize());
                boxes[5] = new Box(2, 9, window.getCellSize());
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

    }

    public void createCollisionDetector(){

        collisionDetector = new CollisionDetector(boxes);
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

                storagePoints[0] = new Storage(10, 6, window.getCellSize());
                storagePoints[1] = new Storage(9, 6, window.getCellSize());
                storagePoints[2] = new Storage(10, 7, window.getCellSize());
                storagePoints[3] = new Storage(9, 7, window.getCellSize());
                storagePoints[4] = new Storage(8, 7, window.getCellSize());
                storagePoints[5] = new Storage(10, 8, window.getCellSize());
                storagePoints[6] = new Storage(9, 8, window.getCellSize());
                storagePoints[7] = new Storage(8, 8, window.getCellSize());
                storagePoints[8] = new Storage(10, 9, window.getCellSize());
                storagePoints[9] = new Storage(9, 9, window.getCellSize());
                storagePoints[10] = new Storage(8, 9, window.getCellSize());
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

        KeyboardEvent[] event = new KeyboardEvent[6];

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

    public boolean checkSurroundings(){
        return false;
    }
    public Box boxNext(Direction direction){
        Box boxToReturn = null;
        for(int i = 0; i < boxes.length; i++){
            switch (direction){
                case UP:
                    if(boxes[i].getCol() == player.getCol() && boxes[i].getRow() == player.getRow() - 1)
                         boxToReturn = boxes[i];
                    break;
                case DOWN:
                    if(boxes[i].getCol() == player.getCol() && boxes[i].getRow() == player.getRow() + 1)
                        boxToReturn = boxes[i];
                    break;
                case RIGHT:
                    if(boxes[i].getCol() == player.getCol() + 1 && boxes[i].getRow() == player.getRow())
                        boxToReturn = boxes[i];
                    break;
                case LEFT:
                    if(boxes[i].getCol() == player.getCol() - 1 && boxes[i].getRow() == player.getRow())
                        boxToReturn = boxes[i];
                    break;
            }
        }
        return boxToReturn;
    }
    public boolean canMove(GameObject gameObject, Direction direction){
        if(gameObject.getId() == ID.PLAYER){
            switch (direction){
                case UP:
                    if(isWall(gameObject.getCol(), gameObject.getRow() - 1)){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
                case DOWN:
                    if(isWall(gameObject.getCol(), gameObject.getRow() + 1)){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
                case RIGHT:
                    if(isWall(gameObject.getCol() + 1, gameObject.getRow())){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
                case LEFT:
                    if(isWall(gameObject.getCol() - 1, gameObject.getRow())){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
            }
        }
        else if(gameObject.getId() != null){
            switch (direction){
                case UP:
                    if(isWall(gameObject.getCol(), gameObject.getRow() - 1)){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){ //check if there's another box, replace
                        return false;
                    } else {
                        return true;
                    }
                case DOWN:
                    if(isWall(gameObject.getCol(), gameObject.getRow() + 1)){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
                case RIGHT:
                    if(isWall(gameObject.getCol() + 1, gameObject.getRow())){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
                case LEFT:
                    if(isWall(gameObject.getCol() - 1, gameObject.getRow())){
                        return false;
                    } else if(!canMove(boxNext(direction), direction)){
                        return false;
                    } else {
                        return true;
                    }
            }

        }
        return false;
    }

    public boolean isWall(int col, int row){
        if(window.getGrid()[row][col]){
            return  true;
        } else {
            return false;
        }
    }

    //  checks if object is over a wall
    public boolean overWall(boolean[][] grid, int row, int col){
        if(grid[row][col]){
            //System.out.println("I'm on top of the wall");
            return true;
        } else{
            return false;
        }
    }

    // checks if player is colliding with a box
    public boolean checkCollision(Box box) {
        if (box.getCol() == player.getCol() && box.getRow() == player.getRow()) {
           // System.out.println("I'm on top of a box.");
            return true;
        } else {
            box.setJustMoved(false);
            return false;
        }
    }

    // checks the direction of the collision
    public void checkCollisionDirection() {

        for(int i = 0; i < boxes.length; i++){

            if(checkCollision(boxes[i])){
                //System.out.println("We are in the same position");
                //System.out.println("==========================================");

                if(player.getLastRow() == boxes[i].getRow() - 1 && player.getLastCol() == boxes[i].getCol()){

                    if(collisionDetector.hasBox(boxes[i].getCol(), boxes[i].getRow() + 1) || overWall(window.getGrid(), boxes[i].getRow() + 1, boxes[i].getCol())){
                        moveBox(boxes[i], 0, 0);
                        boxes[i].setJustMoved(false);
                    }else{
                        moveBox(boxes[i], 0, 1);
                        boxes[i].setJustMoved(true);
                    }

                }
                else if(player.getLastRow() == boxes[i].getRow() + 1 && player.getLastCol() == boxes[i].getCol()){
                    if(collisionDetector.hasBox(boxes[i].getCol(), boxes[i].getRow() - 1) || overWall(window.getGrid(), boxes[i].getRow() - 1, boxes[i].getCol())){
                        moveBox(boxes[i], 0, 0);
                        boxes[i].setJustMoved(false);
                    }else{
                        moveBox(boxes[i], 0, -1);
                        boxes[i].setJustMoved(true);
                    }
                }
                else if(player.getLastCol() == boxes[i].getCol() - 1 && player.getLastRow() == boxes[i].getRow()){
                    if(collisionDetector.hasBox(boxes[i].getCol() + 1, boxes[i].getRow()) || overWall(window.getGrid(), boxes[i].getRow(), boxes[i].getCol() + 1)){
                        moveBox(boxes[i], 0, 0);
                        boxes[i].setJustMoved(false);
                    }else{
                        moveBox(boxes[i], 1, 0);
                        boxes[i].setJustMoved(true);
                    }

                }
                else if(player.getLastCol() == boxes[i].getCol() + 1 && player.getLastRow() == boxes[i].getRow()){
                    if(collisionDetector.hasBox(boxes[i].getCol() - 1, boxes[i].getRow()) || overWall(window.getGrid(), boxes[i].getRow(), boxes[i].getCol() - 1)){
                        moveBox(boxes[i], 0, 0);
                        boxes[i].setJustMoved(false);
                    }else{
                        moveBox(boxes[i], -1, 0);
                        boxes[i].setJustMoved(true);
                    }
                }
            }

        }
    }

    // move box
    public void moveBox(Box box, int wayX, int wayY) {
        box.picture.translate(wayX * window.getCellSize(), wayY * window.getCellSize());
        box.setLastRow(box.getRow());
        box.setLastCol(box.getCol());
        box.setCol(box.getCol() + wayX);
        box.setRow(box.getRow() + wayY);
        totalPushes++;
        pushes++;
        updateLabel();
        onPlace();
        levelStatus();
        // System.out.println("Box Current col: " + box.getCol() + " Current Box row: " + box.getRow());
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
    // checks if player can move
    public boolean canMove(int wayX, int wayY){

        if( collisionDetector.hasBox(player.getCol() + 1 * wayX, player.getRow() + 1 * wayY) &&
            collisionDetector.hasBox(player.getCol() + 2 * wayX, player.getRow() + 2 * wayY)) {

            return false;
        } else if(collisionDetector.hasBox(player.getCol() + 1 * wayX, player.getRow() + 1 * wayY) &&
                overWall(window.getGrid(), player.getRow() + 2 * wayY, player.getCol() + 2 * wayX )){
            return false;
        } else {
            return true;
        }


    }

    // move player
    public void movePlayer(int wayX, int wayY){
        if(!canUndo)canUndo = true;
        player.picture.translate(window.getCellSize() * wayX, window.getCellSize() * wayY);
        player.setLastRow(player.getRow());
        player.setLastCol(player.getCol());
        player.setCol(player.getCol() + 1 * wayX);
        player.setRow(player.getRow() + 1 * wayY);
        moves++;
        totalMoves++;
        updateLabel();
        printPositions();
    }

    // print player's current position and last position
    public void printPositions(){
        System.out.println("Current col: " + player.getCol() + " Current row: " + player.getRow());
        System.out.println("Last col: " + player.getLastCol() + " Last row: " + player.getLastRow());
        System.out.println("==========================================");

    }

    public void resetLevel(){
        pushes = 0;
        moves = 0;
        if(levelComplete){
            picture.delete();
        }
        label.delete();
        player.picture.delete();
        deleteBoxes();
        deleteStorage();
        createLabel();
        createStorage();
        spawnBoxes();
        createCollisionDetector();
        createPlayer();

    }

    public void undo(){
        
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if(e.getKey() == KeyboardEvent.KEY_W){


            if(overWall(window.getGrid(), player.getRow() - 1, player.getCol())){
                player.picture.translate(0, 0);

            } else if(canMove(0, -1)){
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "top1.png", "resources/" + player.chooseChar() +"top2.png"));
                movePlayer(0, -1);
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_S){


            if(overWall(window.getGrid(), player.getRow() + 1, player.getCol())){
                player.picture.translate(0, 0);
            } else if(canMove(0, 1)){
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "bot1.png", "resources/" + player.chooseChar() + "bot2.png"));
                movePlayer(0, 1);
            }

        }
        if(e.getKey() == KeyboardEvent.KEY_A){


            if(overWall(window.getGrid(), player.getRow(), player.getCol() - 1)){
                player.picture.translate(0, 0);
            } else if(canMove(-1, 0)){
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "left1.png", "resources/" + player.chooseChar() + "left2.png"));
                movePlayer(-1, 0);
            }
        }
        if(e.getKey() == KeyboardEvent.KEY_D){


            if(overWall(window.getGrid(), player.getRow(), player.getCol() + 1)){
                player.picture.translate(0, 0);
            } else if(canMove(1, 0)){
                player.picture.load(player.changeFrame("resources/" + player.chooseChar() + "right1.png", "resources/" + player.chooseChar() + "right2.png"));
                movePlayer(1, 0);
            }
        }
        checkCollisionDirection();

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
                window.deleteWall();
                window.createWalls(level);
                resetLevel();
                levelComplete = false;
            }
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
