package Modelo.Posicionable;

import Modelo.Tablero.Posicion;

public abstract class Posicionable {

	public String nombre;
	public Posicion posicion;
	public String rutaImagen;

	public String getNombre() {
		return nombre;
	}

    public Posicion getPosicion() {
        return posicion;
    }

	public void setPosicion(Posicion pos) { posicion = pos;}

}
