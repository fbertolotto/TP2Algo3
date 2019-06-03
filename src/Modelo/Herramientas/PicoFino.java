package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.DesgasteLineal;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;

public class PicoFino extends Pico {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.formaDesgaste = new DesgasteLineal();
        this.formaDesgaste.setDivisor(10);
    }

    @Override
    public void usar(Material material) {
        if (this.durabilidad == 0) return;
        material.desgastar(this);
        if (material.getClass() != Diamante.class) return;
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        durabilidad -= desgaste;
    }
}
