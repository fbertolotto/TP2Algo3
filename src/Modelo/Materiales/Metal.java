package Modelo.Materiales;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Desgaste.DesgasteLineal;

public class Metal extends Material {

	public Metal() {
		formaDesgaste = new DesgasteLineal(1,50);
		nombre = "Metal";
		rutaImagen ="images/metal.png/";
	}

	public void desgastar(PicoDePiedra picoDePiedra) throws DurabilidadAgotadaException {
		formaDesgaste.desgastar(picoDePiedra.getFuerza());
	}

}
