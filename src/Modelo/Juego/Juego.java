package Modelo.Juego;

import Modelo.Jugador.*;
import Modelo.Mapa.Mapa;
import Modelo.Mapa.Posicion;
import Modelo.Posicionable.Posicionable;
import Modelo.Materiales.*;

import java.util.ArrayList;
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
		mapa.colocarElementoEnPosicion(jugador,mapa.crearPosicionRandomValida());

	}

	public Jugador getJugador() { return jugador; }
/*
	public Mapa getMapa() { return mapa; }
	public MesaDeCrafteo getMesaDeCrafteo() { return mesaDeCrafteo; }
*/
	public void moverJugadorEnVertical(int y) {
		Posicion posAnterior = jugador.getPosicion();
		mapa.removerElementoEnPosicion(posAnterior);
		jugador.moverEnVertical(y);
		mapa.colocarElementoEnPosicion(jugador,jugador.getPosicion());
	}

	public void moverJugadorEnHorizontal(int x) {
		Posicion posAnterior = jugador.getPosicion();
		mapa.removerElementoEnPosicion(posAnterior);
		jugador.moverEnHorizontal(x);
		mapa.colocarElementoEnPosicion(jugador,jugador.getPosicion());
	}

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) {
		mapa.colocarElementoEnPosicion(posicionable,posicion);
	}


	public Posicionable obtenerElementoEnPosicion(Posicion posicion) {
		return mapa.obtenerElementoEnPosicion(posicion);
	}

	public Posicion obtenerPosicionVacia() {
		return mapa.obtenerPosicionVacia();
	}


	public int recuentoPosicionable(Posicionable posicionable) {
		return (mapa.recuentoPosicionable(posicionable));
	}

	public Collection<Posicionable> obtenerTodosLosElementos(){
		return mapa.obtenerTodosLosElementos();
	}

}
