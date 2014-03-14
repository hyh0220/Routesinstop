/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package routesinstop;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author yanhaohu
 */
public class RoutesInStop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CreateMorePoints P = new CreateMorePoints("/Users/yanhaohu/Documents/CS/","redRoutePoints1.txt",5);
        P.run();
        WhatTimeArrive W = new WhatTimeArrive("/Users/yanhaohu/Desktop/output/20140306red.txt","/Users/yanhaohu/Documents/CS/Morepoints/MoreredRoutePoints1.txt");
        W.run();
    }
    
}
