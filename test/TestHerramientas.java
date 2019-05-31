import Modelo.HachaDeMadera;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestHerramientas {
    @Test
    public void test01CrearHachaDeMaderaConSuDurablidadCorrespondiente() {
        HachaDeMadera hacha = new HachaDeMadera();
        assertTrue(hacha.getDurabilidad() == 100);
    }

    @Test
    public void test02CrearHachaDeMaderaConSuFuerzaCorrespondiente(){
        HachaDeMadera hacha = new HachaDeMadera();
        assertTrue(hacha.getFuerza()== 2);
    }



}
