package Modelo.Juego;

import Modelo.Excepciones.MaterialFueraDeAlcanceExeption;
import Modelo.Jugador.*;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Material;
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

	public void usarHerramienta(Posicionable posicionable){
		if(tablero.validarAdyacencia(posicionable.getPosicion(),jugador.getPosicion())) {
			jugador.usarHerramientaEquipada((Material) posicionable);
			jugador.agregarEnInventario(posicionable);
			tablero.removerElementoEnPosicion(posicionable.getPosicion());
		} else { throw new MaterialFueraDeAlcanceExeption(); }
	}


	public int recuentoPosicionable(String nombrePosicionable) { return (tablero.recuentoPosicionable(nombrePosicionable)); }

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }


	/*public Posicion obtenerPosicionVacia() { return tablero.obtenerPosicionVacia(); }*/ //Para usar con inventario.
}
