package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class HachaDeMetal extends Hacha {

	public HachaDeMetal() {
		this.fuerza = 10;
		this.formaDesgaste = new DesgasteLineal(2, 400);
	}
}