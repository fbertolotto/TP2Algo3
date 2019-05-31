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

    @Test
    public void test03UsarPicoContraPiedraReduceAmbasDurabilidades() {
        Material piedra = new Piedra();
        Herramienta pico = new PicoDeMadera();
        pico.usar(piedra);
        assertEquals(28,piedra.getDurabilidad());
        assertEquals(98,pico.getDurabilidad(),0.0f);
    }

    @Test
    public void test04UsarHachaContraPiedraReduceSoloDurabilidadDelHacha() {
        Material piedra = new Piedra();
        Herramienta hacha = new HachaDeMetal();
        hacha.usar(piedra);
        assertEquals(30,piedra.getDurabilidad());
        assertEquals(395,hacha.getDurabilidad(),0.0f);
    }

    @Test
    public void test05UsarPicoDePiedraContraMetalReduceAmbasDurabilidades() {
        Material metal = new Metal();
        Herramienta picoDePiedra = new PicoDePiedra();
        picoDePiedra.usar(metal);
        assertEquals(46,metal.getDurabilidad());
        assertEquals(197.4,picoDePiedra.getDurabilidad(),0.1f);
    }

    @Test
    public void test06UsarHachaYPicoDeMaderaContraMetalReduceSoloDurabilidadDeHerramientas() {
        Material metal = new Metal();
        Herramienta hacha = new HachaDeMadera();
        Herramienta picoDeMadera = new PicoDeMadera();
        picoDeMadera.usar(metal);
        hacha.usar(metal);
        assertEquals(50,metal.getDurabilidad());
        assertEquals(98,hacha.getDurabilidad(),0.1f);
        assertEquals(98,picoDeMadera.getDurabilidad(),0.0f);
    }

}
