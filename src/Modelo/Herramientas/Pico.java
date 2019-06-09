package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Materiales.*;

public abstract class Pico extends Herramienta {

	public void usar(Piedra piedra) throws DurabilidadAgotadaException {
		piedra.desgastar(this);
		formaDesgaste.desgastar(fuerza);
	}

	public void usar(Material material) throws DurabilidadAgotadaException {
		formaDesgaste.desgastar(fuerza);
	}
}
