package de.kohnlehome;

import java.util.Date;

public class Lottotip {

    private ILottozahlen lottozahlen;

    public Lottotip(ILottozahlen lottozahlen) {
        this.lottozahlen = lottozahlen;
    }

    public int tippAbgeben(int[] tipp, Date date){
        int rightTipp = 0;
        int[] zahlen = lottozahlen.getLottozahlen(date);

        for(int i:zahlen){
            for(int y:tipp){
                if(i==y){
                    rightTipp++;
                }
            }
        }
        return rightTipp;
    }


}
