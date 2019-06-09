package Modelo.Materiales;


import Modelo.Desgaste.DesgasteLineal;
import Modelo.Posicionable.Posicionable;
import Modelo.Mapa.Posicion;

public abstract class Material extends Posicionable {

	protected DesgasteLineal formaDesgaste;
	protected String nombre;

	public float getDurabilidad(){ return formaDesgaste.getDurabilidad(); }

	public String getNombre() {
		return nombre;
	}
}
