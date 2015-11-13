package org.academia.cadet.CodingBad;

/**
 * Created by cadet on 23/09/15.
 */
public class Batch {

    private int code;
    private int bugs;
    private int purity;

    Batch(int code, int bugs){

        this.code = code;
        this.bugs = bugs;
        this.purity = 100 - ((bugs * 100) / code);
    }

    public int getPurity() {
        return purity;
    }

    public int getCode() {
        return code;
    }

    public int getBugs() {
        return bugs;
    }
}
