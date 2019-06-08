import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import Modelo.Desgastador.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsoHerramientasTest {

	@Test
	public void test01t1UsarHachaDeMaderaContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMadera();
		new Desgastador().desgastar(hacha,madera);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t2UsarHachaDeMaderaContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMadera();
		new Desgastador().desgastar(hacha,piedra);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t3UsarHachaDeMaderaContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMadera();
		new Desgastador().desgastar(hacha,metal);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t4UsarHachaDeMaderaContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMadera();
		new Desgastador().desgastar(hacha,diamante);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test02t1UsarHachaDePiedraContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDePiedra();
		new Desgastador().desgastar(hacha,madera);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t2UsarHachaDePiedraContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDePiedra();
		new Desgastador().desgastar(hacha,piedra);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t3UsarHachaDePiedraContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDePiedra();
		new Desgastador().desgastar(hacha,metal);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t4UsarHachaDePiedraContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDePiedra();
		new Desgastador().desgastar(hacha,diamante);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test03t1UsarHachaDeMetalContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMetal();
		new Desgastador().desgastar(hacha,madera);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t2UsarHachaDeMetalContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMetal();
		new Desgastador().desgastar(hacha,piedra);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t3UsarHachaDeMetalContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMetal();
		new Desgastador().desgastar(hacha,metal);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t4UsarHachaDeMetalContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMetal();
		new Desgastador().desgastar(hacha,diamante);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test04t1UsarPicoDeMaderaContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMadera();
		new Desgastador().desgastar(pico,madera);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t2UsarPicoDeMaderaContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDeMadera();
		new Desgastador().desgastar(pico,piedra);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t3UsarPicoDeMaderaContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMadera();
		new Desgastador().desgastar(pico,madera);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t4UsarPicoDeMaderaContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDeMadera();
		new Desgastador().desgastar(pico,diamante);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}


	@Test
	public void test05t1UsarPicoDePiedraContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDePiedra();
		new Desgastador().desgastar(pico,madera);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t2UsarPicoDePiedraContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDePiedra();
		new Desgastador().desgastar(pico,piedra);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t3UsarPicoDePiedraContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoDePiedra pico = new PicoDePiedra();
		new Desgastador().desgastar(pico,metal);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t4UsarPicoDePiedraContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoDePiedra pico = new PicoDePiedra();
		new Desgastador().desgastar(pico,diamante);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}


	@Test
	public void test06t1UsarPicoDeMetalContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMetal();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 10; i++) { desgastador.desgastar(pico,madera);; } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t2UsarPicoDeMetalContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDeMetal();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 10; i++) { desgastador.desgastar(pico,piedra); } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t3UsarPicoDeMetalContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoDeMetal();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 10; i++) { desgastador.desgastar(pico,metal); } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t4UsarPicoDeMetalContraDiamanteAgotaDurabilidadAlDecimoGolpe() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDeMetal();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 10; i++) { desgastador.desgastar(pico,diamante); } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}


	@Test
	public void test07t1UsarPicoFinoContraMaderaNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoFino pico = new PicoFino();
		new Desgastador().desgastar(pico,madera);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test07t2UsarPicoFinoContraPiedraNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		PicoFino pico = new PicoFino();
		new Desgastador().desgastar(pico,piedra);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test07t3UsarPicoFinoContraMetalNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoFino pico = new PicoFino();
		new Desgastador().desgastar(pico,metal);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test07t4UsarPicoFinoContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoFino pico = new PicoFino();
		new Desgastador().desgastar(pico,diamante);
		assertEquals(900,pico.getDurabilidad(),0.0f);
	}
}
