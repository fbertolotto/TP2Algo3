package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteUsos;

public class PicoDeMetal extends Pico {

    public PicoDeMetal() {
        this.durabilidad = 400;
        this.fuerza = 12;
        this.formaDesgaste = new DesgasteUsos();
        this.formaDesgaste.setUsosmaximos(10);
    }

    @Override
    public void usar() {
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        this.durabilidad -= desgaste;
    }
}
