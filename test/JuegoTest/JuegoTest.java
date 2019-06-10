package JuegoTest;

import org.junit.Test;
import Modelo.Juego.*;
import Modelo.Jugador.*;

import static org.junit.Assert.*;

public class JuegoTest {

	@Test
	public void test01ElJuegoSeInicializaConUnJugador() {
		Juego juego = new Juego();
		Jugador jugador = juego.getJugador();
		assertNotNull(jugador);
	}

}
