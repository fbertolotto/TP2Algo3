package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.*;
import Modelo.Materiales.*;

public class PicoDePiedra extends Pico {

	public PicoDePiedra() {
		this.fuerza = 4;
		this.formaDesgaste = new DesgasteLineal(1.5f, 200);
	}

	public void usar(Metal metal) throws DurabilidadAgotadaException {
		metal.desgastar(this);
		this.formaDesgaste.desgastar(this.fuerza);
	}

}



