import Modelo.Jugador.MesaDeCrafteo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CrafteoDeHerramientaTest {

	@Test
	public void test01CraftearHachaDeMadera() {
		String HachaDeMadera = "MA-MA- -MA-MA- -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		assertTrue(mesa.validar(HachaDeMadera));
	}
}
