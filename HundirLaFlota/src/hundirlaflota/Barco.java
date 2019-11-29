/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

/**
 *
 * @author alberto
 */
public class Barco {
    private int Tamaño;
    private boolean Hundido = false;
    private int PosX;
    private int PosY;
    private int d;

    public int getTamaño() {
        return Tamaño;
    }

    public void setTamaño(int Tamaño) {
        this.Tamaño = Tamaño;
    }

    public boolean isHundido() {
        return Hundido;
    }

    public void setHundido(boolean Hundido) {
        this.Hundido = Hundido;
    }

    public int getPosX() {
        return PosX;
    }

    public void setPosX(int PosX) {
        this.PosX = PosX;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int PosY) {
        this.PosY = PosY;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
