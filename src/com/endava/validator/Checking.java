package com.endava.validator;

import com.endava.entitybooks.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 3/20/2017
 */
public class Checking {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private double pureCost;

    public double digitCheck(){
        boolean done = true;
        String digitSTR = "";

        while (done){
            boolean created = false;

            try {
                digitSTR = reader.readLine();
                created = true;
            } catch (IOException e) {
                System.out.println("Illegal number, please set again");
            }

            for (int i = 0; i < digitSTR.length(); i++) {
                if (!Character.isDigit(digitSTR.charAt(i))){
                    System.out.println("Illegal number, please set again");
                    created = false;
                    break;
                }
            }

            if (created) done = false;
        }

        return Double.parseDouble(digitSTR);
    }

    public int pagesSet(){
        return (int)digitCheck();
    }

    public double popularitySet() throws IOException {
        double popularity = 0;
        boolean done = true;

        while (done){
            popularity = digitCheck();
            if (popularity >= 0 && popularity <= 10) done = false;
            else if (popularity < 0 || popularity > 10) {
                System.out.println("Illegal level of popularity, please set again");
                done = true;
            }
        }

        return popularity;
    }

    public int yearSet() throws IOException{
        return (int) digitCheck();
    }

    public double costSet(double popularity, GeneralBook generalBook) throws IOException {
        double cost = digitCheck();

        setPureCost(cost);

        if (popularity == 0 && !(generalBook instanceof FictionBook)) {
            Random random = new Random();
            cost = cost * 0.9 * random.nextInt(2);
        }
        else if (popularity < 4) cost = cost * 0.9;
        else if (popularity == 8 || popularity == 9) cost = cost * 1.1;
        else if (popularity > 9) cost = cost * 1.1 + cost * 0.1 + (cost * 1.1) * 0.1;

        return cost;
    }

    public double getPureCost() {
        return pureCost;
    }

    public void setPureCost(double pureCost) {
        this.pureCost = pureCost;
    }
}
