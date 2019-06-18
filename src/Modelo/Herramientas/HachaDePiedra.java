package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class HachaDePiedra extends Hacha {

	public HachaDePiedra() {
		fuerza = 5;
		formaDesgaste = new DesgasteLineal(1, 200);
		nombre = "Hacha de Piedra";
	}
}
