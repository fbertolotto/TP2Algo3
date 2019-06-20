package Modelo.Excepciones;

public class MaterialFueraDeAlcanceException extends RuntimeException {
	public MaterialFueraDeAlcanceException() {
		super("El material se encuentra muy lejos");
	}
}
