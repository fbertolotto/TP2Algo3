import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DesgasteMaterialesTest {

	@Test
	public void test01t1MaderaSeGolpeaConHachaDeMaderaReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(madera);
		assertEquals(8,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t2MaderaSeGolpeaConHachaDePiedraReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(madera);
		assertEquals(5,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t3MaderaSeGolpeaConHachaDeMetalReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(madera);
		assertEquals(0,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t4MaderaSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t5MaderaSeGolpeaConPicoDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDePiedra();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t6MaderaSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMetal();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t7MaderaSeGolpeaConPicoFinoNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoFino();
		pico.usar(madera);
		assertEquals(10,madera.getDurabilidad(),0.0f);
	}


	@Test
	public void test02t1PiedraSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t2PiedraSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t3PiedraSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(piedra);
		assertEquals(30,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t4PiedraSeGolpeaConPicoDeMaderaReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDeMadera();
		pico.usar(piedra);
		assertEquals(28,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t5raPiedraSeGolpeaConPicoDePiedraReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDePiedra();
		pico.usar(piedra);
		assertEquals(26,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t6PiedraSeGolpeaConPicoDeMetalReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDeMetal();
		pico.usar(piedra);
		assertEquals(18,piedra.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t7PiedraSeGolpeaConPicoFinoReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoFino();
		pico.usar(piedra);
		assertEquals(10,piedra.getDurabilidad(),0.0f);
	}


	@Test
	public void test03t1MetalSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t2MetalSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t3MetalSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t4MetalSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoDeMadera();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t5MetalSeGolpeaConPicoDePiedraReduceDurabilidadMetal() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoDePiedra pico = new PicoDePiedra();
		pico.usar(metal);
		assertEquals(46,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t6MetalSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoDeMetal();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t7MetalSeGolpeaConPicoFinoNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoFino();
		pico.usar(metal);
		assertEquals(50,metal.getDurabilidad(),0.0f);
	}


	@Test
	public void test04t1DiamanteSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t2DiamanteSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t3DiamanteSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t4DiamanteSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDeMadera();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t5DiamanteSeGolpeaConPicoDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDePiedra();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t6DiamanteSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDeMetal();
		pico.usar(diamante);
		assertEquals(100,diamante.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t7DiamanteSeGolpeaConPicoFinoReduceDurabilidadDiamante() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoFino pico = new PicoFino();
		pico.usar(diamante);
		assertEquals(80,diamante.getDurabilidad(),0.0f);
	}

}
