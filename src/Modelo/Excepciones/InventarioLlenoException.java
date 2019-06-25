package Modelo.Excepciones;

public class InventarioLlenoException extends RuntimeException {
	public InventarioLlenoException() {
		super("No tenes mas espacio en el inventario");
	}
}
