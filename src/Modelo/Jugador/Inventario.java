package Modelo.Jugador;

import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Modelo.Tablero.Tablero;
import java.util.Collection;


public class Inventario {

	private Tablero tablero;

	Inventario() {
		tablero = new Tablero(6,9);
	}

	public void agregarEnPosicion(Posicionable posicionable, Posicion unaPosicion) { tablero.colocarElementoEnPosicion(posicionable,unaPosicion); }
	public int getTam() { return tablero.getTam();}

	public void agregar(Posicionable posicionable) {
		Posicion posicion = tablero.obtenerPosicionVacia();
		tablero.colocarElementoEnPosicion(posicionable,posicion);
	}

	public void remover(Posicionable posicionable) {
		if(!tiene(posicionable)) { return; }
		else { tablero.removerElementoEnPosicion(posicionable.getPosicion()); }
	}

	 public boolean tiene(Posicionable posicionable) {
		Collection<Posicionable> elementos = obtenerTodosLosElementos();
		for (Posicionable elemento : elementos ) { if (posicionable.getNombre().equals(elemento.getNombre())) {return true;} }
		return false;
	}

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) { return tablero.obtenerElementoEnPosicion(posicion); }
}

