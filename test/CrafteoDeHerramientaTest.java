import Modelo.Jugador.MesaDeCrafteo;
import Modelo.Mapa.Posicion;
import Modelo.Materiales.Madera;
import org.junit.Test;

import Modelo.Herramientas.*;
import static org.junit.Assert.*;

public class CrafteoDeHerramientaTest {

	@Test
	public void test01CraftearHachaDeMadera() {
        MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicionaux = new Posicion(0,0);
        mesa.colocarElementoEnPosicion(new Madera(), posicionaux);
        Posicion posicionaux1 = new Posicion(0,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicionaux1);
        Posicion posicionaux2 = new Posicion(1,0);
        mesa.colocarElementoEnPosicion(new Madera(), posicionaux2);
        Posicion posicionaux3 = new Posicion(1,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicionaux3);
        Posicion posicionaux4 = new Posicion(2,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicionaux4);
		Herramienta hachaDeMadera = mesa.craftear();
		assertEquals(hachaDeMadera.getNombre(), "Hacha de Madera");
	}
}
/*
	@Test
	public void test02CraftearHachaDePiedra() {
		String matrizDeCrafteo = "P-P- -P-MA- -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta hachaDePiedra = mesa.craftear(matrizDeCrafteo);
		assertEquals(hachaDePiedra.getNombre(), "Hacha de Piedra");
	}

	@Test
	public void test03CraftearHachaDeMetal() {
		String matrizDeCrafteo = "ME-ME- -ME-MA- -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta hachaDeMetal = mesa.craftear(matrizDeCrafteo);
		assertEquals(hachaDeMetal.getNombre(), "Hacha de Metal");
	}

	@Test
	public void test04CraftearPicoDeMadera() {
		String matrizDeCrafteo = "MA-MA-MA- -MA- - -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta picoDeMadera = mesa.craftear(matrizDeCrafteo);
		assertEquals(picoDeMadera.getNombre(), "Pico de Madera");
	}

	@Test
	public void test05CraftearPicoDePiedra() {
		String matrizDeCrafteo = "P-P-P- -MA- - -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta picoDePiedra = mesa.craftear(matrizDeCrafteo);
		assertEquals(picoDePiedra.getNombre(), "Pico de Piedra");
	}

	@Test
	public void test06CraftearPicoDeMetal() {
		String matrizDeCrafteo = "ME-ME-ME- -MA- - -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta picoDeMetal = mesa.craftear(matrizDeCrafteo);
		assertEquals(picoDeMetal.getNombre(), "Pico de Metal");
	}

	@Test
	public void test07CraftearPicoFino() {
		String matrizDeCrafteo = "ME-ME-ME-P-MA- - -MA- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta picoFino = mesa.craftear(matrizDeCrafteo);
		assertEquals(picoFino.getNombre(), "Pico Fino");
	}

	@Test
	public void test08CraftearHachaDeMaderaConMatrizIncorrectaDevuelveNull() {
		String matrizIncorrecta = "MA-ME- -MA-MA- -ME- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta hachaDeMadera = mesa.craftear(matrizIncorrecta);
		assertNull(hachaDeMadera);
	}

	@Test
	public void test09CraftearPicoDePiedraConMatrizIncorrectaDevuelveNull() {
		String matrizIncorrecta = "MA-ME- -MA-MA- -ME- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta picoDePiedra = mesa.craftear(matrizIncorrecta);
		assertNull(picoDePiedra);
	}

	@Test
	public void test10CraftearPicoFinoConMatrizIncorrectaDevuelveNull() {
		String matrizIncorrecta = "MA-ME- -MA-MA- -ME- ";
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Herramienta picoFino = mesa.craftear(matrizIncorrecta);
		assertNull(picoFino);
	}

}
*/