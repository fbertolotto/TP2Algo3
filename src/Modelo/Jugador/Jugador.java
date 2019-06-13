package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Posicionable.Posicionable;

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

	public void removerEnInventario(Posicionable posicionable) { inventario.remover(posicionable); }


	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}