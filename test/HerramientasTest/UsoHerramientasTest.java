package HerramientasTest;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsoHerramientasTest {

	@Test
	public void test01t1UsarHachaDeMaderaContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMadera();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(madera);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test01t2UsarHachaDeMaderaContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMadera();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(piedra);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test01t3UsarHachaDeMaderaContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMadera();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(metal);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test01t4UsarHachaDeMaderaContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMadera();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(diamante);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}


	@Test
	public void test02t1UsarHachaDePiedraContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Herramienta hacha = new HachaDePiedra();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(madera);
		assertEquals(195,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test02t2UsarHachaDePiedraContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDePiedra();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(piedra);
		assertEquals(195,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test02t3UsarHachaDePiedraContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta hacha = new HachaDePiedra();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(metal);
		assertEquals(195,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test02t4UsarHachaDePiedraContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDePiedra();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(diamante);
		assertEquals(195,durabilidad - fuerza,0.0f);
	}


	@Test
	public void test03t1UsarHachaDeMetalContraMaderaReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Herramienta hacha = new HachaDeMetal();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(madera);
		assertEquals(395,durabilidad - (fuerza / 2),0.0f);
	}
	@Test
	public void test03t2UsarHachaDeMetalContraPiedraReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMetal();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(piedra);
		assertEquals(395,durabilidad - (fuerza / 2),0.0f);
	}
	@Test
	public void test03t3UsarHachaDeMetalContraMetalReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMetal();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(metal);
		assertEquals(395,durabilidad - (fuerza / 2),0.0f);
	}
	@Test
	public void test03t4UsarHachaDeMetalContraDiamanteReduceDurabilidadHacha() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMetal();
		float durabilidad = hacha.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(diamante);
		assertEquals(395,durabilidad - (fuerza / 2),0.0f);
	}


	@Test
	public void test04t1UsarPicoDeMaderaContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMadera pico = new PicoDeMadera();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(madera);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test04t2UsarPicoDeMaderaContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		PicoDeMadera pico = new PicoDeMadera();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(piedra);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test04t3UsarPicoDeMaderaContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMadera pico = new PicoDeMadera();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(madera);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test04t4UsarPicoDeMaderaContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		PicoDeMadera pico = new PicoDeMadera();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(diamante);
		assertEquals(98,durabilidad - fuerza,0.0f);
	}


	@Test
	public void test05t1UsarPicoDePiedraContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Herramienta pico = new PicoDePiedra();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(madera);
		assertEquals(197.3,durabilidad - (fuerza / 1.5),0.04f);
	}
	@Test
	public void test05t2UsarPicoDePiedraContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDePiedra();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(piedra);
		assertEquals(197.3,durabilidad - (fuerza / 1.5),0.04f);
	}
	@Test
	public void test05t3UsarPicoDePiedraContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta pico = new PicoDePiedra();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(metal);
		assertEquals(197.3,durabilidad - (fuerza / 1.5),0.04f);
	}
	@Test
	public void test05t4UsarPicoDePiedraContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDePiedra();
		float durabilidad = pico.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(diamante);
		assertEquals(197.3,durabilidad - (fuerza / 1.5),0.04f);
	}


	@Test
	public void test06t1UsarPicoDeMetalContraMaderaReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMetal pico = new PicoDeMetal();
		float durabilidad = pico.getDurabilidad();
		for(int i = 0; i < 10; i++) { pico.usar(madera); } //Al decimo golpe se rompe.
		assertEquals(0,durabilidad - durabilidad,0.0f);
	}
	@Test
	public void test06t2UsarPicoDeMetalContraPiedraReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Material piedra2 = new Piedra();
		Material piedra3 = new Piedra();
		Material piedra4 = new Piedra();
		Herramienta pico = new PicoDeMetal();
		float durabilidad = pico.getDurabilidad();
		for(int i = 0; i < 3; i++) { pico.usar(piedra); }
		for(int i = 0; i < 3; i++) { pico.usar(piedra2); }
		for(int i = 0; i < 3; i++) { pico.usar(piedra3); }
		pico.usar(piedra4); //Al decimo golpe se rompe.
		assertEquals(0,durabilidad - durabilidad,0.0f);
	}
	@Test
	public void test06t3UsarPicoDeMetalContraMetalReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		PicoDeMetal pico = new PicoDeMetal();
		float durabilidad = pico.getDurabilidad();
		for(int i = 0; i < 10; i++) { pico.usar(metal); } //Al decimo golpe se rompe.
		assertEquals(0,durabilidad - durabilidad,0.0f);
	}
	@Test
	public void test06t4UsarPicoDeMetalContraDiamanteAgotaDurabilidadAlDecimoGolpe() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		PicoDeMetal pico = new PicoDeMetal();
		float durabilidad = pico.getDurabilidad();
		for(int i = 0; i < 10; i++) { pico.usar(diamante); } //Al decimo golpe se rompe.
		assertEquals(0,durabilidad - durabilidad,0.0f);
	}


	@Test
	public void test07t1UsarPicoFinoContraMaderaNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Herramienta pico = new PicoFino();
		float durabilidad = pico.getDurabilidad();
		pico.usar(madera);
		assertEquals(1000,durabilidad,0.0f);
	}
	@Test
	public void test07t2UsarPicoFinoContraPiedraNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Material piedra = new Piedra();
		Herramienta pico = new PicoFino();
		float durabilidad = pico.getDurabilidad();
		pico.usar(piedra);
		assertEquals(1000,durabilidad,0.0f);
	}
	@Test
	public void test07t3UsarPicoFinoContraMetalNOSeReduceSuDurabilidad() throws DurabilidadAgotadaException {
		Material metal = new Metal();
		Herramienta pico = new PicoFino();
		float durabilidad = pico.getDurabilidad();
		pico.usar(metal);
		assertEquals(1000,durabilidad,0.0f);
	}
	@Test
	public void test07t4UsarPicoFinoContraDiamanteReduceDurabilidadPico() throws DurabilidadAgotadaException {
		Material diamante = new Diamante();
		Herramienta pico = new PicoFino();
		float durabilidad = pico.getDurabilidad();
		pico.usar(diamante);
		assertEquals(900,durabilidad - (durabilidad * 0.1),0.0f);
	}
}
