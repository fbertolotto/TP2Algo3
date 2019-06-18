package Modelo.Materiales;

import Modelo.Desgaste.DesgasteLineal;

public class Madera extends Material {

	public Madera() {
		formaDesgaste = new DesgasteLineal(1,10);
		nombre = "Madera";
	}

}


