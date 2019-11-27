/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Tablero {
    
    public String casillas[][] = new String[10][10];
    private ArrayList<Barco> barco;
    private int TirosReal;
    private int BarcosRes;
    
    Tablero(ArrayList<Barco> bar){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                casillas[i][j] = "~";
            }
        }
        barco = bar;
        TirosReal = 0;
        BarcosRes = 0;
    }

    public int getTirosReal() {
        return TirosReal;
    }

    public void setTirosReal(int TirosReal) {
        this.TirosReal = TirosReal;
    }

    public int getBarcosRes() {
        return BarcosRes;
    }

    public void setBarcosRes(int BarcosRes) {
        this.BarcosRes = BarcosRes;
    }
}
