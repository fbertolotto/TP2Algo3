package JuegoTest;

import Modelo.Excepciones.*;
import Modelo.Tablero.Posicion;
import Modelo.Materiales.*;
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
		Juego juego = new Juego(24, 47);
		assertEquals(1,juego.recuentoPosicionable("Jugador"));
	}

	@Test
	public void test01t3InicializacionDeLosMaterialesEnMapaFuncionaCorrectamente(){
		Juego juego = new Juego(24, 47);
		int recuentoMadera = juego.recuentoPosicionable("Madera");
		int recuentoPiedra = juego.recuentoPosicionable("Piedra");
		int recuentoMetal = juego.recuentoPosicionable("Metal");
		int recuentoDiamante = juego.recuentoPosicionable("Diamante");
		assertTrue(recuentoMadera == 8 && recuentoPiedra == 6 && recuentoMetal == 4 && recuentoDiamante == 2);
	}

	@Test
	public void test01t4ColocarMaterialEnPosicionYaOcupadaPorOtroMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24,47);

		Posicion posicion1 = new Posicion(1,1);
		try { juego.colocarElementoEnPosicion(new Madera(), posicion1); } catch (PosicionOcupadaException e) {}

		Posicion posicion1Clon = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Piedra(), posicion1Clon); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t5ColocarJugadorEnPosicionYaOcupadaPorUnMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(24,47);

		Posicion posicion1 = new Posicion(1,1);
		try { juego.colocarElementoEnPosicion(new Madera(), posicion1); } catch (PosicionOcupadaException e) {}

		Posicion posicion2 = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Jugador(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t6ColocarMaterialEnPosicion00QueEstaLibreYObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoMaterial() {
		Juego juego = new Juego(24,47);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(diamante,posicion);

		assertEquals(diamante,juego.obtenerElementoEnPosicion(posicion));
	}

	@Test
	public void test01t7ColocarJugadorEnPosicion00QueEstaLibreYObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoJugador() {
		Juego juego = new Juego(24,47);
		Jugador jugador = new Jugador();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(jugador,posicion);

		assertEquals(jugador,juego.obtenerElementoEnPosicion(posicion));
	}

	//En prueba02 se mueve al jugador hasta borde izquierdo o superior para poder moverlo sabiendo que no hay obstaculos.
	@Test
	public void test02t1MuevoJugador1PosicionHaciaAbajoCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		juego.moverJugadorEnHorizontal(-posicionInicialJugadorEnX);

		juego.moverJugadorEnVertical(-1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX - posicionInicialJugadorEnX, posicionInicialJugadorEnY - 1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t2MuevoJugador1PosicionHaciaArribaCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		juego.moverJugadorEnHorizontal(-posicionInicialJugadorEnX);

		juego.moverJugadorEnVertical(1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX - posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t3MuevoJugador1PosicionHaciaDerechaCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		juego.moverJugadorEnVertical(-posicionInicialJugadorEnY);

		juego.moverJugadorEnHorizontal(1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX + 1, posicionInicialJugadorEnY - posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	@Test
	public void test02t4MuevoJugador1PosicionHaciaIzquierdaCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();
		juego.moverJugadorEnVertical(-posicionInicialJugadorEnY);

		juego.moverJugadorEnHorizontal(-1);

		Posicion posicion = new Posicion(posicionInicialJugadorEnX - 1, posicionInicialJugadorEnY - posicionInicialJugadorEnY);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();
		assertEquals(posicion, posicionActualJugador);
	}

	//Dado que no spawnean bloques en los bordes esta prueba03 es deterministica y nunca deberia levantar excepciones.
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
	public void test04t1SeIntentaMoverJugadorFueraDelMapaHaciaAbajoPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();

		juego.moverJugadorEnVertical(-posicionInicialJugadorEnY);

		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnVertical(-1);

		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	@Test
	public void test04t2SeIntentaMoverJugadorFueraDelMapaHaciaArribaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();

		juego.moverJugadorEnVertical(24 - posicionInicialJugadorEnY);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnVertical(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	@Test
	public void test04t3SeIntentaMoverJugadorFueraDelMapaHaciaDerechaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnHorizontal(47 - posicionInicialJugadorEnX);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnHorizontal(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	@Test
	public void test04t4SeIntentaMoverJugadorFueraDelMapaHaciaIzquierdaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		juego.moverJugadorEnHorizontal(-posicionInicialJugadorEnX);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnHorizontal(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	//Mismo criterio deterministico de prueba03 para prueba05.
	@Test
	public void test05t1MuevoJugadorSobrePosicionOcupadaPorDiamanteJugadorQuedaEnLaMismaPosicion() {
		Juego juego = new Juego(24, 47);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorEnY = posicionInicialJugador.getPosY();
		int posicionInicialJugadorEnX = posicionInicialJugador.getPosX();

		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(posicionInicialJugadorEnX, posicionInicialJugadorEnY + 1);

		try { juego.colocarElementoEnPosicion(diamante, posicion); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnVertical(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test05t2JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaArribaYJugadorQuedaEnLaMismaPosicion() {
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
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnVertical(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test05t3JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaAbajoYJugadorQuedaEnLaMismaPosicion() {
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
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnVertical(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test05t4JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaIzquierdaYJugadorQuedaEnLaMismaPosicion() {
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
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch(PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch(PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch(PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch(PosicionOcupadaException e) {}

		juego.moverJugadorEnHorizontal(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	@Test
	public void test05t5JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaDerechaYJugadorQuedaEnLaMismaPosicion() {
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
		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante4, posicion4); } catch (PosicionOcupadaException e) {}

		juego.moverJugadorEnHorizontal(1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionInicialJugador, posicionActualJugador);
	}

	/*
	@Test
	public void test06t1PrimeraPosicionVaciaEncontradaEs00(){
		Juego juego = new Juego(24, 47);
		Posicion vacia = juego.obtenerPosicionVacia();
		Posicion posicion = new Posicion(0,0);
		assertEquals(posicion,vacia);
	}
	*/


}
