package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;

public class HachaDePiedra extends Hacha {

    public HachaDePiedra() {
        this.durabilidad = 200;
        this.fuerza = 5;
        this.formaDesgaste = new DesgasteLineal();
    }
}
