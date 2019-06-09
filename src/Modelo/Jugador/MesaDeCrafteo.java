package Modelo.Jugador;

import Modelo.Herramientas.Hacha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MesaDeCrafteo {

	private HashMap<String, String> validacion;

	public MesaDeCrafteo() {

		validacion = new HashMap();
		validacion.put("Hacha de madera","MA-MA- -MA-MA- -MA- ");
		validacion.put("Hacha de piedra","P-P- -P-MA- -MA- ");
		validacion.put("Hacha de metal","ME-ME- -ME-MA- -MA- ");
		validacion.put("Pico de madera","MA-MA-MA- -MA- - -MA- ");
		validacion.put("Pico de piedra","P-P-P- -MA- - -MA- ");
		validacion.put("Pico de metal","ME-ME-ME- -MA- - -MA- ");
		validacion.put("Pico fino","ME-ME-ME-P-MA- - -MA- ");

	}

	public boolean validar(String matrizDeCrafteo) {
		for (Map.Entry<String, String> entry : validacion.entrySet()) {
			String herramienta = entry.getKey();
			String craft = entry.getValue();
			if (craft.equals(matrizDeCrafteo)) {
				return true;
			}
		}
		return false;
	}
}


