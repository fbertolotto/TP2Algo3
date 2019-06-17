package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.*;
import Modelo.Materiales.*;

public class PicoDePiedra extends Pico {

	public PicoDePiedra() {
		fuerza = 4;
		formaDesgaste = new DesgasteLineal(1.5f, 200);
		nombre = "Pico de Piedra";
		rutaImagen = "media/images/picodepiedra.png/";
	}

	public void usar(Metal metal) throws DurabilidadAgotadaException {
		metal.desgastar(this);
		formaDesgaste.desgastar(fuerza);
	}

}



