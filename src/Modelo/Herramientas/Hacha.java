package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Materiales.*;

public abstract class Hacha extends Herramienta {

	public void usar(Madera madera) throws DurabilidadAgotadaException {
		madera.desgastar(this);
		formaDesgaste.desgastar(fuerza);
	}

	@Override
	public void usar(Material material) throws DurabilidadAgotadaException {
		if (material.getNombre() == "Madera") { usar((Madera)material); }
		else { formaDesgaste.desgastar(fuerza); }
	}
}
