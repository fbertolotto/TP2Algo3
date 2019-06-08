package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;

public class PicoFino extends Pico {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.formaDesgaste = new DesgasteLineal(10);
       }


    @Override
    public void desgastar() {
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        this.durabilidad -= desgaste;
    }
}
