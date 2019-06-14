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
	public void test02ElJugadorSeCreaConUnHachaEnSuInventario() {
		Jugador jugador = new Jugador();
		HachaDeMadera hacha = new HachaDeMadera();
		assertTrue(jugador.tieneUnaHerramienta(hacha));
	}

	@Test
	public void test03ElJugadorNoTieneUnPicoFinoCuandoInicia() {
		Jugador jugador = new Jugador();
		PicoFino pico = new PicoFino();
		assertFalse(jugador.tieneUnaHerramienta(pico));
	}

	@Test
	public void test04AgregoUnHachaDeMetalAlJugador() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

	}

	@Test
	public void test05AgregoUnHachaDeMetalAlJugadorYEstaEnLaPosicionSiguiente() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		Posicion posicion = new Posicion(1,0);
		assertEquals(posicion,hacha.getPosicion());

	}

	@Test
	public void test06AgregoUnHachaDeMetalYUnHachaDePiedraAlJugador() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		HachaDePiedra hachap = new HachaDePiedra();

		jugador.agregarEnInventario(hacha);
		jugador.agregarEnInventario(hachap);
		assertTrue(jugador.tieneUnaHerramienta(hachap));

	}

	@Test
	public void test07AgregoUnHachaDeMetalYUnHachaDePiedraAlJugadorYEstaEnLaPosicionQueLeSigue() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		HachaDePiedra hachap = new HachaDePiedra();
		jugador.agregarEnInventario(hacha);
		jugador.agregarEnInventario(hachap);

		Posicion posicion = new Posicion(2,0);
		assertEquals(posicion,hachap.getPosicion());

	}

	@Test
	public void test07AgregoUnHachaDeMetalYLaRemuevo() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		jugador.agregarEnInventario(hacha);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

		jugador.removerEnInventario(hacha);
		assertFalse(jugador.tieneUnaHerramienta(hacha));

	}

	@Test
	public void test08AgregoUnHachaDeMetalEnUnaPosicionEspecifica() {
		Jugador jugador = new Jugador();
		HachaDeMetal hacha = new HachaDeMetal();
		Posicion posicion = new Posicion(5,0);
		jugador.agregarEnInventarioEnPosicion(hacha,posicion);
		assertTrue(jugador.tieneUnaHerramienta(hacha));

	}
}
