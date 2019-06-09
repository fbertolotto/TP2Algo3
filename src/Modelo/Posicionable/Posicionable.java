package Modelo.Posicionable;

import Modelo.Mapa.Posicion;

public abstract class Posicionable {

	public String nombre;

	public String getNombre() {
		return nombre;
	}

    public Posicion getPosicion() {
        return posicion;
    }

    public Posicion posicion;

}
