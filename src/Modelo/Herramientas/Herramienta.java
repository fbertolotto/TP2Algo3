package Modelo.Herramientas;

import Modelo.Desgaste.Desgaste;
import Modelo.Materiales.Material;
import Modelo.Posicionable.Posicionable;

public abstract class Herramienta extends Posicionable {

	protected int fuerza;
	protected Desgaste formaDesgaste;

	public float getDurabilidad() { return formaDesgaste.getDurabilidad(); }

	public int getFuerza() { return fuerza; }

	public abstract void usar(Material material);

}
