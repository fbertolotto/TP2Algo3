import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import Modelo.Desgastador.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class AgotarDurabilidadEnUsoHerramientasTest {

	@Test
	public void test01AgotarDurabilidadHachaDeMaderaLanzaExcepcion() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		HachaDeMadera hacha = new HachaDeMadera();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 50; i++) { desgastador.desgastar(hacha,piedra); }

		boolean lanzoError = false;
		try { desgastador.desgastar(hacha,piedra); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
		assertTrue(lanzoError);

	}

	@Test
	public void test02AgotarDurabilidadHachaDePiedraLanzaExcepcion() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		HachaDePiedra hacha = new HachaDePiedra();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 40; i++) { desgastador.desgastar(hacha,piedra); }

		boolean lanzoError = false;
		try { desgastador.desgastar(hacha,piedra); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test03AgotarDurabilidadHachaDeMetalLanzaExcepcion() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		HachaDeMetal hacha = new HachaDeMetal();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 80; i++) { desgastador.desgastar(hacha,piedra); }

		boolean lanzoError = false;
		try { desgastador.desgastar(hacha,piedra); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test04AgotarDurabilidadPicoDeMaderaLanzaExcepcion() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMadera pico = new PicoDeMadera();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 50; i++) { desgastador.desgastar(pico,madera); }

		boolean lanzoError = false;
		try { desgastador.desgastar(pico,madera); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test05AgotarDurabilidadPicoDePiedraLanzaExcepcion() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDePiedra pico = new PicoDePiedra();
		Desgastador desgastador = new Desgastador();
		for(int i = 0; i < 75; i++) { desgastador.desgastar(pico,madera); }

		boolean lanzoError = false;
		try { desgastador.desgastar(pico,madera); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
		assertTrue(lanzoError);
	}

	@Test
	public void test06AgotarDurabilidadPicoDeMetalLanzaExcepcion() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		PicoDeMetal pico = new PicoDeMetal();
		Desgastador desgastador = new Desgastador();
		for (int i = 0; i < 10; i++) {
			desgastador.desgastar(pico, madera);
		} //Al decimo golpe se rompe.

		boolean lanzoError = false;
		try {
			desgastador.desgastar(pico, madera);
		} catch (DurabilidadAgotadaException e) {
			lanzoError = true;
		}
		assertTrue(lanzoError);
	}
}
