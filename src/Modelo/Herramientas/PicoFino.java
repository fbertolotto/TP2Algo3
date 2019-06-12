package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.DesgasteLineal;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;
import Modelo.Materiales.*;

public class PicoFino extends Pico {

	public PicoFino() {
		fuerza = 20;
		formaDesgaste = new DesgasteLineal(10, 1000);
		nombre = "Pico Fino";
		rutaImagen = "media/images/picofino.png/";
	}

	public void usar(Diamante diamante) throws DurabilidadAgotadaException {
		diamante.desgastar(this);
		formaDesgaste.desgastar(formaDesgaste.getDurabilidad());
	}

	@Override
	public void usar(Piedra piedra) throws DurabilidadAgotadaException {
		piedra.desgastar(this);
	}

	@Override
	public void usar(Material material){
		//No sucede nada.
	}

}
