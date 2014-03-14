/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package routesinstop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yanhaohu
 */
public class WhatTimeArrive {
    private String data;
    private String stoplocation;
    BufferedReader brData = null;
    BufferedReader brStop = null;
    String line = "",line2 = "";
    String cvsSplitBy = ",";
    float distance = 0;
    float oldDis = 100;
    String i ="";
    public WhatTimeArrive(String data,String stoplocation){
        this.data = data;
        this.stoplocation = stoplocation;   
    }
    public void run() throws FileNotFoundException, IOException{
        brData = new BufferedReader(new FileReader(data));
            while ((line = brData.readLine()) != null) {
                String[] CarLocation = line.split(cvsSplitBy);
                float a0 = Float.parseFloat(CarLocation[3]);
                float b0 = Float.parseFloat(CarLocation[4]);
                //System.out.println(a0+","+b0);
                brStop = new BufferedReader(new FileReader(stoplocation));
                while ((line2 = brStop.readLine()) != null) {
                    String[] StopLocation = line2.split(cvsSplitBy);
                    float a1 = Float.parseFloat(StopLocation[1]);
                    float b1 = Float.parseFloat(StopLocation[2]);
                    distance = (float) (Math.pow((a0-a1),2)+Math.pow((b0-b1),2));
                    //System.out.println(distance+","+StopLocation[0]);
                    if (distance<oldDis) {
                        oldDis = distance;
                        i = StopLocation[0];
                    }
                }
                brStop.close();
                System.out.println(i);
                oldDis = 100;
                
            }
            brData.close();
    }
}
