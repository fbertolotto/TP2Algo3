package JuegoTest;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Mapa.Posicion;
import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Piedra;
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

	//Todavia falta refactorizar estas pruebas: 02 y 03
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


	@Test
	public void test04t1MuevoJugadorFueraDelMapaHaciaAbajoLanzaException() throws PosicionFueraDeRangoException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(-(posicionInicialJugadorEnY + 1)); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test04t2MuevoJugadorFueraDelMapaHaciaArribaLanzaException() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(24 - posicionInicialJugadorEnY + 1); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test04t3MuevoJugadorFueraDelMapaHaciaDerechaLanzaException() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(47 - posicionInicialJugadorEnX + 1); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test04t4MuevoJugadorFueraDelMapaHaciaIzquierdaLanzaException() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(-(posicionInicialJugadorEnX + 1)); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}


	@Test
	public void test05t1MuevoJugadorSobrePosicionOcupadaPorDiamante() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(10, 11);

		juego.colocarElementoEnPosicion(diamante, posicion);

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t2JugadorRodeadoPorDiamantesIntentaMoverseHaciaArribaYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(10, 11);
		Posicion posicion2 = new Posicion(10, 9);
		Posicion posicion3 = new Posicion(11, 10);
		Posicion posicion4 = new Posicion(9, 10);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t3JugadorRodeadoPorDiamantesIntentaMoverseHaciaAbajoYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(10, 11);
		Posicion posicion2 = new Posicion(10, 9);
		Posicion posicion3 = new Posicion(11, 10);
		Posicion posicion4 = new Posicion(9, 10);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(-1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t4JugadorRodeadoPorDiamantesIntentaMoverseHaciaIzquierdaYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(10, 11);
		Posicion posicion2 = new Posicion(10, 9);
		Posicion posicion3 = new Posicion(11, 10);
		Posicion posicion4 = new Posicion(9, 10);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(-1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t5JugadorRodeadoPorDiamantesIntentaMoverseHaciaDerechaYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(10, 11);
		Posicion posicion2 = new Posicion(10, 9);
		Posicion posicion3 = new Posicion(11, 10);
		Posicion posicion4 = new Posicion(9, 10);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}


	@Test
	public void test06t1PrimeraPosicionVaciaEncontradaEs00(){
		Juego juego = new Juego(24, 47);
		Posicion vacia = juego.obtenerPosicionVacia();
		Posicion posicion = new Posicion(0,0);
		assertEquals(posicion,vacia);
	}

}
