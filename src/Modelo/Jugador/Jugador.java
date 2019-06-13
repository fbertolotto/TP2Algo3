package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Tablero.Posicion;
import Modelo.Posicionable.Posicionable;

import java.util.Collection;

public class Jugador extends Posicionable {

	private Inventario inventario;

	public Jugador() {
		inventario = new Inventario();
		inventario.agregar(new HachaDeMadera(),new Posicion(0,0));
		nombre = "Jugador";
		rutaImagen = "media/images/Steve.png/";

	}

	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) {
		return inventario.tiene(unaHerramienta);
	}

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}