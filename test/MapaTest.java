import Modelo.Jugador.Jugador;
import Modelo.Mapa.Mapa;
import Modelo.Mapa.Posicion;
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

}
