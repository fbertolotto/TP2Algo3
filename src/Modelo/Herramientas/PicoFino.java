package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.DesgasteLineal;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;
import Modelo.Materiales.*;

public class PicoFino extends Pico {

	public PicoFino() {
		this.fuerza = 20;
		this.formaDesgaste = new DesgasteLineal(10, 1000);
	}

	public void usar(Diamante diamante) throws DurabilidadAgotadaException {
		diamante.desgastar(this);
		this.formaDesgaste.desgastar(this.formaDesgaste.getDurabilidad());
	}

	@Override
	public void usar(Piedra piedra) throws DurabilidadAgotadaException {
		piedra.desgastar(this);
	}

	@Override
	public void usar(Material material){}

}
