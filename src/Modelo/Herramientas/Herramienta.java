package Modelo.Herramientas;

import Modelo.Desgaste.Desgaste;

public abstract class Herramienta {

	protected int fuerza;
	protected Desgaste formaDesgaste;

	public float getDurabilidad() { return formaDesgaste.getDurabilidad(); }

	public int getFuerza() { return this.fuerza; }

}
