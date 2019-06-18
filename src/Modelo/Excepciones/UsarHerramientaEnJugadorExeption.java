package Modelo.Excepciones;

public class UsarHerramientaEnJugadorExeption extends RuntimeException {
	public UsarHerramientaEnJugadorExeption() { super("No podes auto-pegarte con la herramienta"); }
}
