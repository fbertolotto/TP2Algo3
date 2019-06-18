package Modelo.Excepciones;

public class PosicionOcupadaException extends RuntimeException {
	public PosicionOcupadaException() { super("No podes ocupar la posicion"); }
}
