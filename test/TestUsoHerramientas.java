import Modelo.Herramientas.HachaDeMadera;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Material;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUsoHerramientas {

    @Test
    public void test01UsarHachaMaderaContraMaderaReduceAmbasDurabilidades() {
        Material madera = new Madera();
        Herramienta hacha = new HachaDeMadera();
        hacha.usar(madera);
        assertEquals(8,madera.getDurabilidad());
        assertEquals(98,hacha.getDurabilidad(),0.0f);
    }
}
