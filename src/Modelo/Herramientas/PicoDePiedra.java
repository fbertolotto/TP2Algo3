package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.Desgaste.*;
import Modelo.Materiales.*;

public class PicoDePiedra extends Pico {

    public PicoDePiedra() {
        this.durabilidad = 200;
        this.fuerza = 4;
        this.formaDesgaste = new DesgasteLineal(1.5f);
    }

    public void usar(Metal metal) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        metal.desgastar(this);
        float desgaste = this.formaDesgaste.desgastar(this.fuerza);
        this.durabilidad -= desgaste;
    }

}



