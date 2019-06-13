package Modelo.Jugador;

import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Modelo.Tablero.Tablero;
import java.util.Collection;


class Inventario {

	private Tablero tablero;

	Inventario() {
		tablero = new Tablero(1,9);
	}

	void agregarEnPosicion(Posicionable posicionable, Posicion unaPosicion) { tablero.colocarElementoEnPosicion(posicionable,unaPosicion); }

	void agregar(Posicionable posicionable) {
		Posicion posicion = tablero.obtenerPosicionVacia();
		tablero.colocarElementoEnPosicion(posicionable,posicion);
	}

	//Levantar algun tipo de error
	void remover(Posicionable posicionable) {
		if(!tiene(posicionable)) { return; }
		else { tablero.removerElementoEnPosicion(posicionable.getPosicion()); }
	}

	 boolean tiene(Posicionable posicionable) {
		Collection<Posicionable> elementos = obtenerTodosLosElementos();
		for (Posicionable elemento : elementos ) { if (posicionable.getNombre().equals(elemento.getNombre())) {return true;} }
		return false;
	}

	//Sirve para la vista
	Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }
}

