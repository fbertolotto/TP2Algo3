package Modelo.Excepciones;

public class PicoFinoMaterialInvalidoExeption extends RuntimeException {
	public PicoFinoMaterialInvalidoExeption() { super("No podes usar el Pico Fino contra ese material"); }
}
