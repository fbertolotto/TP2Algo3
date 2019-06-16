package CrafteoTest;

import Modelo.Juego.MesaDeCrafteo;
import Modelo.Tablero.Posicion;
import Modelo.Materiales.*;
import org.junit.Test;

import Modelo.Herramientas.*;
import static org.junit.Assert.*;

public class CrafteoDeHerramientaTest {

	//El numero de posicion hace referencia a la posicion en la mesa de crafteo siendo (0,0) la 1, (0,1) la 2, etc.

	@Test
	public void test01CraftearHachaDeMaderaDevuelveHachaDeMadera() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta hachaDeMadera = mesa.craftear();
		assertEquals("Hacha de Madera", hachaDeMadera.getNombre());
	}


	@Test
	public void test02CraftearHachaDePiedraDevuelveHachaDePiedra() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta hachaDePiedra = mesa.craftear();
		assertEquals("Hacha de Piedra", hachaDePiedra.getNombre());
	}

	@Test
	public void test03CraftearHachaDeMetalDevuelveHachaDeMetal() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Metal(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta hachaDeMetal = mesa.craftear();
		assertEquals("Hacha de Metal", hachaDeMetal.getNombre());
	}

	@Test
	public void test04CraftearPicoDeMaderaDevuelvePicoDeMadera() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion1 = new Posicion(0,0);
        mesa.colocarElementoEnPosicion(new Madera(), posicion1);
        Posicion posicion2 = new Posicion(1,0);
        mesa.colocarElementoEnPosicion(new Madera(), posicion2);
        Posicion posicion3 = new Posicion(2,0);
        mesa.colocarElementoEnPosicion(new Madera(), posicion3);
        Posicion posicion5 = new Posicion(1,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicion5);
        Posicion posicion8 = new Posicion(1,2);
        mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta picoDeMadera = mesa.craftear();
		assertEquals("Pico de Madera",picoDeMadera.getNombre());
	}

	@Test
	public void test05CraftearPicoDePiedraDevuelvePicoDePiedra() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion1 = new Posicion(0,0);
        mesa.colocarElementoEnPosicion(new Piedra(), posicion1);
        Posicion posicion2 = new Posicion(1,0);
        mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
        Posicion posicion3 = new Posicion(2,0);
        mesa.colocarElementoEnPosicion(new Piedra(), posicion3);
        Posicion posicion5 = new Posicion(1,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicion5);
        Posicion posicion8 = new Posicion(1,2);
        mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta picoDePiedra = mesa.craftear();
		assertEquals("Pico de Piedra",picoDePiedra.getNombre());
	}

	@Test
	public void test06CraftearPicoDeMetalDevuelvePicoDeMetal() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion1 = new Posicion(0,0);
        mesa.colocarElementoEnPosicion(new Metal(), posicion1);
        Posicion posicion2 = new Posicion(1,0);
        mesa.colocarElementoEnPosicion(new Metal(), posicion2);
        Posicion posicion3 = new Posicion(2,0);
        mesa.colocarElementoEnPosicion(new Metal(), posicion3);
        Posicion posicion5 = new Posicion(1,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicion5);
        Posicion posicion8 = new Posicion(1,2);
        mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta picoDeMetal = mesa.craftear();
		assertEquals("Pico de Metal",picoDeMetal.getNombre());
	}

	@Test
	public void test07CraftearPicoFinoDevuelvePicoFino() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
        Posicion posicion1 = new Posicion(0,0);
        mesa.colocarElementoEnPosicion(new Metal(), posicion1);
        Posicion posicion2 = new Posicion(1,0);
        mesa.colocarElementoEnPosicion(new Metal(), posicion2);
        Posicion posicion3 = new Posicion(2,0);
        mesa.colocarElementoEnPosicion(new Metal(), posicion3);
        Posicion posicion4 = new Posicion(0,1);
        mesa.colocarElementoEnPosicion(new Piedra(), posicion4);
        Posicion posicion5 = new Posicion(1,1);
        mesa.colocarElementoEnPosicion(new Madera(), posicion5);
        Posicion posicion8 = new Posicion(1,2);
        mesa.colocarElementoEnPosicion(new Madera(), posicion8);
		Herramienta picoFino = mesa.craftear();
		assertEquals("Pico Fino",picoFino.getNombre());
	}

	@Test
	public void test08CraftearHachaDeMaderaConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta hachaDeMadera = mesa.craftear();
		assertNull(hachaDeMadera);
	}

	@Test
	public void test09CraftearHachaDePiedraConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta hachaDePiedra = mesa.craftear();
		assertNull(hachaDePiedra);
	}

	@Test
	public void test10CraftearHachaDeMetalConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion2);
		Posicion posicion4 = new Posicion(0,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion4);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta hachaDeMetal = mesa.craftear();
		assertNull(hachaDeMetal);
	}

	@Test
	public void test11CraftearPicoDeMaderaConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
		Posicion posicion3 = new Posicion(2,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion3);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta picoDeMadera = mesa.craftear();
		assertNull(picoDeMadera);
	}

	@Test
	public void test12CraftearPicoDePiedraConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
		Posicion posicion3 = new Posicion(2,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion3);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta picoDePiedra = mesa.craftear();
		assertNull(picoDePiedra);
	}

	@Test
	public void test13CraftearPicoDeMetalConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
		Posicion posicion3 = new Posicion(2,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion3);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta picoDeMetal = mesa.craftear();
		assertNull(picoDeMetal);
	}

	@Test
	public void test14CraftearPicoFinoConElementosIncorrectosEnPosicionesCorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(1,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
		Posicion posicion3 = new Posicion(2,0);
		mesa.colocarElementoEnPosicion(new Metal(), posicion3);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(1,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta picoFino = mesa.craftear();
		assertNull(picoFino);
	}

	@Test
	public void test15CraftearHerramientaConElementosIncorrectosEnPosicionesIncorrectasDevuelveNull() {
		MesaDeCrafteo mesa = new MesaDeCrafteo();
		Posicion posicion1 = new Posicion(0,0);
		mesa.colocarElementoEnPosicion(new Madera(), posicion1);
		Posicion posicion2 = new Posicion(2,0);
		mesa.colocarElementoEnPosicion(new Piedra(), posicion2);
		Posicion posicion3 = new Posicion(2,1);
		mesa.colocarElementoEnPosicion(new Metal(), posicion3);
		Posicion posicion5 = new Posicion(1,1);
		mesa.colocarElementoEnPosicion(new Madera(), posicion5);
		Posicion posicion8 = new Posicion(0,2);
		mesa.colocarElementoEnPosicion(new Diamante(), posicion8);
		Herramienta picoDeMetal = mesa.craftear();
		assertNull(picoDeMetal);
	}




}
