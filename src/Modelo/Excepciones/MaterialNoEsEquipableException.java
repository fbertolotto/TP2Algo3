package Modelo.Excepciones;

public class MaterialNoEsEquipableException extends RuntimeException {
	public MaterialNoEsEquipableException() {
		super("No podes equipar un material como herramienta");
	}
}
