package Modelo.Tablero;

import java.util.Objects;

public class Posicion {
	private int fila;
	private int columna;

	public Posicion(int unaFila,int unaColumna) {
		fila = unaFila;
		columna = unaColumna;
	}

	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) return true;
		if (objeto == null || getClass() != objeto.getClass()) return false;
		Posicion posicion = (Posicion) objeto;
		return fila == posicion.fila && columna == posicion.columna;
	}

	@Override
	public int hashCode() { return Objects.hash(fila, columna);
	}


	public boolean estaFueraDeRango(int altura, int ancho) {
		return (fila > ancho || columna > altura || fila < 0 || columna < 0);
	}

	public boolean estaFueraDeRangoParaMateriales(int altura, int ancho) {
		return (fila >= ancho || columna >= altura || fila <= 0 || columna <= 0);
	}
}