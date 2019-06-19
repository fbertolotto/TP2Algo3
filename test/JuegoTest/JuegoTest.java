package JuegoTest;

import Modelo.Excepciones.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Modelo.Materiales.*;
import org.junit.Test;
import Modelo.Juego.*;
import Modelo.Jugador.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JuegoTest {

	@Test
	public void test01t1ElJuegoSeInicializaConUnJugador() {
		Juego juego = new Juego(500, 500);
		Jugador jugador = juego.getJugador();
		assertNotNull(jugador);
	}

	@Test
	public void test01t2InicializacionDelJugadorEnMapaFuncionaCorrectamente() {
		Juego juego = new Juego(500, 500);
		assertEquals(1,juego.recuentoPosicionable("Steve"));
	}

	@Test
	public void test01t3InicializacionDeLosMaterialesEnMapaFuncionaCorrectamente(){
		Juego juego = new Juego(500, 500);
		int recuentoMadera = juego.recuentoPosicionable("Madera");
		int recuentoPiedra = juego.recuentoPosicionable("Piedra");
		int recuentoMetal = juego.recuentoPosicionable("Metal");
		int recuentoDiamante = juego.recuentoPosicionable("Diamante");
		assertTrue(recuentoMadera == (int)(500*500*0.01) && recuentoPiedra == (int)(500*500*0.007) && recuentoMetal == (int)(500*500*0.003) && recuentoDiamante ==(int)( 500*500*0.0005));
	}

	@Test
	public void test01t4ColocarMaterialEnPosicionYaOcupadaPorOtroMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(500, 500);

		Posicion posicion1 = new Posicion(1,1);
		try { juego.colocarElementoEnPosicion(new Madera(), posicion1); } catch (PosicionOcupadaException e) {}

		Posicion posicion1Clon = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Piedra(), posicion1Clon); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t5ColocarJugadorEnPosicionYaOcupadaPorUnMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(500, 500);

		Posicion posicion1 = new Posicion(1,1);
		try { juego.colocarElementoEnPosicion(new Madera(), posicion1); } catch (PosicionOcupadaException e) {}

		Posicion posicion2 = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Jugador(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t6ColocarMaterialEnPosicion00QueEstaLibreYObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoMaterial() {
		Juego juego = new Juego(500, 500);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(diamante,posicion);

		assertEquals(diamante,juego.obtenerElementoEnPosicion(posicion));
	}

	@Test
	public void test01t7ColocarJugadorEnPosicion00QueEstaLibreYObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoJugador() {
		Juego juego = new Juego(500, 500);
		Jugador jugador = new Jugador();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(jugador,posicion);

		assertEquals(jugador,juego.obtenerElementoEnPosicion(posicion));
	}

	//En prueba02 se mueve al jugador hasta borde izquierdo o superior para poder moverlo sabiendo que no hay obstaculos.
	@Test
	public void test02t1MuevoJugador1PosicionHaciaAbajoCambiaSuPosicionCorrectamente() {
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
	public void test02t2MuevoJugador1PosicionHaciaArribaCambiaSuPosicionCorrectamente() {
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
	public void test02t3MuevoJugador1PosicionHaciaDerechaCambiaSuPosicionCorrectamente() {
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
	public void test02t4MuevoJugador1PosicionHaciaIzquierdaCambiaSuPosicionCorrectamente() {
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

	//Dado que no spawnean bloques en los bordes esta prueba03 es deterministica y nunca deberia levantar excepciones.
	@Test
	public void test03t1MuevoJugadorHastaBordeDelMapaHaciaAbajo() {
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
	public void test03t2MuevoJugadorHastaBordeDelMapaHaciaArriba() {
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
	public void test03t3MuevoJugadorHastaBordeDelMapaHaciaDerecha() {
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
	public void test03t4MuevoJugadorHastaBordeDelMapaHaciaIzquierda() {
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
	public void test04t1SeIntentaMoverJugadorFueraDelMapaHaciaAbajoPeroQuedaEnLaMismaUltimaPosicion() {
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
	public void test04t2SeIntentaMoverJugadorFueraDelMapaHaciaArribaPeroQuedaEnLaMismaUltimaPosicion() {
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
	public void test04t3SeIntentaMoverJugadorFueraDelMapaHaciaDerechaPeroQuedaEnLaMismaUltimaPosicion() {
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
	public void test04t4SeIntentaMoverJugadorFueraDelMapaHaciaIzquierdaPeroQuedaEnLaMismaUltimaPosicion() {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();

		juego.moverJugadorEnHorizontal(-posicionInicialJugadorColumna);
		Posicion posicionBordeJugador = juego.getJugador().getPosicion();

		juego.moverJugadorEnHorizontal(-1);
		Posicion posicionActualJugador = juego.getJugador().getPosicion();

		assertEquals(posicionBordeJugador, posicionActualJugador);
	}

	//Mismo criterio deterministico de prueba03 para prueba05.
	@Test
	public void test05t1MuevoJugadorSobrePosicionOcupadaPorDiamanteJugadorQuedaEnLaMismaPosicion() {
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
	public void test05t2JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaArribaYJugadorQuedaEnLaMismaPosicion() {
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
	public void test05t3JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaAbajoYJugadorQuedaEnLaMismaPosicion() {
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
	public void test05t4JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaIzquierdaYJugadorQuedaEnLaMismaPosicion() {
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
	public void test05t5JugadorRodeadoPorDiamantesIntentaMoverse1PosicionHaciaDerechaYJugadorQuedaEnLaMismaPosicion() {
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

	@Test
	public void test06t1JugadorIntentaUsarSuHachaContraDiamanteYSeQuedaSinHerramienta() throws HerramientaEquipadaNulaExeption {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);

		try { juego.colocarElementoEnPosicion(diamante, posicion); } catch (PosicionOcupadaException e) {}
		try { juego.usarHerramienta(diamante);} catch (DurabilidadAgotadaException e) {}

		boolean lanzoError = false;
		try { juego.usarHerramienta(diamante);} catch (HerramientaEquipadaNulaExeption e) { lanzoError = true; }
		assertTrue(lanzoError);

	}

	@Test
	public void test06t2JugadorIntentaUsarSuHachaContraMaderaLejana() throws MaterialFueraDeAlcanceExeption {
		Juego juego = new Juego(500, 500);

		Madera madera = new Madera();
		Posicion posicionmadera = new Posicion(0,  2);
		Posicion posicionjugador = new Posicion(0,  0);

		juego.colocarElementoEnPosicion(madera,posicionmadera);
		juego.colocarElementoEnPosicion(juego.getJugador(),posicionjugador);

		boolean lanzoError = false;
		try { juego.usarHerramienta(madera);} catch (MaterialFueraDeAlcanceExeption e) { lanzoError = true; }
		assertTrue(lanzoError);

	}

	@Test
	public void test06t3JugadorIntentaEquiparUnMaterialComoHerramientaEquipada() throws MaterialNoEsEquipableExeption {
		Juego juego = new Juego(500, 500);
		Madera madera = new Madera();

		boolean lanzoError = false;
		try { juego.getJugador().cambiarHerramientaEquipada(madera);} catch (MaterialNoEsEquipableExeption e) { lanzoError = true; }
		assertTrue(lanzoError);

	}

	@Test
	public void test06t4JugadorEnEsquinaRodeadoPorDiamantesTiene3Adyacentes() {
		Juego juego = new Juego(500, 500);
		Posicion posicion = new Posicion(0,0);
		juego.colocarElementoEnPosicion(juego.getJugador(),posicion);

		Diamante diamante1 = new Diamante();
		Diamante diamante2 = new Diamante();
		Diamante diamante3 = new Diamante();
		Posicion posicion1 = new Posicion(0, 1);
		Posicion posicion2 = new Posicion(1,  1);
		Posicion posicion3 = new Posicion(1,  0);


		try { juego.colocarElementoEnPosicion(diamante1, posicion1); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante2, posicion2); } catch (PosicionOcupadaException e) {}
		try { juego.colocarElementoEnPosicion(diamante3, posicion3); } catch (PosicionOcupadaException e) {}

		ArrayList<Posicionable> diamantes = juego.getTablero().obtenerMaterialesAdyacentes(juego.getJugador().getPosicion());
		assertEquals(diamantes.size(), 3);

	}

/*
	@Test
	public void testObtenerElementoEnPosicionAdelante() {
		Juego juego = new Juego(24, 47);
		Madera madera = new Madera();
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Posicion posicion1 = new Posicion(posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		try { juego.colocarElementoEnPosicion(madera, posicion1); } catch (PosicionOcupadaException e) {}
		juego.usarHerramienta(madera);
		System.out.println(juego.getJugador().getInventario().obtenerTodosLosElementos());
	}
*/
}
