import Modelo.Herramientas.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CreacionHerramientasTest {

	@Test
	public void test01CrearHachaDeMaderaConSuDurablidadCorrespondiente() {
		HachaDeMadera hacha = new HachaDeMadera();
		assertEquals(100, hacha.getDurabilidad(), 0.0f);
	}

	@Test
	public void test02CrearHachaDeMaderaConSuFuerzaCorrespondiente() {
		HachaDeMadera hacha = new HachaDeMadera();
		assertEquals(2, hacha.getFuerza());
	}

	@Test
	public void test03CrearPicoDeMaderaConSuDurabilidadCorrespondiente() {
		PicoDeMadera pico = new PicoDeMadera();
		assertEquals(100, pico.getDurabilidad(), 0.0f);
	}

	@Test
	public void test04CrearPicoDeMaderaConSuFuerzaCorrespondiente() {
		PicoDeMadera pico = new PicoDeMadera();
		assertEquals(2, pico.getFuerza());
	}

	@Test
	public void test05CrearHachaDeMetalConSuDurablidadCorrespondiente() {
		HachaDeMetal hacha = new HachaDeMetal();
		assertEquals(400, hacha.getDurabilidad(), 0.0f);
	}

	@Test
	public void test06CrearHachaDeMetalConSuFuerzaCorrespondiente() {
		HachaDeMetal hacha = new HachaDeMetal();
		assertEquals(10, hacha.getFuerza());
	}

	@Test
	public void test07CrearPicoDeMetalConSuDurabilidadCorrespondiente() {
		PicoDeMetal pico = new PicoDeMetal();
		assertEquals(400, pico.getDurabilidad(), 0.0f);
	}

	@Test
	public void test08CrearPicoDeMetalConSuFuerzaCorrespondiente() {
		PicoDeMetal pico = new PicoDeMetal();
		assertEquals(12, pico.getFuerza());
	}

	@Test
	public void test09CrearPicoFinoConSuDurabilidadCorrespondiente() {
		PicoFino pico = new PicoFino();
		assertEquals(1000, pico.getDurabilidad(), 0.0f);
	}

	@Test
	public void test10CrearPicoFinoConSuFuerzaCorrespondiente() {
		PicoFino pico = new PicoFino();
		assertEquals(20, pico.getFuerza());
	}
}
