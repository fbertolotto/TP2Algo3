package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Materiales.*;

public abstract class Pico extends Herramienta {

    public void usar(Piedra piedra) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        piedra.desgastar(this);
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }

    public void usar(Material material) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }
}
