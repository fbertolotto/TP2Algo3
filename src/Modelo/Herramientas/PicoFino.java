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

	@Override
	public void usar(Material material) throws DurabilidadAgotadaException {
		if (material.getNombre() == "Diamante") { usar((Diamante)material); }
		else if (material.getNombre() == "Piedra") { usar((Piedra)material); }
		}

	@Override
	public void usar(Piedra piedra) throws DurabilidadAgotadaException {
		piedra.desgastar(this);
	}

	public void usar(Diamante diamante) throws DurabilidadAgotadaException {
		diamante.desgastar(this);
		formaDesgaste.desgastar(formaDesgaste.getDurabilidad());
	}

}
