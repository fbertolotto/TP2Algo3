package JugadorTest;

import Modelo.Excepciones.*;
import Modelo.Herramientas.*;
import Modelo.Juego.Juego;
import Modelo.Jugador.*;

import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Tablero.Posicion;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

	@Test
	public void test01ElJugadorSeCreaCorrectamente() {
		Jugador jugador = new Jugador();
		assertNotNull(jugador);
	}

	@Test
	public void test02ElJugadorSeCreaCorrectamenteConSuInventario() {
		Jugador jugador = new Jugador();
		Inventario inventario = jugador.getInventario();
		assertNotNull(inventario);
	}

	@Test
	public void test03t1ElJugadorSeCreaConUnHachaEnSuInventario() {
		Jugador jugador = new Jugador();
		HachaDeMadera hacha = new HachaDeMadera();
		assertTrue(jugador.tieneUnaHerramienta(hacha));
	}

	@Test
	public void test03t2ELJugadorSeCreaConUnHachaEnSuInventarioYEquipada() {
		Jugador jugador = new Jugador();
		assertSame(jugador.obtenerHerramientaEquipada().getClass(), HachaDeMadera.class);
	}

	@Test
	public void test04ElJugadorNoTieneUnPicoFinoCuandoInicia() {
		Jugador jugador = new Jugador();
		PicoFino pico = new PicoFino();
		assertFalse(jugador.tieneUnaHerramienta(pico));
	}

	@Test
	public void test05t1AgregoUnHachaDeMetalAlJugadorYAlPedirlaDevuelveTrue() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));
	}

	@Test
	public void test05t2AgregoUnHachaDeMetalAlJugadorYAlPedirleUnPicoDePiedraDevuelveFalse() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		PicoDePiedra pico = new PicoDePiedra();
		jugador.agregarEnInventario(hacha);
		assertFalse(jugador.tieneUnaHerramienta(pico));
	}

	@Test
	public void test06AgregoUnHachaDeMetalAlJugadorYEstaEnLaPosicionSiguiente() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		Posicion posicion = new Posicion(1,0);
		assertEquals(posicion,hacha.getPosicion());
	}

	@Test
	public void test07AgregoUnHachaDeMetalYUnHachaDePiedraAlJugadorYTieneElHachaDePiedra() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		HachaDePiedra hachap = new HachaDePiedra();

		jugador.agregarEnInventario(hacha);
		jugador.agregarEnInventario(hachap);
		assertTrue(jugador.tieneUnaHerramienta(hachap));
	}

	@Test
	public void test08AgregoUnHachaDeMetalYUnHachaDePiedraAlJugadorYEstaEnLaPosicionQueLeSigue() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		HachaDePiedra hachap = new HachaDePiedra();
		jugador.agregarEnInventario(hacha);
		jugador.agregarEnInventario(hachap);

		Posicion posicion = new Posicion(2,0);
		assertEquals(posicion,hachap.getPosicion());
	}

	@Test
	public void test09t1AgregoUnHachaDeMetalLaRemuevoYVerificoQueNoLaTenga() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

		jugador.removerEnInventario(hacha);
		assertFalse(jugador.tieneUnaHerramienta(hacha));
	}

	@Test
	public void test09t2AgregoUnHachaDeMetalYLuegoIntentoRemoverOtraHerramientaPeroNoSucedeNada() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		PicoDePiedra pico = new PicoDePiedra();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

		jugador.removerEnInventario(pico);
	}

	@Test
	public void test09t3RemuevoHachaDeMaderaEquipadaPorJugadorYAhoraEquipadaEsNull() {
		Jugador jugador = new Jugador();
		jugador.removerHerramientaEquipada();

		assertNull(jugador.obtenerHerramientaEquipada());
	}

	@Test
	public void test10SeAgregaUnHachaDeMetalEnUnaPosicionEspecificaYAlPedirSiTieneLaHeramientaDevuelveTrue() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		Posicion posicion = new Posicion(5,0);
		jugador.agregarEnInventarioEnPosicion(hacha,posicion);
		assertTrue(jugador.tieneUnaHerramienta(hacha));
	}

	@Test
	public void test11ELJugadorTieneSuHachaDeMaderaEnLaPrimeraPosicionDelInventario() {
		Jugador jugador = new Jugador();
		Inventario inventario = jugador.getInventario();
		Posicion posicion = new Posicion(0,0);
		assertSame(inventario.obtenerElementoEnPosicion(posicion),jugador.obtenerHerramientaEquipada());
	}

	@Test
	public void test12t1ELJugadorCambiaSuHerramientaEquipadaAPicoYAlPedirlaDevuelveLaCorrecta() {
		Jugador jugador = new Jugador();
		PicoFino pico = new PicoFino();
		jugador.cambiarHerramientaEquipada(pico);
		assertSame(jugador.obtenerHerramientaEquipada(), pico);
	}

	@Test
	public void test12t2ELJugadorCambiaSuHerramientaEquipadaAPicoYAlPedirlaNoDevuelveOtraHerramienta() {
		Jugador jugador = new Jugador();
		PicoFino pico = new PicoFino();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.cambiarHerramientaEquipada(pico);
		assertNotSame(jugador.obtenerHerramientaEquipada(), hacha);
	}

	@Test
	public void test12t3JugadorIntentaEquiparUnMaterialYLanzaException() throws MaterialNoEsEquipableExeption {
		Jugador jugador = new Jugador();
		Madera madera = new Madera();

		boolean lanzoError = false;
		try { jugador.cambiarHerramientaEquipada(madera);} catch (MaterialNoEsEquipableExeption e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test13t1JugadorIntentaUsarSuHachaContraDiamanteYSeQuedaSinHerramienta() throws HerramientaEquipadaNulaExeption {
		Juego juego = new Juego(500, 500);
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Diamante diamante = new Diamante();
		Posicion posicionJugador = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila);
		Posicion posicionMaterial = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);
		juego.colocarElementoEnPosicion(juego.getJugador(), posicionJugador);
		juego.colocarElementoEnPosicion(diamante, posicionMaterial);

		try { juego.usarHerramienta(diamante);} catch (DurabilidadAgotadaException e) {}

		boolean lanzoError = false;
		try { juego.usarHerramienta(diamante);} catch (HerramientaEquipadaNulaExeption e) { lanzoError = true; }
		assertTrue(lanzoError);

	}

	@Test
	public void test13t2JugadorUsaSuHachaDeMaderaContraMaderaYElMaterialAgotaSuDurabilidadObteniendoloSatisfactoriamente() {
		Juego juego = new Juego(500, 500);
		Jugador jugador = juego.getJugador();
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Madera madera = new Madera();
		Posicion posicionJugador = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila);
		Posicion posicionMaterial = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila + 1);

		juego.colocarElementoEnPosicion(jugador, posicionJugador);
		juego.colocarElementoEnPosicion(madera, posicionMaterial);
		jugador.usarHerramientaEquipada(madera);

		assertTrue(madera.getDurabilidad() <= 0);
	}

	@Test
	public void test13t3JugadorEnElJuegoIntentaUsarSuHachaContraMaderaLejanaYLanzaException() throws MaterialFueraDeAlcanceExeption {
		Juego juego = new Juego(500, 500);
		Jugador jugador = juego.getJugador();
		Posicion posicionInicialJugador = juego.getJugador().getPosicion();
		int posicionInicialJugadorFila = posicionInicialJugador.getFila();
		int posicionInicialJugadorColumna = posicionInicialJugador.getColumna();
		Madera madera = new Madera();
		Posicion posicionJugador = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila);
		Posicion posicionMaterial = new Posicion(posicionInicialJugadorColumna - posicionInicialJugadorColumna, posicionInicialJugadorFila + 2);

		juego.colocarElementoEnPosicion(jugador, posicionJugador);
		juego.colocarElementoEnPosicion(madera, posicionMaterial);

		boolean lanzoError = false;
		try { juego.usarHerramienta(madera);} catch (MaterialFueraDeAlcanceExeption e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test14t1ObtenerInventarioDeJugadorDevuelveUnInventario() {
		Jugador jugador = new Jugador();
		assertSame(jugador.getInventario().getClass(), Inventario.class);
	}

	@Test
	public void test14t2ObtenerInventarioDeJugadorNoDevuelveNull() {
		Jugador jugador = new Jugador();
		assertNotNull(jugador.getInventario());
	}

	@Test
	public void test15JugadorIntentaDesgastarseASiMismoYLevantaException() throws UsarHerramientaEnJugadorExeption {
		Juego juego = new Juego(500, 500);
		Jugador jugador = juego.getJugador();

		boolean lanzoError = false;
		try { juego.usarHerramienta(jugador); } catch (UsarHerramientaEnJugadorExeption e) { lanzoError = true; }
		assertTrue(lanzoError);
	}



}


