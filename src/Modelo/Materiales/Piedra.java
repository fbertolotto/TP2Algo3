package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Piedra extends Material {

	public Piedra() {
		desgaste = new DesgasteLineal(1,30);
	}

	public void desgastar(Pico pico) throws DurabilidadAgotadaException {
		desgaste.desgastar(pico.getFuerza());
	}

}
