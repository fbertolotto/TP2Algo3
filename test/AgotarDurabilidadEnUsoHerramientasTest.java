import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class AgotarDurabilidadEnUsoHerramientasTest {

		@Test
		public void test01AgotarDurabilidadHachaDeMaderaLanzaExcepcion() throws DurabilidadAgotadaException {
			Piedra piedra = new Piedra();
			Hacha hacha = new HachaDeMadera();
			for(int i = 0; i < 50; i++) { hacha.usar(piedra); }

			boolean lanzoError = false;
			try { hacha.usar(piedra); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
			assertTrue(lanzoError);

		}

		@Test
		public void test02AgotarDurabilidadHachaDePiedraLanzaExcepcion() throws DurabilidadAgotadaException {
			Piedra piedra = new Piedra();
			Hacha hacha = new HachaDePiedra();
			for(int i = 0; i < 40; i++) { hacha.usar(piedra); }

			boolean lanzoError = false;
			try { hacha.usar(piedra); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
			assertTrue(lanzoError);
		}

		@Test
		public void test03AgotarDurabilidadHachaDeMetalLanzaExcepcion() throws DurabilidadAgotadaException {
			Piedra piedra = new Piedra();
			Hacha hacha = new HachaDeMetal();
			for(int i = 0; i < 80; i++) { hacha.usar(piedra); }

			boolean lanzoError = false;
			try { hacha.usar(piedra); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
			assertTrue(lanzoError);
		}

		@Test
		public void test04AgotarDurabilidadPicoDeMaderaLanzaExcepcion() throws DurabilidadAgotadaException {
			Madera madera = new Madera();
			PicoDeMadera pico = new PicoDeMadera();
			for(int i = 0; i < 50; i++) { pico.usar(madera); }

			boolean lanzoError = false;
			try { pico.usar(madera); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
			assertTrue(lanzoError);
		}

		@Test
		public void test05AgotarDurabilidadPicoDePiedraLanzaExcepcion() throws DurabilidadAgotadaException {
			Madera madera = new Madera();
			PicoDePiedra pico = new PicoDePiedra();
			for(int i = 0; i < 75; i++) { pico.usar(madera); }

			boolean lanzoError = false;
			try { pico.usar(madera); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
			assertTrue(lanzoError);
		}

		@Test
		public void test06AgotarDurabilidadPicoDeMetalLanzaExcepcion() throws DurabilidadAgotadaException {
			Madera madera = new Madera();
			PicoDeMetal pico = new PicoDeMetal();
			for(int i = 0; i < 10; i++) { pico.usar(madera); } //Al decimo golpe se rompe.

			boolean lanzoError = false;
			try { pico.usar(madera); } catch (DurabilidadAgotadaException e) { lanzoError = true; }
			assertTrue(lanzoError);
		}




}
