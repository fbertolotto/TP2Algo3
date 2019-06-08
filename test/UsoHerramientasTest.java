import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsoHerramientasTest {

	@Test
	public void test01t1UsarHachaDeMaderaContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(madera);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t2UsarHachaDeMaderaContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(piedra);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t3UsarHachaDeMaderaContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(metal);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t4UsarHachaDeMaderaContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMadera();
		hacha.usar(diamante);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test02t1UsarHachaDePiedraContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(madera);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t2UsarHachaDePiedraContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(piedra);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t3UsarHachaDePiedraContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(metal);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t4UsarHachaDePiedraContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDePiedra();
		hacha.usar(diamante);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test03t1UsarHachaDeMetalContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(madera);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t2UsarHachaDeMetalContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(piedra);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t3UsarHachaDeMetalContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(metal);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t4UsarHachaDeMetalContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMetal();
		hacha.usar(diamante);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test04t1UsarPicoDeMaderaContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMadera pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t2UsarPicoDeMaderaContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		PicoDeMadera pico = new PicoDeMadera();
		pico.usar(piedra);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t3UsarPicoDeMaderaContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMadera pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t4UsarPicoDeMaderaContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoDeMadera pico = new PicoDeMadera();
		pico.usar(diamante);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}


	@Test
	public void test05t1UsarPicoDePiedraContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDePiedra pico = new PicoDePiedra();
		pico.usar(madera);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t2UsarPicoDePiedraContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		PicoDePiedra pico = new PicoDePiedra();
		pico.usar(piedra);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t3UsarPicoDePiedraContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoDePiedra pico = new PicoDePiedra();
		pico.usar(metal);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t4UsarPicoDePiedraContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoDePiedra pico = new PicoDePiedra();
		pico.usar(diamante);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}


	@Test
	public void test06t1UsarPicoDeMetalContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMetal pico = new PicoDeMetal();
		for(int i = 0; i < 10; i++) { pico.usar(madera); } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t2UsarPicoDeMetalContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Piedra piedra2 = new Piedra();
		Piedra piedra3 = new Piedra();
		Piedra piedra4 = new Piedra();
		PicoDeMetal pico = new PicoDeMetal();
		for(int i = 0; i < 3; i++) { pico.usar(piedra); }
		for(int i = 0; i < 3; i++) { pico.usar(piedra2); }
		for(int i = 0; i < 3; i++) { pico.usar(piedra3); }
		pico.usar(piedra4); //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t3UsarPicoDeMetalContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoDeMetal pico = new PicoDeMetal();
		for(int i = 0; i < 10; i++) { pico.usar(metal); } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t4UsarPicoDeMetalContraDiamanteAgotaDurabilidadAlDecimoGolpe() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoDeMetal pico = new PicoDeMetal();
		for(int i = 0; i < 10; i++) { pico.usar(diamante); } //Al decimo golpe se rompe.
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}


	@Test
	public void test07t1UsarPicoFinoContraMaderaNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoFino pico = new PicoFino();
		pico.usar(madera);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test07t2UsarPicoFinoContraPiedraNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		PicoFino pico = new PicoFino();
		pico.usar(piedra);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test07t3UsarPicoFinoContraMetalNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoFino pico = new PicoFino();
		pico.usar(metal);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test07t4UsarPicoFinoContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoFino pico = new PicoFino();
		pico.usar(diamante);
		assertEquals(900,pico.getDurabilidad(),0.0f);
	}
}
