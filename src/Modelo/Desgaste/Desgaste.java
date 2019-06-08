package Modelo.Desgaste;

import Modelo.Excepciones.DurabilidadAgotadaException;

public abstract class Desgaste {

	public float durabilidad;


	public abstract void desgastar(float valor) throws DurabilidadAgotadaException;

	public float getDurabilidad() { return this.durabilidad; }

}
