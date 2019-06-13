package Modelo.Herramientas;

import Modelo.Desgaste.DesgasteUsos;

public class PicoDeMetal extends Pico {

	public PicoDeMetal() {
		fuerza = 12;
		formaDesgaste = new DesgasteUsos(10, 400);
		nombre = "Pico de Metal";
		rutaImagen = "media/images/picodemetal.png/";
	}
}
