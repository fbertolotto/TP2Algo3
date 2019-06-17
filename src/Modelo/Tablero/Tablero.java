package Modelo.Tablero;

import java.util.Collection;
import java.util.HashMap;
import Modelo.Excepciones.PosicionFueraDeRangoException;
import Modelo.Excepciones.PosicionOcupadaException;
import Modelo.Jugador.Jugador;
import Modelo.Posicionable.Posicionable;

public class Tablero {

	private HashMap<Posicion, Posicionable> grilla;
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
		if(posicion.estaFueraDeRango(ancho, altura)) throw new PosicionFueraDeRangoException();
		if (grilla.containsKey(posicion)) throw new PosicionOcupadaException();
		grilla.put(posicion, posicionable);
		posicionable.setPosicion(posicion);
	}



	public void moverElemento(Posicionable posicionable,int x,int y) {

		Posicion posAnterior = posicionable.getPosicion();
		Posicion nueva = new Posicion(posAnterior.getColumna() + x,posAnterior.getFila()+ y);
		try { colocarElementoEnPosicion(posicionable,nueva); } catch (PosicionOcupadaException | PosicionFueraDeRangoException e) { return; }
		removerElementoEnPosicion(posAnterior);
	}

	public Posicion obtenerPosicionVacia() {
		for(int fila = 0; fila < altura;fila++)
			for(int columna = 0; columna < ancho;columna++) {
				Posicion posicion = new Posicion(columna,fila);
				if(this.obtenerElementoEnPosicion(posicion) == null)
					return posicion;
			}
		return null;
	}

	public int recuentoPosicionable(String nombrePosicionable) {
		int recuento = 0;
		for (int i = 0 ; i < altura ; i++) {
			for (int j = 0 ; j < ancho ; j++) {
				Posicion posicion = new Posicion(j,i);
				if (obtenerElementoEnPosicion(posicion) == null) { continue; }
				if ((obtenerElementoEnPosicion(posicion)).getNombre() == nombrePosicionable) {
					recuento ++;
				}
			}
		}
		return recuento;
	}

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return grilla.values(); }

	public void limpiar(){grilla.clear();}

	public boolean validarAdyacencia(Posicion posicion, Posicion posicionjugador) {
		return posicionjugador.esAdyacente(posicion);
	}
}
