package org.academia.cadet.CodingBad;

import java.util.Scanner;

/**
 * Created by cadet on 23/09/15.
 */
public class World {

    // player instance
    private Player player = new Player();

    // places instances
    private Home home = new Home(player);
    private CrystalShip crystalShip = new CrystalShip(player);


    private boolean running;

        World () {




        }


    // World methods
    public void start(){

        running = true;

        System.out.println("You just entered the world of Coding Bad!");

        while(running){

            System.out.println("What do you want to do?(command list: commands)");

            Scanner scan = new Scanner(System.in);

            String actionTrigger = scan.nextLine();

            if(actionTrigger.equals("commands")){




                if(player.getCurrentLocation() == Place.HOME){

                    System.out.println("goto");
                    System.out.println("sleep");
                    System.out.println("check bag");
                    System.out.println("stop");
                }else if(player.getCurrentLocation() == Place.CRYSTALSHIP){

                    System.out.println("goto");
                    System.out.println("cook");
                    System.out.println("check bag");
                    System.out.println("check storage");
                    System.out.println("stop");
                } else {

                    System.out.println("goto");
                    System.out.println("check bag");
                    System.out.println("stop");

                }
            }

            if(actionTrigger.equals("stop")){

                stop();
            }
            if (actionTrigger.equals("goto")){

                player.goTo();
            }
            if (actionTrigger.equals("cook")){

                player.cook(crystalShip);
            }
            if (actionTrigger.equals("check bag")){

                player.checkBag();
            }
            if(actionTrigger.equals("check storage")){

                player.checkStorage(crystalShip);
            }
            if(actionTrigger.equals("sleep")){

                player.sleep();
            }


        }

    }

    public void stop(){

        System.out.println("Leaving this world...");
        running = false;
    }


}


