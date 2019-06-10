package Modelo.Mapa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Materiales.*;
import Modelo.Posicionable.Posicionable;

public class Mapa {

	protected HashMap<Posicion, Posicionable> grilla;
	private int altura;
	private int ancho;

	public Mapa(int unaAltura,int unAncho) {
		grilla = new HashMap<>();
		altura = unaAltura;
		ancho = unAncho;

	}

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) {
		return grilla.getOrDefault(posicion, null);
	}

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) {

		if(posicion.estaFueraDeRango(altura,ancho)) throw new PosicionFueraDeRangoException();
		if (grilla.containsKey(posicion)) throw new PosicionOcupadaException(); //ESTO NO ANDA
		grilla.put(posicion, posicionable);

	}

	public void removerElementoEnPosicion(Posicion posicion) {
		grilla.remove(posicion);
	}

	public Posicion obtenerPosicionVacia() {
		for(int i = 0; i < ancho;i++)
			for(int j = 0; j < altura;j++) {
				Posicion posicion = new Posicion(i,j);
				if(this.obtenerElementoEnPosicion(posicion) == null)
					return posicion;
			}
		return null;
	}

	public boolean estaVacia(Posicion posicion) { return obtenerElementoEnPosicion(posicion) == null; }

	public boolean validaParaMateriales(Posicion posicion) {
		return ( !(posicion.estaFueraDeRangoParaMateriales(altura,ancho)) && estaVacia(posicion) );
	}

	public void inicializarMaterial(Madera madera) {
		for (int i = 0; i < 16; i++) {
			Posicion posRandom = crearPosicionRandomValida();
			int posX = posRandom.getPosX();
			int posY = posRandom.getPosY();
			colocarElementoEnPosicion(madera, posRandom);
		}

	}

	public void inicializarMaterial(Material material) {
		for (int i = 0; i < 4; i++) {
			Posicion posRandom = crearPosicionRandomValida();
			colocarElementoEnPosicion((Posicionable) material, posRandom);
		}

	}

	public Posicion crearPosicionRandomValida() {
		while (true) {
			int randomX = ThreadLocalRandom.current().nextInt(1, ancho); // va de 1 a ancho-1
			int randomY = ThreadLocalRandom.current().nextInt(1, altura); // va de 1 a altura-1
			Posicion posicion = new Posicion(randomX, randomY);
			if (validaParaMateriales(posicion)) { return posicion; }
		}
	}

	public int recuentoPosicionable(Posicionable posicionable) {
		int recuento = 0;
		for (int i = 0 ; i < altura ; i++) {
			for (int j = 0 ; j < ancho ; j++) {
				Posicion posicion = new Posicion(j,i);
				if (obtenerElementoEnPosicion(posicion) == null) { continue; }
				if ((obtenerElementoEnPosicion(posicion)).getNombre() == posicionable.getNombre()) {
					recuento ++;
				}
			}
		}
		return recuento;
	}

}
