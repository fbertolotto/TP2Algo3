package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class PicoDeMadera extends Pico {

	public PicoDeMadera() {
		fuerza = 2;
		formaDesgaste = new DesgasteLineal(1, 100);
		nombre = "Pico de Madera";
	}

}
