package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
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

}
