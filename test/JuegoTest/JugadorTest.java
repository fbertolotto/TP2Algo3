package JuegoTest;

import Modelo.Herramientas.HachaDeMadera;
import Modelo.Herramientas.HachaDeMetal;
import Modelo.Herramientas.HachaDePiedra;
import Modelo.Herramientas.PicoFino;
import Modelo.Jugador.*;

import Modelo.Tablero.Posicion;
import org.junit.Test;

import static junit.framework.TestCase.*;

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
	public void test03ElJugadorSeCreaConUnHachaEnSuInventario() {
		Jugador jugador = new Jugador();
		HachaDeMadera hacha = new HachaDeMadera();
		assertTrue(jugador.tieneUnaHerramienta(hacha));
	}

	@Test
	public void test04ElJugadorNoTieneUnPicoFinoCuandoInicia() {
		Jugador jugador = new Jugador();
		PicoFino pico = new PicoFino();
		assertFalse(jugador.tieneUnaHerramienta(pico));
	}

	@Test
	public void test05AgregoUnHachaDeMetalAlJugador() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

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
	public void test07AgregoUnHachaDeMetalYUnHachaDePiedraAlJugador() {
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
	public void test09AgregoUnHachaDeMetalYLaRemuevo() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

		jugador.removerEnInventario(hacha);
		assertFalse(jugador.tieneUnaHerramienta(hacha));

	}

	@Test
	public void test10AgregoUnHachaDeMetalEnUnaPosicionEspecifica() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		Posicion posicion = new Posicion(5,0);
		jugador.agregarEnInventarioEnPosicion(hacha,posicion);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

	}

	@Test
	public void test11ELJugadorTieneUnHachaDeMaderaEquipada() {
		Jugador jugador = new Jugador();
		assertSame(jugador.obtenerHerramientaEquipada().getClass(), HachaDeMadera.class);

	}

	@Test
	public void test12ELJugadorCambiaSuHerramientaEquipada() {
		Jugador jugador = new Jugador();
		PicoFino pico = new PicoFino();
		jugador.cambiarHerramientaEquipada(pico);
		assertSame(jugador.obtenerHerramientaEquipada(), pico);

	}

	@Test
	public void test12ELJugadorTieneSuHachaDeMaderaEnLaPrimeraPosicionDelInventario() {
		Jugador jugador = new Jugador();
		Inventario inventario = jugador.getInventario();
		Posicion posicion = new Posicion(0,0);
		assertSame(inventario.obtenerElementoEnPosicion(posicion),jugador.obtenerHerramientaEquipada());

	}
}
