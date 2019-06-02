import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestUsoHerramientas {
	//Los que tienen los assert comentados son los que se reducen ambas
	@Test
	public void test01t1UsarHachaDeMaderaContraMaderaReduceDurabilidadHacha() {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(madera);
		//assertEquals(8,madera.getDurabilidad());
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t2UsarHachaDeMaderaContraPiedraReduceDurabilidadHacha() {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(piedra);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t3UsarHachaDeMaderaContraMetalReduceDurabilidadHacha() {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(metal);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test01t4UsarHachaDeMaderaContraDiamanteReduceDurabilidadHacha() {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMadera();
		hacha.usar(diamante);
		assertEquals(98,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test02t1UsarHachaDePiedraContraMaderaReduceDurabilidadHacha() {
		Material madera = new Madera();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(madera);
		//assertEquals(8,madera.getDurabilidad());
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t2UsarHachaDePiedraContraPiedraReduceDurabilidadHacha() {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(piedra);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t3UsarHachaDePiedraContraMetalReduceDurabilidadHacha() {
		Material metal = new Metal();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(metal);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test02t4UsarHachaDePiedraContraDiamanteReduceDurabilidadHacha() {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDePiedra();
		hacha.usar(diamante);
		assertEquals(195,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test03t1UsarHachaDeMetalContraMaderaReduceDurabilidadHacha() {
		Material madera = new Madera();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(madera);
		//assertEquals(30,madera.getDurabilidad());
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t2UsarHachaDeMetalContraPiedraReduceDurabilidadHacha() {
		Material piedra = new Piedra();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(piedra);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t3UsarHachaDeMetalContraMetalReduceDurabilidadHacha() {
		Material metal = new Metal();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(metal);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}
	@Test
	public void test03t4UsarHachaDeMetalContraDiamanteReduceDurabilidadHacha() {
		Material diamante = new Diamante();
		Herramienta hacha = new HachaDeMetal();
		hacha.usar(diamante);
		assertEquals(395,hacha.getDurabilidad(),0.0f);
	}


	@Test
	public void test04t1UsarPicoDeMaderaContraMaderaReduceDurabilidadPico() {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t2UsarPicoDeMaderaContraPiedraReduceDurabilidadPico() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMadera();
		pico.usar(piedra);
		//assertEquals(28,piedra.getDurabilidad());
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t3UsarPicoDeMaderaContraMetalReduceDurabilidadPico() {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMadera();
		pico.usar(madera);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test04t4UsarPicoDeMaderaContraDiamanteReduceDurabilidadPico() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDeMadera();
		pico.usar(diamante);
		assertEquals(98,pico.getDurabilidad(),0.0f);
	}


	@Test
	public void test05t1UsarPicoDePiedraContraMaderaReduceDurabilidadPico() {
		Material madera = new Madera();
		Herramienta pico = new PicoDePiedra();
		pico.usar(madera);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t2UsarPicoDePiedraContraPiedraReduceDurabilidadPico() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDePiedra();
		pico.usar(piedra);
		//Tambien reduce en el materal (pico cualquiera vs piedra)
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t3UsarPicoDePiedraContraMetalReduceDurabilidadPico() {
		Material metal = new Metal();
		Herramienta pico = new PicoDePiedra();
		pico.usar(metal);
		//Tambien reduce en el material (pico de piedra vs metal)
		//assertEquals(46,metal.getDurabilidad());
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}
	@Test
	public void test05t4UsarPicoDePiedraContraDiamanteReduceDurabilidadPico() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDePiedra();
		pico.usar(diamante);
		assertEquals(197.3,pico.getDurabilidad(),0.04f);
	}


	@Test
	public void test06t1UsarPicoDeMetalContraMaderaReduceDurabilidadPico() {
		Material madera = new Madera();
		Herramienta pico = new PicoDeMetal();
		for(int i = 0; i < 10; i++) { pico.usar(madera); } //Al decimo golpe se rompe. Durabilidad == 0
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t2UsarPicoDeMetalContraPiedraReduceDurabilidadPico() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoDeMetal();
		//Tambien reduce en el materal (pico cualquiera vs piedra)
		for(int i = 0; i < 10; i++) { pico.usar(piedra); } //Al decimo golpe se rompe. Durabilidad == 0
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t3UsarPicoDeMetalContraMetalReduceDurabilidadPico() {
		Material metal = new Metal();
		Herramienta pico = new PicoDeMetal();
		for(int i = 0; i < 10; i++) { pico.usar(metal); } //Al decimo golpe se rompe. Durabilidad == 0
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}
	@Test
	public void test06t4UsarPicoDeMetalContraDiamanteReduceDurabilidadPico() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoDeMetal();
		for(int i = 0; i < 10; i++) { pico.usar(diamante); } //Al decimo golpe se rompe. Durabilidad == 0
		assertEquals(0,pico.getDurabilidad(),0.0f);
	}


	@Test
	public void test07t1UsarPicoFinoContraMaderaNOSeReduceSuDurabilidad() {
		Material madera = new Madera();
		Herramienta pico = new PicoFino();
		pico.usar(madera);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
		//EL VALOR DEBE QUEDAR IGUAL, EN 1000. HAY QUE FIXEAR LA HERRAMIENTA.
	}
	@Test
	public void test07t2UsarPicoFinoContraPiedraNOSeReduceSuDurabilidad() {
		Material piedra = new Piedra();
		Herramienta pico = new PicoFino();
		pico.usar(piedra);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
		//EL VALOR DEBE QUEDAR IGUAL, EN 1000. HAY QUE FIXEAR LA HERRAMIENTA.
	}
	@Test
	public void test07t3UsarPicoFinoContraMetalNOSeReduceSuDurabilidad() {
		Material metal = new Metal();
		Herramienta pico = new PicoFino();
		pico.usar(metal);
		assertEquals(1000,pico.getDurabilidad(),0.0f);
		//EL VALOR DEBE QUEDAR IGUAL, EN 1000. HAY QUE FIXEAR LA HERRAMIENTA.
	}
	@Test
	public void test07t4UsarPicoFinoContraDiamanteReduceDurabilidadPico() {
		Material diamante = new Diamante();
		Herramienta pico = new PicoFino();
		pico.usar(diamante);
		//Tambien reduce en el material (picofino vs diamante)
		assertEquals(900,pico.getDurabilidad(),0.0f);
	}
}
