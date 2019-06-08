package Modelo.Materiales;


import Modelo.Desgaste.DesgasteLineal;

public abstract class Material {

	protected DesgasteLineal formaDesgaste;

	public float getDurabilidad(){ return formaDesgaste.getDurabilidad(); }

}
