package Modelo.Excepciones;

public class DurabilidadAgotadaException extends RuntimeException {
	public DurabilidadAgotadaException() {
		super("Se agoto la durabilidad de la herramienta");
	}
}
