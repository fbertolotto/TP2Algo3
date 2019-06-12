package Modelo.Tablero;

import java.util.Collection;
import java.util.HashMap;
import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Posicionable.Posicionable;

public class Tablero {

	protected HashMap<Posicion, Posicionable> grilla;
	private int altura;
	private int ancho;

	public Tablero(int unaAltura, int unAncho) {
		grilla = new HashMap<>();
		altura = unaAltura;
		ancho = unAncho;
	}

	public int getAltura() { return altura; }
	public int getAncho() { return ancho; }

	public void inicializarMateriales() { new InicializadorDeMateriales(this).inicializarMateriales(); }


	public Posicionable obtenerElementoEnPosicion(Posicion posicion) { return grilla.getOrDefault(posicion, null); }

	public void removerElementoEnPosicion(Posicion posicion) { grilla.remove(posicion); }

	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) {
		if(posicion.estaFueraDeRango(altura,ancho)) throw new PosicionFueraDeRangoException();
		if (grilla.containsKey(posicion)) throw new PosicionOcupadaException();
		grilla.put(posicion, posicionable);
		posicionable.setPosicion(posicion);
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


	public Collection<Posicionable> obtenerTodosLosElementos(){ return grilla.values(); }

	/*
	//Se puede usar para futuro inventario.
	public Posicion obtenerPosicionVacia() {
		for(int i = 0; i < ancho;i++)
			for(int j = 0; j < altura;j++) {
				Posicion posicion = new Posicion(i,j);
				if(this.obtenerElementoEnPosicion(posicion) == null)
					return posicion;
			}
		return null;
	}
	*/

}
