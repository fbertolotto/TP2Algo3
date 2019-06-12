package Modelo.Jugador;

import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Modelo.Tablero.Tablero;

import java.util.ArrayList;
import java.util.Collection;


class Inventario {

	private ArrayList<Posicionable> inventario = new ArrayList();
	private Tablero tablero;

	Inventario() {
		tablero = new Tablero(1,9);
	}


	void agregar(Herramienta unaHerramienta, Posicion unaPosicion) {
		inventario.add(unaHerramienta);
		tablero.colocarElementoEnPosicion(unaHerramienta,unaPosicion);
	}

	Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }

	boolean tiene(Posicionable elemento) {
		for (Posicionable guardable : inventario) {
			if (elemento.getNombre().equals(guardable.getNombre())) {
				return true;
			}
		}
		return false;
	}
}

