package Modelo.Juego;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Jugador.*;
import Modelo.Mapa.Mapa;
import Modelo.Mapa.Posicion;
import Modelo.Mapa.PosicionadorRandom;
import Modelo.Posicionable.Posicionable;
import java.util.Collection;

public class Juego {

	private Jugador jugador;
	private Mapa mapa;
	private MesaDeCrafteo mesaDeCrafteo;

	public Juego(int altura,int ancho) {

		jugador = new Jugador();
		mapa = new Mapa(altura,ancho);
		mesaDeCrafteo = new MesaDeCrafteo();
		mapa.inicializarMateriales();
		mapa.colocarElementoEnPosicion(jugador,new PosicionadorRandom(mapa).crearPosicionRandomValida());
	}

	public Jugador getJugador() { return jugador; }

	public void moverJugadorEnVertical(int y) {
		Posicion posAnterior = jugador.getPosicion();
		Posicion nueva = new Posicion(posAnterior.getPosX(),posAnterior.getPosY()+ y);
		try {
			mapa.colocarElementoEnPosicion(jugador,nueva);
		} catch (PosicionOcupadaException | PosicionFueraDeRangoException e) {
			return;
		}
		mapa.removerElementoEnPosicion(posAnterior);

	}

	public void moverJugadorEnHorizontal(int x) {
		Posicion posAnterior = jugador.getPosicion();
		Posicion nueva = new Posicion(posAnterior.getPosX()+ x,posAnterior.getPosY());
		try {
			mapa.colocarElementoEnPosicion(jugador,nueva);
		} catch (PosicionOcupadaException | PosicionFueraDeRangoException e) {
			return;
		}
		mapa.removerElementoEnPosicion(posAnterior);
	}

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) { mapa.colocarElementoEnPosicion(posicionable,posicion); }

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) {
		return mapa.obtenerElementoEnPosicion(posicion);
	}

	/*public Posicion obtenerPosicionVacia() { return mapa.obtenerPosicionVacia(); }*/ //Para usar con inventario.

	public int recuentoPosicionable(Posicionable posicionable) { return (mapa.recuentoPosicionable(posicionable)); }

	public Collection<Posicionable> obtenerTodosLosElementos(){ return mapa.obtenerTodosLosElementos(); }

}
