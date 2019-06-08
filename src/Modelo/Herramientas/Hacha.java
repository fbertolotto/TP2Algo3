package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Materiales.*;

public abstract class Hacha extends Herramienta {

	public void usar(Madera madera) throws DurabilidadAgotadaException {
		madera.desgastar(this);
		this.formaDesgaste.desgastar(this.fuerza);
	}

	public void usar(Material material) throws DurabilidadAgotadaException {
		this.formaDesgaste.desgastar(this.fuerza);
	}
}
