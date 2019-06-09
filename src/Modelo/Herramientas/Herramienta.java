package Modelo.Herramientas;

import Modelo.Desgaste.Desgaste;

import Modelo.Interfaces.*;

public abstract class Herramienta implements Guardable{

	protected int fuerza;
	protected Desgaste formaDesgaste;

	public float getDurabilidad() { return formaDesgaste.getDurabilidad(); }

	public int getFuerza() { return this.fuerza; }

}
