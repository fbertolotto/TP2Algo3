package Modelo.Jugador;

import Modelo.Herramientas.*;

import java.util.ArrayList;


public class Jugador {

	protected ArrayList inventario = new ArrayList();

	public Jugador() {
		inventario.add(new HachaDeMadera());
	}

	public boolean tieneUnaHerramienta(Class ClaseDeHerramienta) {
		for ( int i = 0; i < inventario.size(); i++) {
			if (inventario.get(i).getClass().isAssignableFrom(ClaseDeHerramienta)) { return true; }
		}
		return false;
	}

}
