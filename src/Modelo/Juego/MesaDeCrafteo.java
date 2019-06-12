package Modelo.Juego;

import Modelo.Herramientas.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.Posicion;

import java.util.*;

public class MesaDeCrafteo {

	private HashMap<Crafteo, Herramienta> crafteos;
	private Tablero tablero;

	public MesaDeCrafteo() {

		crafteos = new HashMap();
		tablero = new Tablero(3,3);

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
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				Posicion posicionaux = new Posicion(i,j);
				if (tablero.obtenerElementoEnPosicion(posicionaux) == null) {
					materiales.add("");
					continue;
				}
				materiales.add(tablero.obtenerElementoEnPosicion(posicionaux).getNombre());
			}
		return crafteos.get(new Crafteo(materiales));
	}

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) {
		tablero.colocarElementoEnPosicion(posicionable,posicion);
	}
}


