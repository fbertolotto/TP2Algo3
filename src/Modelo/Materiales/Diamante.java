package Modelo.Materiales;

import Modelo.Desgaste.DesgasteLineal;

public class Diamante extends Material {

	public Diamante() {
		formaDesgaste = new DesgasteLineal(1,100);
		nombre = "Diamante";
		rutaImagen = "media/images/diamante.png/";
	}

}

