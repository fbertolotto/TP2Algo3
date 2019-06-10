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
	public void test01t2InicializacionDelJugadorEnMapaFuncionaCorrectamente() {
		Juego juego = new Juego(24,47);
		Jugador jugador = new Jugador();

		Posicion posicion = new Posicion(10,10);
		assertEquals(jugador.getPosicion(), juego.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test01t3ColocarMaterialEnPosicionYaOcupadaPorOtroMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24,47);

		Posicion posicion1 = new Posicion(1,1);
		juego.colocarElementoEnPosicion(new Madera(), posicion1);

		Posicion posicion2 = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Piedra(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t4ColocarJugadorEnPosicionYaOcupadaPorUnMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24,47);

		Posicion posicion1 = new Posicion(1,1);
		juego.colocarElementoEnPosicion(new Madera(), posicion1);

		Posicion posicion2 = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Jugador(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t5ColocarMaterialEnPosicion00YObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoMaterial() {
		Juego juego = new Juego(24,47);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(diamante,posicion);

		assertEquals(diamante,juego.obtenerElementoEnPosicion(posicion));
	}

	@Test
	public void test01t6ColocarJugadorEnPosicion00YObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoJugador() {
		Juego juego = new Juego(24,47);
		Jugador jugador = new Jugador();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(jugador,posicion);

		assertEquals(jugador,juego.obtenerElementoEnPosicion(posicion));
	}


	@Test
	public void test02t1MuevoJugador1PosicionHaciaAbajo() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnVertical(-1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY - 1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t2MuevoJugador1PosicionHaciaArriba() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnVertical(1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t3MuevoJugador1PosicionHaciaDerecha() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnHorizontal(1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX + 1, posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t4MuevoJugador1PosicionHaciaIzquierda() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnHorizontal(-1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX - 1, posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}


	@Test
	public void test03t1MuevoJugadorHastaBordeDelMapaHaciaAbajo() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnVertical(-posicionInicialJugadorEnY);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY - posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test03t2MuevoJugadorHastaBordeDelMapaHaciaArriba() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnVertical(24 - posicionInicialJugadorEnY);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + (24 - posicionInicialJugadorEnY));
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test03t3MuevoJugadorHastaBordeDelMapaHaciaDerecha() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnHorizontal(47 - posicionInicialJugadorEnX);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX + (47 - posicionInicialJugadorEnX), posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test03t4MuevoJugadorHastaBordeDelMapaHaciaIzquierda() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnHorizontal(-posicionInicialJugadorEnX);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX - posicionInicialJugadorEnX, posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
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
	public void test04t2MuevoJugadorFueraDelMapaHaciaArribaLanzaException() throws PosicionFueraDeRangoException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(24 - posicionInicialJugadorEnY + 1); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test04t3MuevoJugadorFueraDelMapaHaciaDerechaLanzaException() throws PosicionFueraDeRangoException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(47 - posicionInicialJugadorEnX + 1); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test04t4MuevoJugadorFueraDelMapaHaciaIzquierdaLanzaException() throws PosicionFueraDeRangoException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(-(posicionInicialJugadorEnX + 1)); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}


	@Test
	public void test05t1MuevoJugadorSobrePosicionOcupadaPorDiamanteLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);

		juego.colocarElementoEnPosicion(diamante, posicion);

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t2JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaArribaYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorEnX + 1, posicionInicialJugadorEnY);
		Posicion posicion4 = new Posicion(posicionInicialJugadorEnX - 1, posicionInicialJugadorEnY);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t3JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaAbajoYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorEnX + 1, posicionInicialJugadorEnY);
		Posicion posicion4 = new Posicion(posicionInicialJugadorEnX - 1, posicionInicialJugadorEnY);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnVertical(-1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t4JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaIzquierdaYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorEnX + 1, posicionInicialJugadorEnY);
		Posicion posicion4 = new Posicion(posicionInicialJugadorEnX - 1, posicionInicialJugadorEnY);
		juego.colocarElementoEnPosicion(diamante1, posicion1);
		juego.colocarElementoEnPosicion(diamante2, posicion2);
		juego.colocarElementoEnPosicion(diamante3, posicion3);
		juego.colocarElementoEnPosicion(diamante4, posicion4);

		boolean lanzoError = false;
		try { juego.moverJugadorEnHorizontal(-1); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05t5JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaDerechaYLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Diamante diamante4 = new Diamante();
		Posicion posicion1 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);
		Posicion posicion2 = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY - 1);
		Posicion posicion3 = new Posicion(posicionInicialJugadorEnX + 1, posicionInicialJugadorEnY);
		Posicion posicion4 = new Posicion(posicionInicialJugadorEnX - 1, posicionInicialJugadorEnY);
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
