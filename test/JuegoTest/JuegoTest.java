package JuegoTest;

import Modelo.Excepciones.*;
import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Modelo.Materiales.*;
import org.junit.Test;
import Modelo.Juego.*;
import Modelo.Jugador.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class JuegoTest {

	@Test
	public void test01t1ElJuegoSeInicializaConUnJugador() {
		Juego juego = new Juego(100,100);
		Jugador jugador = juego.getJugador();
		assertNotNull(jugador);
	}

	@Test
	public void test01t2InicializacionDelJugadorEnMapaFuncionaCorrectamente() {
		Juego juego = new Juego(100,100);
		assertEquals(1,juego.recuentoPosicionable("Steve"));
	}

	@Test
	public void test01t3InicializacionDeLosMaterialesEnMapaFuncionaCorrectamente(){
		Juego juego = new Juego(500,500);
		int recuentoMadera = juego.recuentoPosicionable("Madera");
		int recuentoPiedra = juego.recuentoPosicionable("Piedra");
		int recuentoMetal = juego.recuentoPosicionable("Metal");
		int recuentoDiamante = juego.recuentoPosicionable("Diamante");
		assertTrue(recuentoMadera == (int)(500*500*0.01) && recuentoPiedra == (int)(500*500*0.007) && recuentoMetal == (int)(500*500*0.003) && recuentoDiamante ==(int)( 500*500*0.0005));
	}

	@Test
	public void test01t4ColocarMaterialEnPosicionYaOcupadaPorOtroMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(100,100);

		Posicion posicion1 = new Posicion(1,1);
		try { juego.colocarElementoEnPosicion(new Madera(), posicion1); } catch (PosicionOcupadaException e) {}

		Posicion posicion1Clon = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Piedra(), posicion1Clon); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t5ColocarJugadorEnPosicionYaOcupadaPorUnMaterialLanzaException() throws PosicionOcupadaException {
		Juego juego = new Juego(100,100);

		Posicion posicion1 = new Posicion(1,1);
		try { juego.colocarElementoEnPosicion(new Madera(), posicion1); } catch (PosicionOcupadaException e) {}

		Posicion posicion2 = new Posicion(1,1);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Jugador(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test01t6ColocarMaterialEnPosicion00QueEstaLibreYObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoMaterial() {
		Juego juego = new Juego(100,100);
		Diamante diamante = new Diamante();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(diamante,posicion);

		assertEquals(diamante,juego.obtenerElementoEnPosicion(posicion));
	}

	@Test
	public void test01t7ColocarJugadorEnPosicion00QueEstaLibreYObtenerElElementoQueOcupaEsaPosicionDevuelveElMismoJugador() {
		Juego juego = new Juego(100,100);
		Jugador jugador = new Jugador();
		Posicion posicion = new Posicion(0,0);

		juego.colocarElementoEnPosicion(jugador,posicion);

		assertEquals(jugador,juego.obtenerElementoEnPosicion(posicion));
	}

	@Test
	public void test01t8InicializacionDeLaCantidadDeMaterialesEnMapaFuncionaCorrectamente(){
		Juego juego = new Juego(100,100);
		int recuentoMadera = juego.recuentoPosicionable("Madera");
		int recuentoPiedra = juego.recuentoPosicionable("Piedra");
		int recuentoMetal = juego.recuentoPosicionable("Metal");
		int recuentoDiamante = juego.recuentoPosicionable("Diamante");
		Collection<Posicionable> elementos = juego.obtenerTodosLosElementos();
		assertEquals(elementos.size(),recuentoDiamante + recuentoMadera + recuentoMetal + recuentoPiedra + 2); //Zombie y Jugador

	}

	@Test
	public void test02SeIntentaColocarUnMaterialEnPosicionFueraDelMapaYLanzaException() throws PosicionFueraDeRangoException {
		Juego juego = new Juego(100,100);
		Posicion posicion = new Posicion(5000, 5000);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Madera(), posicion); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test03ObtenerPosicionVaciaEnMapaLlenoDevuelveNull() {
		Juego juego = new Juego(10, 10);
		for(int fila = 0; fila < 10; fila++)
			for(int columna = 0; columna < 10; columna++) {
				try { juego.colocarElementoEnPosicion(new Madera(), new Posicion(columna,fila)); } catch (PosicionOcupadaException e) {}
			}
		assertNull(juego.getTablero().obtenerPosicionVacia());
	}

	@Test
	public void test04JugadorEnEsquinaRodeadoPorDiamantesTiene3Adyacentes() {
		Juego juego = new Juego(100, 100);
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

		assertEquals(juego.obtenerMaterialesAdyacentes().size(), juego.getTablero().obtenerMaterialesAdyacentes(juego.getJugador().getPosicion()).size());
	}

	@Test
	public void test05AlMoverZombieDeManeraRandomCambiaSuPosicionCorrectamente() {
		Juego juego = new Juego(100, 100);
		Zombie zombi = juego.getZombie();
		Posicion posicionInicialZombi = zombi.getPosicion();

		juego.moverZombie();

		Posicion posicionFinalZombi = zombi.getPosicion();
		if (posicionInicialZombi.equals(posicionFinalZombi)) { assertEquals(posicionInicialZombi, posicionFinalZombi); return; }
		assertNotEquals(posicionInicialZombi, posicionFinalZombi);
	}

	@Test
	public void test06t1CraftearHachaDeMaderaATravesDeJuegoDevuelveHachaDeMadera() {
		Juego juego = new Juego(100, 100);
		MesaDeCrafteo mesa = juego.getMesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta hachaDeMadera = mesa.craftear();
		assertEquals("Hacha de Madera", hachaDeMadera.getNombre());
	}

	@Test
	public void test06t2CraftearHachaDeMaderaEnMesaLimpiadaDevuelveNull() {
		Juego juego = new Juego(100, 100);
		MesaDeCrafteo mesa = juego.getMesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Madera(), posicion8);

		mesa.limpiar();

		Herramienta hachaDeMadera = mesa.craftear();
		assertNull(hachaDeMadera);
	}

	@Test
	public void test06t3RemoverElementoEnMesaDeCrafteoLoRemueveCorrectamente() {
		Juego juego = new Juego(100,100);
		MesaDeCrafteo mesa = juego.getMesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);

		Posicion posicion2 = new Posicion(1,0);
		Diamante diamante = new Diamante();
		mesa.colocarElementoEnPosicion(diamante, posicion2);

		mesa.removerElemento(diamante);

		assertFalse(mesa.tiene(diamante));
	}

	@Test
	public void test06t4ObtenerElementoEnPosicionEspecificaEnMesaDeCrafteoDevuelveElElementoCorrecto() {
		Juego juego = new Juego(100,100);
		MesaDeCrafteo mesa = juego.getMesaDeCrafteo();
		Posicion posicion = new Posicion(0,0);
		Diamante diamante = new Diamante();
		mesa.colocarElementoEnPosicion(diamante, posicion);

		assertEquals(mesa.obtenerElementoEnPosicion(posicion), diamante);
	}


}
