package Modelo.Herramientas;

import Modelo.Herramientas.Desgaste.Desgaste;

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

    public void usar() {
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }
}
