package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Madera extends Material {

	public Madera() {
		desgaste = new DesgasteLineal(1,10);
	}

	public void desgastar(Hacha hacha) throws DurabilidadAgotadaException {
		desgaste.desgastar(hacha.getFuerza());
	}

}


