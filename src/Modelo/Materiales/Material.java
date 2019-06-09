package Modelo.Materiales;


import Modelo.Desgaste.DesgasteLineal;
import Modelo.Interfaces.Guardable;

public abstract class Material implements Guardable {

	protected DesgasteLineal formaDesgaste;
	protected String nombre;

	public float getDurabilidad(){ return formaDesgaste.getDurabilidad(); }

	public String getNombre() {
		return nombre;
	}
}
