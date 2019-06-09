package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Interfaces.Guardable;


public class Jugador {

	private Inventario inventario;

	public Jugador() {
		inventario = new Inventario();
		inventario.agregar(new HachaDeMadera()); }

	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) {
		return inventario.tiene(unaHerramienta);
	}

}