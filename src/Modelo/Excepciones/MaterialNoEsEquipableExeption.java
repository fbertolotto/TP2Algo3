package Modelo.Excepciones;

public class MaterialNoEsEquipableExeption extends RuntimeException {
	public MaterialNoEsEquipableExeption() {
		super("No podes equipar un material como herramienta");
	}
}
