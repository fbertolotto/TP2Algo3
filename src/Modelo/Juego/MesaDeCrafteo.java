package Modelo.Juego;

import Modelo.Herramientas.*;
import Modelo.Mapa.Mapa;
import Modelo.Mapa.Posicion;

import java.util.*;

public class MesaDeCrafteo extends Mapa {

	private HashMap<Crafteo, Herramienta> crafteos;

	public MesaDeCrafteo() {

		super(3,3);
		crafteos = new HashMap();

		Crafteo HachaDeMadera = new Crafteo(new ArrayList<>(Arrays.asList("Madera", "Madera", "", "Madera", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDeMadera, new HachaDeMadera());


		Crafteo HachaDePiedra = new Crafteo(new ArrayList<>(Arrays.asList("Piedra", "Piedra", "", "Piedra", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDePiedra, new HachaDePiedra());


		Crafteo HachaDeMetal = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "", "Metal", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDeMetal, new HachaDeMetal());


		Crafteo PicoDeMadera = new Crafteo(new ArrayList<>(Arrays.asList("Madera", "Madera", "Madera", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDeMadera, new PicoDeMadera());


		Crafteo PicoDePiedra = new Crafteo(new ArrayList<>(Arrays.asList("Piedra", "Piedra", "Piedra", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDePiedra, new PicoDePiedra());


		Crafteo PicoDeMetal = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "Metal", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDeMetal, new PicoDeMetal());


		Crafteo PicoFino = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "Metal", "Piedra", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoFino, new PicoFino());
	}

	public Herramienta craftear() {
		ArrayList materiales = new ArrayList();
		for (int i = 0; i<3; i++)
			for (int j = 0; j < 3; j++) {
				Posicion posicionaux = new Posicion(i,j);
				if (grilla.getOrDefault(posicionaux, null) == null) {
					materiales.add("");
					continue;
				}
				materiales.add(grilla.get(posicionaux).getNombre());
			}
		return crafteos.get(new Crafteo(materiales));
	}
}


