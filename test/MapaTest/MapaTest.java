package MapaTest;

import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Juego.MesaDeCrafteo;
import Modelo.Jugador.Jugador;
import Modelo.Mapa.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapaTest {

	@Test
	public void test01ColocarJugadorenMapaFuncionaCorrectamente() {
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador();
		mapa.colocarElementoEnPosicion(jugador, jugador.getPosicion());

		Posicion posicion = new Posicion(0,0);

		assertEquals(jugador.getPosicion(), mapa.obtenerElementoEnPosicion(posicion).getPosicion());
	}

	@Test
	public void test02ColocarMaterialEnPosicionDeMesaDeCrafteoYaOcupadaPorOtroMaterialLanzaException() throws PosicionOcupadaException {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(0,0);

		boolean lanzoError = false;
		try { mesa.colocarElementoEnPosicion(new Piedra(), posicion2); } catch (PosicionOcupadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

}
