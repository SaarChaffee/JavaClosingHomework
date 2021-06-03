/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mooer;

import javax.swing.ImageIcon;


/**
 *
 * @author Evistix
 */
//Evistix
public class Golbal{//全局变量
    public static Cards [] cardsList= new Cards[61];//骑士卡牌数组
    static {
        for(int i = 0; i < 61; i++) {
            cardsList[i] = new Cards();
        }
    }
   
}