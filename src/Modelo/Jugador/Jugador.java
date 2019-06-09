package Modelo.Jugador;

import Modelo.Herramientas.*;
import Modelo.Posicionable.Posicionable;


public class Jugador extends Posicionable {

	private Inventario inventario;

	public Jugador() {
		inventario = new Inventario();
		inventario.agregar(new HachaDeMadera()); }

	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) {
		return inventario.tiene(unaHerramienta);
	}

}

/*

    public Herramienta craftear(String crafteo) {

        for (Map.Entry<String, Herramienta> entry : crafteos.entrySet()) {
            String craft = entry.getKey();
            Herramienta herramienta = entry.getValue();
            if (craft.equals(crafteo)) {
                return herramienta;
            }
        }
        return null;
    }
}
 */