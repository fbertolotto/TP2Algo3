package Modelo.Juego;

import Modelo.Jugador.*;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;
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
		mesaDeCrafteo.colocarElementoEnPosicion(new Madera(),new Posicion(0,0));
		mesaDeCrafteo.colocarElementoEnPosicion(new Madera(),new Posicion(0,1));
		mesaDeCrafteo.colocarElementoEnPosicion(new Madera(),new Posicion(1,0));
		mesaDeCrafteo.colocarElementoEnPosicion(new Madera(),new Posicion(1,1));
		jugador.agregarEnInventario(new Madera());
		jugador.agregarEnInventario(new Piedra());
		jugador.agregarEnInventario(new Piedra());
		jugador.agregarEnInventario(new Piedra());
		jugador.agregarEnInventario(new Piedra());
		jugador.agregarEnInventario(new Piedra());
		jugador.agregarEnInventario(new Metal());
		jugador.agregarEnInventario(new Metal());
		jugador.agregarEnInventario(new Metal());
		jugador.agregarEnInventario(new Metal());
		jugador.agregarEnInventario(new Metal());
		tablero.inicializarMateriales();
		new PosicionadorRandom(tablero).crearPosicionRandomYAgregarElemento(jugador);
	}

	public Jugador getJugador() { return jugador; }

	public Tablero getTablero() { return tablero; }

	public MesaDeCrafteo getMesaDeCrafteo() { return mesaDeCrafteo; }

	public void moverJugadorEnVertical(int y) {tablero.moverElemento(jugador,0,y); }

	public void moverJugadorEnHorizontal(int x) {tablero.moverElemento(jugador,x,0); }

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) { tablero.colocarElementoEnPosicion(posicionable,posicion); }

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) { return tablero.obtenerElementoEnPosicion(posicion); }

	public int recuentoPosicionable(String nombrePosicionable) { return (tablero.recuentoPosicionable(nombrePosicionable)); }

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }


	/*public Posicion obtenerPosicionVacia() { return tablero.obtenerPosicionVacia(); }*/ //Para usar con inventario.
}
