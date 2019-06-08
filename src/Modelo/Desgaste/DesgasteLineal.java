package Modelo.Desgaste;

import Modelo.Excepciones.DurabilidadAgotadaException;

public class DesgasteLineal extends Desgaste{

	private float divisor;

	public DesgasteLineal(float unDivisor, float unaDurabilidad) {
		divisor = unDivisor;
		durabilidad = unaDurabilidad;
	}

	@Override
	public void desgastar(float valor) throws DurabilidadAgotadaException {
		if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
		this.durabilidad -= (valor/this.divisor);
	}

}
