package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Materiales.*;

public abstract class Hacha extends Herramienta {

    public void usar(Madera madera) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        madera.desgastar(this);
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }

    public void usar(Material material) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }
}
