package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.Desgaste;
import Modelo.Materiales.Material;

public abstract class Herramienta {
    protected float durabilidad;
    protected int fuerza;
    protected Desgaste formaDesgaste;

    public float getDurabilidad() {
        return this.durabilidad;
    }

    public int getFuerza() {
        return this.fuerza;
    }

    public void usar(Material material) {
        if (this.durabilidad == 0) return;
        material.desgastar(this);
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }
}
