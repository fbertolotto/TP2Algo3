package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.Desgaste.DesgasteLineal;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;
import Modelo.Materiales.*;

public class PicoFino extends Pico {

    public PicoFino() {
        this.durabilidad = 1000;
        this.fuerza = 20;
        this.formaDesgaste = new DesgasteLineal(10);
       }


    public void usar(Diamante diamante) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        diamante.desgastar(this);
        float desgaste = this.formaDesgaste.desgastar(this.durabilidad);
        this.durabilidad -= desgaste;
    }

    public void usar(Piedra piedra) throws DurabilidadAgotadaException {
        if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
        piedra.desgastar(this);
    }

    @Override
    public void usar(Material material) throws DurabilidadAgotadaException {}




}
