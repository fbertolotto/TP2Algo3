package Modelo.Materiales;


import Modelo.Desgaste.DesgasteLineal;
import Modelo.Posicionable.Posicionable;

public abstract class Material extends Posicionable {

	protected DesgasteLineal formaDesgaste;

	public float getDurabilidad(){ return formaDesgaste.getDurabilidad(); }

}
