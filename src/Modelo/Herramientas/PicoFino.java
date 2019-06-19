package Modelo.Herramientas;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Desgaste.DesgasteLineal;
import Modelo.Excepciones.PicoFinoMaterialInvalidoExeption;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Material;
import Modelo.Materiales.*;

public class PicoFino extends Pico {

	public PicoFino() {
		fuerza = 20;
		formaDesgaste = new DesgasteLineal(10, 1000);
		nombre = "Pico Fino";
	}

	@Override
	public void usar(Material material) throws DurabilidadAgotadaException, PicoFinoMaterialInvalidoExeption {
		if (material.getNombre().equals("Diamante")) { usar((Diamante) material); }
		else if (material.getNombre().equals("Piedra")) { usar((Piedra) material); }
		else { throw new PicoFinoMaterialInvalidoExeption(); }
		return;
	}

	public void usar(Diamante diamante) throws DurabilidadAgotadaException {
		diamante.desgastar(this);
		formaDesgaste.desgastar(formaDesgaste.getDurabilidad());
	}

	@Override
	public void usar(Piedra piedra) throws DurabilidadAgotadaException { piedra.desgastar(this); }

}
