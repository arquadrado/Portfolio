package org.academia.cadet.CodingBad;

import java.util.Scanner;

/**
 * Created by cadet on 23/09/15.
 */
public class Storage {

    private int purity;
    private int[] shelfs = new int[6];

    Storage(){


    }


    public void store(Batch batch){

        int purity = 100 - ((batch.getBugs() * 100) / batch.getCode());

        if(purity > 90){

            shelfs[0] += batch.getCode();
            shelfs[1] = 100 - ((batch.getBugs() * 100) / batch.getCode());

        } else if(purity > 80){

            shelfs[2] += batch.getCode();
            shelfs[3] = 100 - ((batch.getBugs() * 100) / batch.getCode());
        } else{

            shelfs[4] += batch.getCode();
            shelfs[5] = 100 - ((batch.getBugs() * 100) / batch.getCode());
        }

    }

    public void getCodeInfo() {

        System.out.println("Which quality of code you want to check? (top, good, shit)");

        Scanner scan = new Scanner(System.in);
        String selectBatch = scan.nextLine();

        switch (selectBatch){

            case "top":

                if(shelfs[0]<= 0){
                    System.out.println("You don't have any top quality code.");
                }else{
                    System.out.println("You have " + shelfs[0] + " lines of code with a purity of " + shelfs[1] + "%." );
                }

                break;
            case "good":

                if(shelfs[2]<= 0){
                    System.out.println("You don't have any good quality code.");
                }else{
                    System.out.println("You have " + shelfs[2] + " lines of code with a purity of " + shelfs[3] + "%." );
                }

                break;
            case "shit":

                if(shelfs[4]<= 0){
                    System.out.println("You don't have any shitty quality code.");
                }else{
                    System.out.println("You have " + shelfs[4] + " lines of code with a purity of " + shelfs[5] + "%." );
                }

                break;
            default:
                System.out.println("Whaaaaat?");
                getCodeInfo();
        }

    }
}
