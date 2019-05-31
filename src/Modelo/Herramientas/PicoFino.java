package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;

public class PicoFino extends Pico {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.formaDesgaste = new DesgasteLineal();
        this.formaDesgaste.setDivisor(10);
    }

    @Override
    public void usar() {
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        durabilidad -= desgaste;
    }
}
