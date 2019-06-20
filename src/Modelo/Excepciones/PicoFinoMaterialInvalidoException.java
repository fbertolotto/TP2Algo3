package Modelo.Excepciones;

public class PicoFinoMaterialInvalidoException extends RuntimeException {
	public PicoFinoMaterialInvalidoException() { super("No podes usar el Pico Fino contra ese material"); }
}
