package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.Desgaste.DesgasteUsos;

public class PicoDeMetal extends Pico {

    public PicoDeMetal() {
        this.durabilidad = 400;
        this.fuerza = 12;
        this.formaDesgaste = new DesgasteUsos(10);
    }

    @Override
    public void desgastar() throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        this.durabilidad -= desgaste;
    }
}
