package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.DesgasteUsos;
import Modelo.Materiales.*;

public class PicoDeMetal extends Pico {

	public PicoDeMetal() {
		fuerza = 12;
		formaDesgaste = new DesgasteUsos(10, 400);
		nombre = "Pico de Metal";
	}

	@Override
	public void usar(Piedra piedra) throws DurabilidadAgotadaException {
		piedra.desgastar(this);
		formaDesgaste.desgastar(fuerza);
	}

	@Override
	public void usar(Material material) throws DurabilidadAgotadaException {
		formaDesgaste.desgastar(fuerza);
	}

}
