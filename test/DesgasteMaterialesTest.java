import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DesgasteMaterialesTest {

	@Test
	public void test01t1MaderaSeGolpeaConHachaDeMaderaReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(madera);
		assertEquals(8,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t2MaderaSeGolpeaConHachaDePiedraReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(madera);
		assertEquals(5,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t3MaderaSeGolpeaConHachaDeMetalReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(madera);
		assertEquals(0,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t4MaderaSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t5MaderaSeGolpeaConPicoDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta pico = new PicoDePiedra();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t6MaderaSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMetal();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t7MaderaSeGolpeaConPicoFinoNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta pico = new PicoFino();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}


	@Test
	public void test02t1PiedraSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t2PiedraSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t3PiedraSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t4PiedraSeGolpeaConPicoDeMaderaReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMadera();
		pico.usar(piedra);
		assertEquals(28,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t5raPiedraSeGolpeaConPicoDePiedraReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDePiedra();
		pico.usar(piedra);
		assertEquals(26,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t6PiedraSeGolpeaConPicoDeMetalReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMetal();
		pico.usar(piedra);
		assertEquals(18,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t7PiedraSeGolpeaConPicoFinoReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta pico = new PicoFino();
		pico.usar(piedra);
		assertEquals(10,piedra.getDurabilidad(),0.0f);
	}


	@Test
	public void test03t1MetalSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t2MetalSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t3MetalSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t4MetalSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta pico = new PicoDeMadera();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t5MetalSeGolpeaConPicoDePiedraReduceDurabilidadMetal() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta pico = new PicoDePiedra();
		pico.usar(metal);
		assertEquals(46,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t6MetalSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta pico = new PicoDeMetal();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t7MetalSeGolpeaConPicoFinoNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta pico = new PicoFino();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}


	@Test
	public void test04t1DiamanteSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t2DiamanteSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t3DiamanteSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t4DiamanteSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDeMadera();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t5DiamanteSeGolpeaConPicoDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDePiedra();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t6DiamanteSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDeMetal();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t7DiamanteSeGolpeaConPicoFinoReduceDurabilidadDiamante() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta pico = new PicoFino();
		pico.usar(diamante);
		assertEquals(80,diamante.getDurabilidad(),0.0f);
	}

}
