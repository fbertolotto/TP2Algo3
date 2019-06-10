package Modelo.Excepciones;

public class PosicionOcupadaException extends RuntimeException {

	public PosicionOcupadaException() {
		super("Posicion ocupada");
	}

}
