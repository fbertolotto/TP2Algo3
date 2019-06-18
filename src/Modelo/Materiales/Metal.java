package Modelo.Materiales;

import Modelo.Desgaste.DesgasteLineal;

public class Metal extends Material {

	public Metal() {
		formaDesgaste = new DesgasteLineal(1,50);
		nombre = "Metal";
		rutaImagen ="media/images/metal.png/";
	}

}
