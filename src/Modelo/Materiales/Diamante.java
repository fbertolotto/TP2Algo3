package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Diamante extends Material {

	public Diamante() {
		formaDesgaste = new DesgasteLineal(1,100);
		nombre = "Diamante";
		rutaImagen = "images/diamante.png/";
	}

	public void desgastar(PicoFino picoFino) throws DurabilidadAgotadaException {
		formaDesgaste.desgastar(picoFino.getFuerza());
	}

}

