package MaterialesTest;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Excepciones.PicoFinoMaterialInvalidoExeption;
import Modelo.Herramientas.*;
import Modelo.Materiales.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class DesgasteMaterialesTest {

	@Test
	public void test01t1MaderaSeGolpeaConHachaDeMaderaReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMadera();
		float durabilidad = madera.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(madera);
		assertEquals(8,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test01t2MaderaSeGolpeaConHachaDePiedraReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDePiedra();
		float durabilidad = madera.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(madera);
		assertEquals(5,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test01t3MaderaSeGolpeaConHachaDeMetalReduceDurabilidadMadera() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Hacha hacha = new HachaDeMetal();
		float durabilidad = madera.getDurabilidad();
		int fuerza = hacha.getFuerza();
		hacha.usar(madera);
		assertEquals(0,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test01t4MaderaSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMadera();
		float durabilidad = madera.getDurabilidad();
		pico.usar(madera);
		assertEquals(madera.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test01t5MaderaSeGolpeaConPicoDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDePiedra();
		float durabilidad = madera.getDurabilidad();
		pico.usar(madera);
		assertEquals(madera.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test01t6MaderaSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoDeMetal();
		float durabilidad = madera.getDurabilidad();
		pico.usar(madera);
		assertEquals(madera.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test01t7MaderaSeGolpeaConPicoFinoNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Madera madera = new Madera();
		Pico pico = new PicoFino();
		float durabilidad = madera.getDurabilidad();
		try {pico.usar(madera);} catch (PicoFinoMaterialInvalidoExeption e) {}
		assertEquals(madera.getDurabilidadInicial(),durabilidad,0.0f);
	}


	@Test
	public void test02t1PiedraSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMadera();
		float durabilidad = piedra.getDurabilidad();
		hacha.usar(piedra);
		assertEquals(piedra.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test02t2PiedraSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDePiedra();
		float durabilidad = piedra.getDurabilidad();
		hacha.usar(piedra);
		assertEquals(piedra.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test02t3PiedraSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Hacha hacha = new HachaDeMetal();
		float durabilidad = piedra.getDurabilidad();
		hacha.usar(piedra);
		assertEquals(piedra.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test02t4PiedraSeGolpeaConPicoDeMaderaReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDeMadera();
		float durabilidad = piedra.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(piedra);
		assertEquals(28,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test02t5raPiedraSeGolpeaConPicoDePiedraReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDePiedra();
		float durabilidad = piedra.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(piedra);
		assertEquals(26,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test02t6PiedraSeGolpeaConPicoDeMetalReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoDeMetal();
		float durabilidad = piedra.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(piedra);
		assertEquals(18,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test02t7PiedraSeGolpeaConPicoFinoReduceDurabilidadPiedra() throws DurabilidadAgotadaException {
		Piedra piedra = new Piedra();
		Pico pico = new PicoFino();
		float durabilidad = piedra.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(piedra);
		assertEquals(10,durabilidad - fuerza,0.0f);
	}


	@Test
	public void test03t1MetalSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMadera();
		float durabilidad = metal.getDurabilidad();
		hacha.usar(metal);
		assertEquals(metal.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test03t2MetalSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDePiedra();
		float durabilidad = metal.getDurabilidad();
		hacha.usar(metal);
		assertEquals(metal.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test03t3MetalSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Hacha hacha = new HachaDeMetal();
		float durabilidad = metal.getDurabilidad();
		hacha.usar(metal);
		assertEquals(metal.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test03t4MetalSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoDeMadera();
		float durabilidad = metal.getDurabilidad();
		pico.usar(metal);
		assertEquals(metal.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test03t5MetalSeGolpeaConPicoDePiedraReduceDurabilidadMetal() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		PicoDePiedra pico = new PicoDePiedra();
		float durabilidad = metal.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(metal);
		assertEquals(46,durabilidad - fuerza,0.0f);
	}
	@Test
	public void test03t6MetalSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoDeMetal();
		float durabilidad = metal.getDurabilidad();
		pico.usar(metal);
		assertEquals(50,durabilidad,0.0f);
	}
	@Test
	public void test03t7MetalSeGolpeaConPicoFinoNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Metal metal = new Metal();
		Pico pico = new PicoFino();
		float durabilidad = metal.getDurabilidad();
		try {pico.usar(metal);} catch (PicoFinoMaterialInvalidoExeption e) {}
		assertEquals(50,durabilidad,0.0f);
	}


	@Test
	public void test04t1DiamanteSeGolpeaConHachaDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMadera();
		float durabilidad = diamante.getDurabilidad();
		hacha.usar(diamante);
		assertEquals(diamante.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test04t2DiamanteSeGolpeaConHachaDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDePiedra();
		float durabilidad = diamante.getDurabilidad();
		hacha.usar(diamante);
		assertEquals(diamante.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test04t3DiamanteSeGolpeaConHachaDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Hacha hacha = new HachaDeMetal();
		float durabilidad = diamante.getDurabilidad();
		hacha.usar(diamante);
		assertEquals(diamante.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test04t4DiamanteSeGolpeaConPicoDeMaderaNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDeMadera();
		float durabilidad = diamante.getDurabilidad();
		pico.usar(diamante);
		assertEquals(diamante.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test04t5DiamanteSeGolpeaConPicoDePiedraNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDePiedra();
		float durabilidad = diamante.getDurabilidad();
		pico.usar(diamante);
		assertEquals(diamante.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test04t6DiamanteSeGolpeaConPicoDeMetalNoReduceDurabilidad() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		Pico pico = new PicoDeMetal();
		float durabilidad = diamante.getDurabilidad();
		pico.usar(diamante);
		assertEquals(diamante.getDurabilidadInicial(),durabilidad,0.0f);
	}
	@Test
	public void test04t7DiamanteSeGolpeaConPicoFinoReduceDurabilidadDiamante() throws DurabilidadAgotadaException {
		Diamante diamante = new Diamante();
		PicoFino pico = new PicoFino();
		float durabilidad = diamante.getDurabilidad();
		int fuerza = pico.getFuerza();
		pico.usar(diamante);
		assertEquals(80,durabilidad - fuerza,0.0f);
	}

}
