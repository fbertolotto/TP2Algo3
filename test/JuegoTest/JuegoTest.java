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

	@Test
	public void test02SeIntentaColocarUnMaterialEnPosicionFueraDelMapaYLanzaException() throws PosicionFueraDeRangoException {
		Juego juego = new Juego(500, 500);
		Posicion posicion = new Posicion(5000, 5000);

		boolean lanzoError = false;
		try { juego.colocarElementoEnPosicion(new Madera(), posicion); } catch (PosicionFueraDeRangoException e) { lanzoError = true; }
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
