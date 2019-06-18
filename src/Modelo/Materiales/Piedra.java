package Modelo.Materiales;

import Modelo.Desgaste.DesgasteLineal;

public class Piedra extends Material {

	public Piedra() {
		formaDesgaste = new DesgasteLineal(1,30);
		nombre ="Piedra";
		rutaImagen ="media/images/piedra2.png/";
	}

}
