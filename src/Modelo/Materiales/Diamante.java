package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Diamante extends Material {

	public Diamante() {
		desgaste = new DesgasteLineal(1,100);
	}

	public void desgastar(PicoFino picoFino) throws DurabilidadAgotadaException {
		desgaste.desgastar(picoFino.getFuerza());
	}

}

