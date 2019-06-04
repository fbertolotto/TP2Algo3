import Modelo.Herramientas.HachaDeMadera;
import Modelo.Herramientas.PicoFino;
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

    @Test
    public void test03ElJugadorNoTieneUnPicoFinoCuandoInicia() {
        Jugador jugador = new Jugador();
        assertFalse(jugador.tieneUnaHerramienta(PicoFino.class));
    }

}