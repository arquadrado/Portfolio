package org.academia.cadet.CodingBad;

/**
 * Created by cadet on 23/09/15.
 */
public class Bag {

    private int codePocket = 0;
    private int bugsInCode = 0;

    public void addtoBag(int code, int bugs){

        codePocket += code;
        bugsInCode += bugs;
    }

    public void checkBag(){

        System.out.println("You have " + codePocket + " lines of code in your bag.");
    }



}
