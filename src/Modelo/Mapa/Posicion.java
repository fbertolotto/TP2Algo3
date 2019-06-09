package Modelo.Mapa;

import java.util.Objects;

public class Posicion {
    private int posX;
    private int posY;

    public Posicion(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Posicion posicion = (Posicion) objeto;
        return posX == posicion.posX && posY == posicion.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

}