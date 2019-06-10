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
		posicion = new Posicion(0, 0);

	}
	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) {
		return inventario.tiene(unaHerramienta);
	}

}