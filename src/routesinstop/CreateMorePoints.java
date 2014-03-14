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
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanhaohu
 */
public class CreateMorePoints {
    private String fileroot;
    private String filename;
    private int timesmore;
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    int k = 0,o = 0;
    public CreateMorePoints(String fileroot,String filename, int number){
        this.fileroot = fileroot;
        this.filename = filename;
        this.timesmore = number;
    }
    public void run() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter ("/Users/yanhaohu/Documents/CS/Morepoints/"+"More"+filename);
        float a1=0 ,b1 =0;
        try {
            br = new BufferedReader(new FileReader(fileroot+filename));
            while ((line = br.readLine()) != null) {
                o++;
                // use comma as separator
                String[] location = line.split(cvsSplitBy);
                float a0 = Float.parseFloat(location[0]);
                float b0 = Float.parseFloat(location[1]);
                if (a1!=0 && b1!=0) {
                    timesmore = (int) Math.ceil((float) Math.sqrt(Math.pow((a0-a1),2)+Math.pow((b0-b1),2))/0.0001);
                    for (int i = 0; i < timesmore; i++) {
                        k++;
                        float a = (a0-a1)/timesmore*i+a1;
                        float b = (b0-b1)/timesmore*i+b1;
                        writer.println(k+","+a+","+b);
                    }
                }
                    a1 = a0;
                    b1 = b0;
            }
            writer.close();
            br.close();
            System.out.println(o+","+k);
        } catch (IOException ex) {
            Logger.getLogger(CreateMorePoints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
