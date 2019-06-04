import Modelo.Herramientas.HachaDeMadera;
import Modelo.Jugador.*;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class JugadorTest {

    @Test
    public void test01ElJugadorSeCreaCorrectamente() {
        Jugador jugador = new Jugador();
        assertNotNull(jugador);
    }

    @Test
    public void test02ElJugadorSeCreaConUnHacha() {
        Jugador jugador = new Jugador();
        assertTrue(jugador.tieneUnaHerramienta(HachaDeMadera.class));
    }


}