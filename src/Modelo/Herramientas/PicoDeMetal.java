package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.Desgaste.DesgasteUsos;
import Modelo.Materiales.Material;

public class PicoDeMetal extends Pico {

    public PicoDeMetal() {
        this.durabilidad = 400;
        this.fuerza = 12;
        this.formaDesgaste = new DesgasteUsos(10);
    }

    @Override
    public void usar(Material material) throws DurabilidadAgotadaException {
        if (this.durabilidad == 0) throw new DurabilidadAgotadaException();
        material.desgastar(this);
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        this.durabilidad -= desgaste;
    }
}
