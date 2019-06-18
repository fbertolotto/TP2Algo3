package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class HachaDeMadera extends Hacha {

	public HachaDeMadera() {
		fuerza = 2;
		formaDesgaste = new DesgasteLineal(1, 100);
		nombre = "Hacha de Madera";
	}
}
