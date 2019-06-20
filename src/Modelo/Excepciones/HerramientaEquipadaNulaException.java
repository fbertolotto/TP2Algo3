package Modelo.Excepciones;

public class HerramientaEquipadaNulaException extends RuntimeException {
	public HerramientaEquipadaNulaException() {
		super("No tenes una herramienta equipada");
	}
}
