package Modelo.Jugador;

import Modelo.Herramientas.Hacha;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MesaDeCrafteo {

	private HashMap<String, String> crafteos = new HashMap<>();

	public MesaDeCrafteo() {

		String HachaDeMadera = "Madera-Madera--Madera-Madera---Madera--";
		crafteos.put("Hacha de Madera",HachaDeMadera);

		/*
		List<String> HachaDeMadera = Arrays.asList( "Madera","Madera","","Madera","Madera","","","Madera","");
		crafteos.put("Hacha de Madera",HachaDeMadera);

		List<String> HachaDePiedra = Arrays.asList( "Piedra","Piedra","","Piedra","Madera","","","Madera","");
		crafteos.put("Hacha de Piedra",HachaDePiedra);

		List<String> HachaDeMetal = Arrays.asList( "Metal","Metal","","Metal","Madera","","","Madera","");
		crafteos.put("Hacha de Metal",HachaDeMetal);

		List<String> PicoDeMadera = Arrays.asList( "Madera","Madera","Madera","","Madera","","","Madera","");
		crafteos.put("Pico de Madera",PicoDeMadera);

		List<String> PicoDePiedra = Arrays.asList( "Piedra","Piedra","Piedra","","Madera","","","Madera","");
		crafteos.put("Pico de Piedra",PicoDePiedra);

		List<String> PicoDeMetal = Arrays.asList( "Metal","Metal","Metal","","Madera","","","Madera","");
		crafteos.put("Pico de Metal",PicoDeMetal);

		List<String> PicoFino = Arrays.asList( "Metal","Metal","Metal","Piedra","Madera","","","Madera","");
		crafteos.put("Pico Fino", PicoFino);

		 */
	}

	public boolean craftear(String crafteo) {

		for (Map.Entry<String, String> entry : crafteos.entrySet()) {
			String herramienta = entry.getKey();
			String craft = entry.getValue();
			if (craft.equals(crafteo)) {
				return true;
			}
		}
		return false;
	}
}


