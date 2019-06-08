package Modelo.Materiales;


import Modelo.Desgaste.DesgasteLineal;

public abstract class Material {

	protected DesgasteLineal desgaste;

	public float getDurabilidad(){ return desgaste.getDurabilidad(); }

}
