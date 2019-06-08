package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class HachaDePiedra extends Hacha {

	public HachaDePiedra() {
		this.fuerza = 5;
		this.formaDesgaste = new DesgasteLineal(1, 200);
	}
}
