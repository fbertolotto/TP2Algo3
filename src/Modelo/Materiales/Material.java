package Modelo.Materiales;


import Modelo.Desgaste.DesgasteLineal;
import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Posicionable.Posicionable;

public abstract class Material extends Posicionable {

	protected DesgasteLineal formaDesgaste;

	public float getDurabilidad(){ return formaDesgaste.getDurabilidad(); }

	public void desgastar(Herramienta herramienta) throws DurabilidadAgotadaException {
		formaDesgaste.desgastar(herramienta.getFuerza());
	}

}
