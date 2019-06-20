package Modelo.Excepciones;

public class UsarHerramientaEnJugadorException extends RuntimeException {
	public UsarHerramientaEnJugadorException() { super("No podes auto-pegarte con la herramienta"); }
}
