package Modelo.Excepciones;

public class PosicionFueraDeRangoException extends RuntimeException {
	public PosicionFueraDeRangoException() {
		super("No podes salir del mapa");
	}
}
