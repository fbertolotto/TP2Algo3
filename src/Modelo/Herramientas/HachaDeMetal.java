package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteLineal;

public class HachaDeMetal extends Hacha {

	public HachaDeMetal() {
		fuerza = 10;
		formaDesgaste = new DesgasteLineal(2, 400);
		nombre = "Hacha de Metal";
		rutaImagen = "media/images/hachademetal.png/";
	}
}