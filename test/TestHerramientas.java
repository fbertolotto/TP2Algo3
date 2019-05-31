import Modelo.HachaDeMadera;
import Modelo.PicoDeMadera;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestHerramientas {

    @Test
    public void test01CrearHachaDeMaderaConSuDurablidadCorrespondiente() {
        HachaDeMadera hacha = new HachaDeMadera();
        assertEquals(100, hacha.getDurabilidad());
    }

    @Test
    public void test02CrearHachaDeMaderaConSuFuerzaCorrespondiente(){
        HachaDeMadera hacha = new HachaDeMadera();
        assertEquals(2, hacha.getFuerza());
    }

    @Test
    public void test03CrearPicoDeMaderaConSuDurabilidadCorrespondiente() {
        PicoDeMadera pico = new PicoDeMadera();
        assertEquals(100, pico.getDurabilidad());
    }

    @Test
    public void test04CrearPicoDeMaderaConSuFuerzaCorrespondiente() {
        PicoDeMadera pico = new PicoDeMadera();
        assertEquals(2, pico.getFuerza());
    }




}
