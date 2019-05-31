package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;

public class HachaDeMadera extends Hacha {

    public HachaDeMadera() {
        this.durabilidad = 100;
        this.fuerza = 2;
        this.formaDesgaste = new DesgasteLineal();
    }
}
