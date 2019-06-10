package JuegoTest;

import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Mapa.Posicion;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Piedra;
import javafx.geometry.Pos;
import org.junit.Test;
import Modelo.Juego.*;
import Modelo.Jugador.*;

import static org.junit.Assert.*;

public class JuegoTest {

	@Test
	public void test01t1ElJuegoSeInicializaConUnJugador() {
		Juego juego = new Juego(24,47);
		Jugador jugador = juego.getJugador();
		assertNotNull(jugador);
	}

	@Test
	public void test01t2ColocarJugadorenMapaFuncionaCorrectamente() {
		Juego juego = new Juego(24,47);
		Jugador jugador = new Jugador();

		Posicion posicion = new Posicion(10,10);
		assertEquals(jugador.getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test01t3ColocarMaterialEnPosicionDeMesaDeCrafteoYaOcupadaPorOtroMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24,47);

		Posicion posicion1 = new Posicion(1,1);
		juego.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Piedra(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}


	@Test
	public void test02t1MuevoJugador1PosicionHaciaAbajo() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnVertical(-1);

		Posicion posicion = new Posicion(10, 9);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test02t2MuevoJugador1PosicionHaciaArriba() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnVertical(1);

		Posicion posicion = new Posicion(10, 11);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test02t3MuevoJugador1PosicionHaciaDerecha() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnHorizontal(1);

		Posicion posicion = new Posicion(11, 10);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test02t4MuevoJugador1PosicionHaciaIzquierda() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnHorizontal(-1);

		Posicion posicion = new Posicion(9, 10);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}


	@Test
	public void test03t1MuevoJugadorHastaBordeDelMapaHaciaAbajo() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnVertical(-10);

		Posicion posicion = new Posicion(10, 0);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test03t2MuevoJugadorHastaBordeDelMapaHaciaArriba() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnVertical(14);

		Posicion posicion = new Posicion(10, 24);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test03t3MuevoJugadorHastaBordeDelMapaHaciaDerecha() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnHorizontal(37);

		Posicion posicion = new Posicion(47, 10);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test03t4MuevoJugadorHastaBordeDelMapaHaciaIzquierda() {
		Juego juego = new Juego(24, 47);
		juego.moverJugadorEnHorizontal(-10);

		Posicion posicion = new Posicion(0, 10);
		assertEquals(juego.getJugador().getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}


	/*
	ACA VAN LOS FUERA DE RANGO EN TODAS LAS DIRECCIONES}
	@Test
	public void test04t1MuevoJugadorFueraDelMapaHaciaAbajo() {
	public void test04t2MuevoJugadorFueraDelMapaHaciaArriba() {
	public void test04t3MuevoJugadorFueraDelMapaHaciaDerecha() {
	public void test04t4MuevoJugadorFueraDelMapaHaciaIzquierda() {
	 */

	/*
	ACA VAN TODOS LOS TEST, PISANDO BLOQUES.

	@Test
	public void test05t1MuevoJugadorSobreBloqueDiamante() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);

		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(10, 11);

		juego.colocarElementoEnPosicion(diamante, posicion);
		juego.moverJugadorEnVertical(1);

		assertEquals(juego.obtenerElementoEnPosicion(posicion),juego.getJugador());
	}

	*/


	@Test
	public void test06t1PrimeraPosicionVaciaEncontradaEsEl00(){
		Juego juego = new Juego(24, 47);
		Posicion vacia = juego.obtenerPosicionVacia();
		Posicion posicion = new Posicion(0,0);
		assertEquals(posicion,vacia);
	}

}
