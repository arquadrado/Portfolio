package org.academia.cadet.CodingBad;

import java.util.Scanner;

/**
 * Created by cadet on 23/09/15.
 */
public class Player {

    private Place currentLocation = Place.HOME;
    private Bag bag = new Bag();
    private int stamina = 100;

    // decrease player's stamina
    public void decreaseStamina(int rate){

        stamina -= rate;
    }

    // sleep, gain stamina
    public void sleep(){


        if(currentLocation != Place.HOME){

            System.out.println("You aren't at the Crystal Ship, how the hell do you want to cook?");

        } else {

            System.out.println("How many hours you want to sleep?");
            Scanner scan = new Scanner(System.in);
            int hoursOfSleep = scan.nextInt();

            for (int i = 0; i < hoursOfSleep; i++){

                stamina += 6;
            }

            System.out.println("Your stamina is now " + stamina);
        }



    }

    public int getStamina() {
        return stamina;
    }

    // change player location
    public void goTo(){

        System.out.println("Where do you want to go? (command list: commands)");

        Scanner scan = new Scanner(System.in);

        String place = scan.nextLine();

        switch(place){

            case "commands":
                System.out.println("home");
                System.out.println("crystal ship");
                System.out.println("albuquerque");
                System.out.println("desert");
                System.out.println("carwash");
                System.out.println("saulgoodman");
                System.out.println("lospollos");
                goTo();
                break;

            case "home":
                currentLocation = Place.HOME;
                System.out.println("You are now at home.");
                break;

            case "crystal ship":
                currentLocation = Place.CRYSTALSHIP;
                System.out.println("You are now at The Crystal Ship.");
                break;

            case "albuquerque":
                currentLocation = Place.ALBUQUERQUE;
                System.out.println("You are now at Albuquerque.");
                break;

            case "desert":
                currentLocation = Place.DESERT;
                System.out.println("You are now at the desert.");
                break;

            case "carwash":
                currentLocation = Place.A1ACARWASH;
                System.out.println("You are now at the car wash.");
                break;

            case "saul goodman":
                currentLocation = Place.SAULGOODMAN;
                System.out.println("You are now at Saul Goodman's office.");
                break;

            case "los pollos":
                currentLocation = Place.LOSPOLLOSHERMANOS;
                System.out.println("You are now at Los Pollos Hermanos.");
                break;

        }


    }

    public Place getCurrentLocation() {
        return currentLocation;
    }

    public void cook(CrystalShip crystalShip){

        if(currentLocation != Place.CRYSTALSHIP){

            System.out.println("You aren't at the Crystal Ship, how the hell do you want to cook?");

        } else {
            crystalShip.coding();
        }


    }

    public void storeInBag(Batch batch){

        bag.addtoBag(batch.getCode(), batch.getBugs());

    }

    public void checkBag(){

        bag.checkBag();
    }

    public void checkStorage(CrystalShip crystalShip){

        if(currentLocation != Place.CRYSTALSHIP){

            System.out.println("You aren't at the Crystal Ship, how the hell do you want to cook?");

        } else {
            crystalShip.getStorageInfo();
        }


    }

}
