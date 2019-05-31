package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;

public class PicoDeMadera extends Pico {

    public PicoDeMadera() {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.formaDesgaste = new DesgasteLineal();
    }

}
