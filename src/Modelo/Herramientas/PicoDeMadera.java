package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class PicoDeMadera extends Pico {

	public PicoDeMadera() {
		this.fuerza = 2;
		this.formaDesgaste = new DesgasteLineal(1, 100);
	}

}
