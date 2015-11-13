package org.academia.cadet.CodingBad;

import java.util.Scanner;

/**
 * Created by cadet on 23/09/15.
 */
public class CrystalShip {

    private int codeStock;
    private int bugsStock;

    private Storage storage = new Storage();

    Player player1;

    CrystalShip (Player player){

         player1 = player;


    }

    public void coding() {


        Scanner scan = new Scanner(System.in);
        Scanner scanTest = new Scanner(System.in);

        System.out.println("Let's cook so me code! How many hours do you want to cook?");

        int hours = scan.nextInt();

        System.out.println("Do you want to do the code with testing?");

        String testing = scanTest.nextLine();

        if (testing.equals("yes")){

            if (player1.getStamina() > (15 * hours)){

                int codeCooked = 0;
                double bugs = 0;
                double fatigue = 0;
                int codeTotal = 0;
                int bugsTotal = 0;


                for(int i = 0; i < hours; i++){

                    codeCooked += 7;
                    bugs += Math.floor(Math.random() * 2);
                    fatigue += 0.3;
                    player1.decreaseStamina(10);

                }

                codeTotal+= codeCooked;
                bugsTotal += (int)bugs + (int)fatigue;

                Batch batch = new Batch(codeTotal, bugsTotal);


                System.out.println("You have cooked " + codeTotal + " lines of code, with " + bugsTotal + " bugs. The purity of your code is " + batch.getPurity() + "%. Your stamina is now " + player1.getStamina());
                System.out.println("What now?");

                nextAction(batch);
            }else{

                System.out.println("You don't have enough energy. Go get some sleep or grab a bite.");
            }




        } else {

            if (player1.getStamina() > (5 * hours)){

                int codeCooked = 0;
                double bugs = 0;
                double fatigue = 0;
                int codeTotal = 0;
                int bugsTotal = 0;

                for(int i = 0; i < hours; i++){

                    codeCooked += 20;
                    bugs += Math.floor(Math.random() * 10);
                    fatigue += 0.7;
                    player1.decreaseStamina(5);

                }

                codeTotal+= codeCooked;
                bugsTotal += (int)bugs + (int)fatigue;

                Batch batch = new Batch(codeTotal, bugsTotal);


                System.out.println("You have cooked " + codeTotal + " lines of code, with " + bugsTotal + " bugs. The purity of your code is " + batch.getPurity() + "%. Your stamina is now " + player1.getStamina());
                System.out.println("What now?");

                nextAction(batch);
            }else{

                System.out.println("You don't have enough energy. Go get some sleep or grab a bite.");
            }



        }

    }

    public void nextAction(Batch batch){

        Scanner nextActionScanner = new Scanner(System.in);
        String nextAction = nextActionScanner.nextLine();

        if(nextAction.equals("store")) {

            storage.store(batch);

            System.out.println(batch.getCode() + " lines of code were stored!");

        } else if(nextAction.equals("take")){


            player1.storeInBag(batch);
            System.out.println(batch.getCode() + " lines of code were add to your bag!");

        }else {

            System.out.println("Something is wrong.");
            nextAction(batch);
        }

    }

    public void getStorageInfo(){

        storage.getCodeInfo();
    }
}
