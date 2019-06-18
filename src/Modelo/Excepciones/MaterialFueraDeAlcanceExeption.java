package Modelo.Excepciones;

public class MaterialFueraDeAlcanceExeption extends RuntimeException {
	public MaterialFueraDeAlcanceExeption() {
		super("El material se encuentra muy lejos");
	}
}
