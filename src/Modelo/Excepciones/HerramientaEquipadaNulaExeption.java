package Modelo.Excepciones;

public class HerramientaEquipadaNulaExeption extends RuntimeException {
	public HerramientaEquipadaNulaExeption() {
		super("No tenes una herramienta equipada");
	}
}
