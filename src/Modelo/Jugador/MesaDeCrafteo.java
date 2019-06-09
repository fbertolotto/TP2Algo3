package Modelo.Jugador;

import Modelo.Herramientas.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MesaDeCrafteo {

	private HashMap<String, Herramienta> crafteos;

	public MesaDeCrafteo() {

		crafteos = new HashMap();
		crafteos.put("MA-MA- -MA-MA- -MA- ",new HachaDeMadera());
		crafteos.put("P-P- -P-MA- -MA- ",new HachaDePiedra());
		crafteos.put("ME-ME- -ME-MA- -MA- ",new HachaDeMetal());
		crafteos.put("MA-MA-MA- -MA- - -MA- ",new PicoDeMadera());
		crafteos.put("P-P-P- -MA- - -MA- ",new PicoDePiedra());
		crafteos.put("ME-ME-ME- -MA- - -MA- ",new PicoDeMetal());
		crafteos.put("ME-ME-ME-P-MA- - -MA- ",new PicoFino());

	}

	public Herramienta craftear(String crafteo) {

		for (Map.Entry<String, Herramienta> entry : crafteos.entrySet()) {
			String craft = entry.getKey();
			Herramienta herramienta = entry.getValue();
			if (craft.equals(crafteo)) {
				return herramienta;
			}
		}
		return null;
	}
}


