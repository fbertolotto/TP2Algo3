package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Mapa.Posicion;
import Modelo.Posicionable.Posicionable;

public class Jugador extends Posicionable {

	private Inventario inventario;

	public Jugador() {
		inventario = new Inventario();
		inventario.agregar(new HachaDeMadera());
		nombre = "Jugador";
		posicion = new Posicion(10, 10);
		rutaImagen = "images/Steve.png/";

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
}