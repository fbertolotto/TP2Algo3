package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Metal extends Material {

	public Metal() {
		desgaste = new DesgasteLineal(1,50);
	}

	public void desgastar(PicoDePiedra picoDePiedra) throws DurabilidadAgotadaException {
		desgaste.desgastar(picoDePiedra.getFuerza());
	}

}
