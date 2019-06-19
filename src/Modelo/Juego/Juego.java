package Modelo.Juego;

import Modelo.Excepciones.*;
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
	private Zombie zombie;
	private Tablero tablero;
	private MesaDeCrafteo mesaDeCrafteo;

	public Juego(int altura,int ancho) {

		jugador = new Jugador();
		tablero = new Tablero(altura,ancho);
		zombie = new Zombie();
		mesaDeCrafteo = new MesaDeCrafteo();
		tablero.inicializarMateriales();
		new PosicionadorRandom(tablero).crearPosicionRandomYAgregarElemento(jugador);
		new PosicionadorRandom(tablero).crearPosicionRandomYAgregarElemento(zombie);
	}

	public Jugador getJugador() { return jugador; }
	public Tablero getTablero() { return tablero; }
	public MesaDeCrafteo getMesaDeCrafteo() { return mesaDeCrafteo; }

	public void moverJugadorEnVertical(int y) {tablero.moverElemento(jugador,0,y); }
	public void moverJugadorEnHorizontal(int x) {tablero.moverElemento(jugador,x,0); }

	public void moverZombie() {
		System.out.println("Pos Jugador: " + jugador.getPosicion().getColumna() + "," + jugador.getPosicion().getFila());
		System.out.println("Pos Zombie: " + zombie.getPosicion().getColumna() + "," + zombie.getPosicion().getFila());
		int randomColumna = zombie.moverRandom();
		int randomFila = zombie.moverRandom();
		try {tablero.moverElemento(zombie,randomColumna,randomFila);}
		catch (PosicionOcupadaException | PosicionFueraDeRangoException e) {return;}
	}

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
			catch (DurabilidadAgotadaException e) {
				jugador.removerHerramientaEquipada();
				throw new DurabilidadAgotadaException();
			}

		} else { throw new MaterialFueraDeAlcanceExeption(); }
	}


	public int recuentoPosicionable(String nombrePosicionable) { return (tablero.recuentoPosicionable(nombrePosicionable)); }

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return tablero.obtenerTodosLosElementos(); }

	public ArrayList<Posicionable> obtenerMaterialesAdyacentes() { return tablero.obtenerMaterialesAdyacentes(jugador.getPosicion());}

}
