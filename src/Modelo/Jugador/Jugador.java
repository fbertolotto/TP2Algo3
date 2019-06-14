package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;

import java.util.Collection;

public class Jugador extends Posicionable {

	private Inventario inventario;

	public Jugador() {
		inventario = new Inventario();
		inventario.agregar(new HachaDeMadera());
		nombre = "Jugador";
		rutaImagen = "media/images/Steve.png/";

	}

	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) {
		return inventario.tiene(unaHerramienta);
	}

	public void agregarEnInventario(Posicionable posicionable) { inventario.agregar(posicionable); }

	public void agregarEnInventarioEnPosicion(Posicionable posicionable, Posicion posicion) { inventario.agregarEnPosicion(posicionable,posicion); }

	public void removerEnInventario(Posicionable posicionable) { inventario.remover(posicionable); }

	public Inventario getInventario() { return this.inventario;}

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}