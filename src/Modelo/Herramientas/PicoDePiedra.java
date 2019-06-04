package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.*;

public class PicoDePiedra extends Pico {

    public PicoDePiedra() {
        this.durabilidad = 200;
        this.fuerza = 4;
        this.formaDesgaste = new DesgasteLineal(1.5f);
    }

}



