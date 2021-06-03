/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mooer;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Evistix
 */

public class Mooer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ImgTest().setVisible(true);
        ChangeImg.changeImg(ImgTest.jLabel1, 8);
    }
    
}
