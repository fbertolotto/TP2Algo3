package Modelo.Juego;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Excepciones.MaterialFueraDeAlcanceExeption;
import Modelo.Excepciones.PicoFinoMaterialInvalidoExeption;
import Modelo.Excepciones.UsarHerramientaEnJugadorExeption;
import Modelo.Herramientas.PicoFino;
import Modelo.Jugador.*;
import Modelo.Materiales.Material;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.Posicion;
import Modelo.Tablero.PosicionadorRandom;
import Modelo.Posicionable.Posicionable;

import java.util.ArrayList;
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

		if(posicionable.getPosicion() == jugador.getPosicion()) throw new UsarHerramientaEnJugadorExeption();
		if(tablero.validarAdyacencia(posicionable.getPosicion(),jugador.getPosicion())) {
			try {
				jugador.usarHerramientaEquipada((Material) posicionable);
				tablero.removerElementoEnPosicion(posicionable.getPosicion());
				jugador.agregarEnInventario(posicionable);
			}
			catch (DurabilidadAgotadaException e) { jugador.removerHerramientaEquipada();}
			catch (PicoFinoMaterialInvalidoExeption e) { return; }

		} else { throw new MaterialFueraDeAlcanceExeption(); }
	}


	public int recuentoPosicionable(String nombrePosicionable) { return (tablero.recuentoPosicionable(nombrePosicionable)); }

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }

	public ArrayList<Posicionable> obtenerMaterialesAdyacentes() { return tablero.obtenerMaterialesAdyacentes(jugador.getPosicion());}

}
