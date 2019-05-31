import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUsoHerramientas {

    @Test
    public void test01UsarHachaContraMaderaReduceAmbasDurabilidades() {
        Material madera = new Madera();
        Herramienta hacha = new HachaDeMadera();
        hacha.usar(madera);
        assertEquals(8,madera.getDurabilidad());
        assertEquals(98,hacha.getDurabilidad(),0.0f);
    }

    @Test
    public void test02UsarPicoContraMaderaReduceSoloDurabilidadDelPico() {
        Material madera = new Madera();
        Herramienta pico = new PicoDeMadera();
        pico.usar(madera);
        assertEquals(10,madera.getDurabilidad());
        assertEquals(98,pico.getDurabilidad(),0.0f);
    }
}
