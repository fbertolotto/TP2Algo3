package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class HachaDeMadera extends Hacha {

	public HachaDeMadera() {
		this.fuerza = 2;
		this.formaDesgaste = new DesgasteLineal(1, 100);
	}
}
