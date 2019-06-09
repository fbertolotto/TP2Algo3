package Modelo.Jugador;

import Modelo.Herramientas.Herramienta;
import Modelo.Interfaces.Guardable;
import java.util.ArrayList;


public class Inventario {

	private ArrayList<Guardable> inventario = new ArrayList();


	public void agregar(Herramienta unaHerramienta) {
		inventario.add(unaHerramienta);
	}


	public boolean tiene(Guardable elemento) {
		for (Guardable guardable : inventario) {
			if (elemento.getNombre() == guardable.getNombre()) {
				return true;
			}
		}
		return false;
	}
}

