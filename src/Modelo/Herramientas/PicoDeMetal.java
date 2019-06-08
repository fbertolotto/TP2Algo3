package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.DesgasteUsos;
import Modelo.Materiales.*;

public class PicoDeMetal extends Pico {

	public PicoDeMetal() {
		this.fuerza = 12;
		this.formaDesgaste = new DesgasteUsos(10, 400);
	}

	@Override
	public void usar(Piedra piedra) throws DurabilidadAgotadaException {
		piedra.desgastar(this);
		this.formaDesgaste.desgastar(this.fuerza);
	}

	@Override
	public void usar(Material material) throws DurabilidadAgotadaException {
		this.formaDesgaste.desgastar(this.fuerza);
	}

}
