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

	void agregar(Posicionable posicionable, Posicion unaPosicion) { tablero.colocarElementoEnPosicion(posicionable,unaPosicion); }

	 boolean tiene(Posicionable posicionable) {
		for (int i = 0 ; i < 9 ; i++) {
				Posicion posicion = new Posicion(i,0);
				if (tablero.obtenerElementoEnPosicion(posicion) == null) { continue; }
				if ((tablero.obtenerElementoEnPosicion(posicion).getNombre().equals(posicionable.getNombre()))) { return true;}
		}
		return false;
	}

	//Sirve para la vista
	Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }
}

