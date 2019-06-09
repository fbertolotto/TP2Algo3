package Modelo.Jugador;

import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;

import java.util.ArrayList;


public class Inventario {

	private ArrayList<Posicionable> inventario = new ArrayList();


	public void agregar(Herramienta unaHerramienta) {
		inventario.add(unaHerramienta);
	}


	public boolean tiene(Posicionable elemento) {
		for (Posicionable guardable : inventario) {
			if (elemento.getNombre() == guardable.getNombre()) {
				return true;
			}
		}
		return false;
	}
}

