import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DesgasteMaterialesTest {

	@Test
	public void test01t1MaderaSeGolpeaConHachaDeMaderaReduceDurabilidadMadera() {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(madera);
		assertEquals(8,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t2MaderaSeGolpeaConHachaDePiedraReduceDurabilidadMadera() {
		Material madera = new Madera();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(madera);
		assertEquals(5,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t3MaderaSeGolpeaConHachaDeMetalReduceDurabilidadMadera() {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(madera);
		assertEquals(0,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t4MaderaSeGolpeaConPicoDeMaderaNoReduceDurabilidad() {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t5MaderaSeGolpeaConPicoDePiedraNoReduceDurabilidad() {
		Material madera = new Madera();
		Herramienta pico = new PicoDePiedra();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t6MaderaSeGolpeaConPicoDeMetalNoReduceDurabilidad() {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMetal();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t7MaderaSeGolpeaConPicoFinoNoReduceDurabilidad() {
		Material madera = new Madera();
		Herramienta pico = new PicoFino();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}


	@Test
	public void test02t1PiedraSeGolpeaConHachaDeMaderaNoReduceDurabilidad() {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t2PiedraSeGolpeaConHachaDePiedraNoReduceDurabilidad() {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t3PiedraSeGolpeaConHachaDeMetalNoReduceDurabilidad() {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t4PiedraSeGolpeaConPicoDeMaderaReduceDurabilidadPiedra() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMadera();
		pico.usar(piedra);
		assertEquals(28,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t5raPiedraSeGolpeaConPicoDePiedraReduceDurabilidadPiedra() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDePiedra();
		pico.usar(piedra);
		assertEquals(26,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t6PiedraSeGolpeaConPicoDeMetalReduceDurabilidadPiedra() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMetal();
		pico.usar(piedra);
		assertEquals(18,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t7PiedraSeGolpeaConPicoFinoReduceDurabilidadPiedra() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoFino();
		pico.usar(piedra);
		assertEquals(10,piedra.getDurabilidad(),0.0f);
	}


	@Test
	public void test03t1MetalSeGolpeaConHachaDeMaderaNoReduceDurabilidad() {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t2MetalSeGolpeaConHachaDePiedraNoReduceDurabilidad() {
		Material metal = new Metal();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t3MetalSeGolpeaConHachaDeMetalNoReduceDurabilidad() {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t4MetalSeGolpeaConPicoDeMaderaNoReduceDurabilidad() {
		Material metal = new Metal();
		Herramienta pico = new PicoDeMadera();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t5MetalSeGolpeaConPicoDePiedraReduceDurabilidadMetal() {
		Material metal = new Metal();
		Herramienta pico = new PicoDePiedra();
		pico.usar(metal);
		assertEquals(46,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t6MetalSeGolpeaConPicoDeMetalNoReduceDurabilidad() {
		Material metal = new Metal();
		Herramienta pico = new PicoDeMetal();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t7MetalSeGolpeaConPicoFinoNoReduceDurabilidad() {
		Material metal = new Metal();
		Herramienta pico = new PicoFino();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}


	@Test
	public void test04t1DiamanteSeGolpeaConHachaDeMaderaNoReduceDurabilidad() {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t2DiamanteSeGolpeaConHachaDePiedraNoReduceDurabilidad() {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t3DiamanteSeGolpeaConHachaDeMetalNoReduceDurabilidad() {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t4DiamanteSeGolpeaConPicoDeMaderaNoReduceDurabilidad() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDeMadera();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t5DiamanteSeGolpeaConPicoDePiedraNoReduceDurabilidad() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDePiedra();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t6DiamanteSeGolpeaConPicoDeMetalNoReduceDurabilidad() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDeMetal();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t7DiamanteSeGolpeaConPicoFinoReduceDurabilidadDiamante() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoFino();
		pico.usar(diamante);
		assertEquals(80,diamante.getDurabilidad(),0.0f);
	}

}
