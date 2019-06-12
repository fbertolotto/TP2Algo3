package Modelo.Tablero;

import Modelo.Posicionable.Posicionable;

import java.util.concurrent.ThreadLocalRandom;

public class PosicionadorRandom {

	public Tablero tablero;
	private int alturaMapa;
	private int anchoMapa;

	public PosicionadorRandom(Tablero unTablero) {
		tablero = unTablero;
		alturaMapa = tablero.getAltura();
		anchoMapa = tablero.getAncho();
	}

	public void crearPosicionRandomYAgregarElemento(Posicionable posicionable) {
		Posicion posRandom = crearPosicionRandomValida();
		tablero.colocarElementoEnPosicion(posicionable, posRandom);
	}

	public Posicion crearPosicionRandomValida() {
		while (true) {
			int randomX = ThreadLocalRandom.current().nextInt(1, anchoMapa); // va de 1 a ancho-1
			int randomY = ThreadLocalRandom.current().nextInt(1, alturaMapa); // va de 1 a altura-1
			Posicion posicion = new Posicion(randomX, randomY);
			if (validaParaMateriales(posicion)) {
				return posicion; }
		}
	}

	private boolean validaParaMateriales(Posicion posicion) { return (!(posicion.estaFueraDeRangoParaMateriales(alturaMapa, anchoMapa)) && estaVacia(posicion)); }

	private boolean estaVacia(Posicion posicion) { return tablero.obtenerElementoEnPosicion(posicion) == null; }


}
