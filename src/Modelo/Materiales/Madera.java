package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Madera extends Material {

	public Madera() {
		formaDesgaste = new DesgasteLineal(1,10);
		nombre = "Madera";
		rutaImagen = "images/madera.png/";
	}

	public void desgastar(Hacha hacha) throws DurabilidadAgotadaException {
		formaDesgaste.desgastar(hacha.getFuerza());
	}

}


