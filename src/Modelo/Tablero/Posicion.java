package Modelo.Tablero;

import java.util.Objects;

import static java.lang.Math.abs;

public class Posicion  {
	private int columna;
	private int fila;

	public Posicion(int unaColumna,int unaFila) {
		columna = unaColumna;
		fila = unaFila;
	}

	public int getColumna() {
		return columna;
	}
	public int getFila() { return fila;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) return true;
		if (objeto == null || getClass() != objeto.getClass()) return false;
		Posicion posicion = (Posicion) objeto;
		return columna == posicion.columna && fila == posicion.fila;
	}

	@Override
	public int hashCode() { return Objects.hash(columna, fila);
	}


	public boolean estaFueraDeRango(int ancho, int altura) {
		return (columna > ancho || fila > altura || columna < 0 || fila < 0);
	}

	public boolean estaFueraDeRangoParaMateriales(int altura, int ancho) {
		return (columna >= ancho || fila >= altura || columna <= 0 || fila <= 0);
	}

	public boolean esAdyacente(Posicion posicion) {
		int diferenciaColumna = abs(columna - posicion.getColumna());
		int diferenciaFila = abs(fila - posicion.getFila());
		return diferenciaColumna <= 1 && diferenciaFila <= 1;
	}
}