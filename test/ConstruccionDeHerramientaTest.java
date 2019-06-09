import Modelo.Jugador.MesaDeCrafteo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ConstruccionDeHerramientaTest {

	@Test
	public void test01CraftearHachaDeMadera() {
		String HachaDeMadera = "Madera-Madera--Madera-Madera---Madera--";
		MesaDeCrafteo mesita = new MesaDeCrafteo();
		assertTrue(mesita.craftear(HachaDeMadera));
	}
}
