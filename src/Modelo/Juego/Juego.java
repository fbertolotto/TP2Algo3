package Modelo.Juego;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Jugador.*;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.Posicion;
import Modelo.Tablero.PosicionadorRandom;
import Modelo.Posicionable.Posicionable;
import java.util.Collection;

public class Juego {

	private Jugador jugador;
	private Tablero tablero;
	private MesaDeCrafteo mesaDeCrafteo;

	public Juego(int altura,int ancho) {

		jugador = new Jugador();
		tablero = new Tablero(altura,ancho);
		mesaDeCrafteo = new MesaDeCrafteo();
		tablero.inicializarMateriales();
		new PosicionadorRandom(tablero).crearPosicionRandomYAgregarElemento(jugador);
	}

	public Jugador getJugador() { return jugador; }

	public void moverJugadorEnVertical(int y) {
		Posicion posAnterior = jugador.getPosicion();
		Posicion nueva = new Posicion(posAnterior.getPosX(),posAnterior.getPosY()+ y);
		try {
			tablero.colocarElementoEnPosicion(jugador,nueva);
		} catch (PosicionOcupadaException | PosicionFueraDeRangoException e) {
			return;
		}
		tablero.removerElementoEnPosicion(posAnterior);

	}

	public void moverJugadorEnHorizontal(int x) {
		Posicion posAnterior = jugador.getPosicion();
		Posicion nueva = new Posicion(posAnterior.getPosX()+ x,posAnterior.getPosY());
		try {
			tablero.colocarElementoEnPosicion(jugador,nueva);
		} catch (PosicionOcupadaException | PosicionFueraDeRangoException e) {
			return;
		}
		tablero.removerElementoEnPosicion(posAnterior);
	}

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) { tablero.colocarElementoEnPosicion(posicionable,posicion); }

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) {
		return tablero.obtenerElementoEnPosicion(posicion);
	}

	/*public Posicion obtenerPosicionVacia() { return tablero.obtenerPosicionVacia(); }*/ //Para usar con inventario.

	public int recuentoPosicionable(Posicionable posicionable) { return (tablero.recuentoPosicionable(posicionable)); }

	public Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }

}
