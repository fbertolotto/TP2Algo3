package JugadorTest;

import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Juego.Juego;
import Modelo.Materiales.Diamante;
import Modelo.Tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovimientoJugadorTest {

	//En prueba01 se mueve al jugador hasta borde izquierdo o superior para poder moverlo sabiendo que no hay obstaculos.
	@Test
	public void test01t1MuevoJugador1PosicionHaciaAbajoCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		juego.moverJugadorEnHorizontal(-posicionInicialJugadorColumna);

		juego.moverJugadorEnVertical(-1);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila - 1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test01t2MuevoJugador1PosicionHaciaArribaCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		juego.moverJugadorEnHorizontal(-posicionInicialJugadorColumna);

		juego.moverJugadorEnVertical(1);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test01t3MuevoJugador1PosicionHaciaDerechaCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		juego.moverJugadorEnVertical(-posicionInicialJugadorFila);

		juego.moverJugadorEnHorizontal(1);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna + 1, posicionInicialJugadorFila - posicionInicialJugadorFila);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test01t4MuevoJugador1PosicionHaciaIzquierdaCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		juego.moverJugadorEnVertical(-posicionInicialJugadorFila);

		juego.moverJugadorEnHorizontal(-1);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna - 1, posicionInicialJugadorFila - posicionInicialJugadorFila);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	//Dado que no spawnean bloques en los bordes esta prueba02 es deterministica y nunca deberia levantar excepciones.
	@Test
	public void test02t1MuevoJugadorHastaBordeDelMapaHaciaAbajo() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnVertical(-posicionInicialJugadorFila);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila - posicionInicialJugadorFila);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t2MuevoJugadorHastaBordeDelMapaHaciaArriba() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnVertical(500 - posicionInicialJugadorFila);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + (500 - posicionInicialJugadorFila));
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t3MuevoJugadorHastaBordeDelMapaHaciaDerecha() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnHorizontal(500 - posicionInicialJugadorColumna);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna + (500 - posicionInicialJugadorColumna), posicionInicialJugadorFila);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t4MuevoJugadorHastaBordeDelMapaHaciaIzquierda() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnHorizontal(-posicionInicialJugadorColumna);

		Posicion posicion = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}


	@Test
	public void test03t1SeIntentaMoverJugadorFueraDelMapaHaciaAbajoPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();

		juego.moverJugadorEnVertical(-posicionInicialJugadorFila);

		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnVertical(-1);

		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	@Test
	public void test03t2SeIntentaMoverJugadorFueraDelMapaHaciaArribaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();

		juego.moverJugadorEnVertical(500 - posicionInicialJugadorFila);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnVertical(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	@Test
	public void test03t3SeIntentaMoverJugadorFueraDelMapaHaciaDerechaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnHorizontal(500 - posicionInicialJugadorColumna);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnHorizontal(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	@Test
	public void test03t4SeIntentaMoverJugadorFueraDelMapaHaciaIzquierdaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnHorizontal(-posicionInicialJugadorColumna);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnHorizontal(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	//Mismo criterio deterministico de prueba01 para prueba04.
	@Test
	public void test04t1MuevoJugadorSobrePosicionOcupadaPorDiamanteJugadorQuedaEnLaMismaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);

		try { juego.colocarElementoEnPosicion(diamante, posicion); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnVertical(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test04t2JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaArribaYJugadorQuedaEnLaMismaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorColumna + 1, posicionInicialJugadorFila);
		Posicion posicion4 = new Posicion(posicionInicialJugadorColumna - 1, posicionInicialJugadorFila);
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnVertical(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test04t3JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaAbajoYJugadorQuedaEnLaMismaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorColumna + 1, posicionInicialJugadorFila);
		Posicion posicion4 = new Posicion(posicionInicialJugadorColumna - 1, posicionInicialJugadorFila);
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnVertical(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test04t4JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaIzquierdaYJugadorQuedaEnLaMismaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorColumna + 1, posicionInicialJugadorFila);
		Posicion posicion4 = new Posicion(posicionInicialJugadorColumna - 1, posicionInicialJugadorFila);
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch(PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch(PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch(PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch(PosicionOcupadaException e) {}

		juego.moverJugadorEnHorizontal(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test04t5JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaDerechaYJugadorQuedaEnLaMismaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorColumna + 1, posicionInicialJugadorFila);
		Posicion posicion4 = new Posicion(posicionInicialJugadorColumna - 1, posicionInicialJugadorFila);
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnHorizontal(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}
}
