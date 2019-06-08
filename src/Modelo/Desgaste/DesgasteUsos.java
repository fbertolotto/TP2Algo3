package Modelo.Desgaste;

import Modelo.Excepciones.DurabilidadAgotadaException;

public class DesgasteUsos extends Desgaste {

	private int usos = 1;
	private int usosmaximos;

	public DesgasteUsos(int unosUsosMaximos, float unaDurabilidad) {
		usosmaximos = unosUsosMaximos;
		durabilidad = unaDurabilidad;
	}

	@Override
	public void desgastar(float numero) throws DurabilidadAgotadaException {
		if (this.durabilidad <= 0) throw new DurabilidadAgotadaException();
		if (this.usos == this.usosmaximos) {
			this.durabilidad = 0;
			return;
		}
		this.usos++;
	}

}