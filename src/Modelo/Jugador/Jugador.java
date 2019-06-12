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

	public void moverEnVertical(int y) {
		posicion.moverEnVertical(y);
	}

	public void moverEnHorizontal(int x) {
		posicion.moverEnHorizontal(x);
	}

	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}