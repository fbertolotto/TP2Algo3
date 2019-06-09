package Modelo.Mapa;

public class Posicion {
    private int posX;
    private int posY;

    public Posicion(int posX, int posY) {
        posX = posX;
        posY = posY;
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

}