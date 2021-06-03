/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.mooer.src.mooer;

import javax.swing.*;

/**
 * @author Evistix
 */
public class CardsCreat {//构建骑士卡牌数组

    CardsCreat() {
        for( int i = 1; i <= 60; i++ ){
            Golbal.cardsList[i].image = new ImageIcon( getClass().getClassLoader().getResource( "img/" + i + ".jpg" ) );
            if( i <= 20 ){
                Golbal.cardsList[i].type = "水";
                Golbal.cardsList[i].var = i;
            }
            if( i <= 40 && i > 20 ){
                Golbal.cardsList[i].type = "木";
                Golbal.cardsList[i].var = i - 20;
            }
            if( i <= 60 && i > 40 ){
                Golbal.cardsList[i].type = "火";
                Golbal.cardsList[i].var = i - 40;
            }
        }
    }
}
