package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;

public class HachaDeMetal extends Hacha {

    public HachaDeMetal() {
        this.durabilidad = 400;
        this.fuerza = 10;
        this.formaDesgaste = new DesgasteLineal();
        this.formaDesgaste.setDivisor(2);
    }
}