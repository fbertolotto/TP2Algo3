package Modelo.Desgaste;

import Modelo.Excepciones.DurabilidadAgotadaException;

public abstract class Desgaste {

	public float durabilidad;
	public float durabilidadInicial;


	public abstract void desgastar(float valor) throws DurabilidadAgotadaException;

	public float getDurabilidad() { return this.durabilidad; }

	public float getDurabilidadInicial() { return this.durabilidadInicial; }

}
