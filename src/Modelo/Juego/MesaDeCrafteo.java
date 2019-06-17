package Modelo.Juego;

import Modelo.Herramientas.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.Posicion;

import java.util.*;
import java.util.function.Supplier;

public class MesaDeCrafteo {

	private HashMap<Crafteo, Supplier<Herramienta>> crafteos;
	private Tablero tablero;

	public MesaDeCrafteo() {

		crafteos = new HashMap();
		tablero = new Tablero(3,3);

		Crafteo HachaDeMadera = new Crafteo(new ArrayList<>(Arrays.asList("Madera", "Madera", "", "Madera", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDeMadera, ()->new HachaDeMadera());

		Crafteo HachaDePiedra = new Crafteo(new ArrayList<>(Arrays.asList("Piedra", "Piedra", "", "Piedra", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDePiedra, ()->new HachaDePiedra());

		Crafteo HachaDeMetal = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "", "Metal", "Madera", "", "", "Madera", "")));
		crafteos.put(HachaDeMetal, ()->new HachaDeMetal());

		Crafteo PicoDeMadera = new Crafteo(new ArrayList<>(Arrays.asList("Madera", "Madera", "Madera", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDeMadera,()-> new PicoDeMadera());

		Crafteo PicoDePiedra = new Crafteo(new ArrayList<>(Arrays.asList("Piedra", "Piedra", "Piedra", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDePiedra, ()->new PicoDePiedra());

		Crafteo PicoDeMetal = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "Metal", "", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoDeMetal, ()->new PicoDeMetal());

		Crafteo PicoFino = new Crafteo(new ArrayList<>(Arrays.asList("Metal", "Metal", "Metal", "Piedra", "Madera", "", "", "Madera", "")));
		crafteos.put(PicoFino, ()->new PicoFino());
	}

	public Herramienta craftear() {
		ArrayList materiales = new ArrayList();
		for (int fila = 0; fila < 3; fila++)
			for (int columna = 0; columna < 3; columna++) {
				Posicion posicionaux = new Posicion(columna,fila);
				if (tablero.obtenerElementoEnPosicion(posicionaux) == null) {
					materiales.add("");
					continue;
				}
				materiales.add(tablero.obtenerElementoEnPosicion(posicionaux).getNombre());
			}
		if(crafteos.getOrDefault(new Crafteo(materiales),null)== null) return null;
		return crafteos.get(new Crafteo(materiales)).get();

	}


	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) {
		tablero.colocarElementoEnPosicion(posicionable,posicion);
	}

	public Collection<Posicionable>  obtenerTodosLosElementos() {
		return tablero.obtenerTodosLosElementos();
	}

	public void limpiar() { tablero.limpiar();}

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) {
		return tablero.obtenerElementoEnPosicion(posicion);
	}

	public void removerElemento(Posicionable posicionable) { if(tiene(posicionable)) tablero.removerElementoEnPosicion(posicionable.getPosicion()); }


	public boolean tiene(Posicionable posicionable) {
		Collection<Posicionable> elementos = obtenerTodosLosElementos();
		for (Posicionable elemento : elementos ) { if (posicionable.getNombre().equals(elemento.getNombre())) {return true;} }
		return false;
	}
}



