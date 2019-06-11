package Modelo.Mapa;

import java.util.Collection;
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

	public Posicionable obtenerElementoEnPosicion(Posicion posicion) { return grilla.getOrDefault(posicion, null); }

	public void removerElementoEnPosicion(Posicion posicion) { grilla.remove(posicion); }

	public Collection<Posicionable> obtenerTodosLosElementos(){ return grilla.values(); }


	public void colocarElementoEnPosicion(Posicionable posicionable, Posicion posicion) {

		if(posicion.estaFueraDeRango(altura,ancho)) throw new PosicionFueraDeRangoException();
		if (grilla.containsKey(posicion)) throw new PosicionOcupadaException();
		grilla.put(posicion, posicionable);
		posicionable.setPosicion(posicion);
	}


	public void inicializarMateriales() {
		inicializarMaterialMadera(8);
		inicializarMaterialMetal(4);
		inicializarMaterialPiedra(6);
		inicializarMaterialDiamante(2);
	}

	private void inicializarMaterialMadera(int cant) {
		for (int i = 0; i < cant; i++) {
			Madera madera = new Madera();
			crearPosicionRandmonYAgregarElemento(madera);
		}
	}
	private void inicializarMaterialMetal(int cant) {
		for (int i = 0; i < cant; i++) {
			Metal metal = new Metal();
			crearPosicionRandmonYAgregarElemento(metal);
		}
	}
	private void inicializarMaterialDiamante(int cant) {
		for (int i = 0; i < cant; i++) {
			Diamante diamante = new Diamante();
			crearPosicionRandmonYAgregarElemento(diamante);
		}
	}
	private void inicializarMaterialPiedra(int cant) {
		for (int i = 0; i < cant; i++) {
			Piedra piedra = new Piedra();
			crearPosicionRandmonYAgregarElemento(piedra);
		}
	}

	private void crearPosicionRandmonYAgregarElemento(Posicionable posicionable) {
		Posicion posRandom = crearPosicionRandomValida();
		colocarElementoEnPosicion(posicionable, posRandom);
	}


	private boolean validaParaMateriales(Posicion posicion) { return (!(posicion.estaFueraDeRangoParaMateriales(altura, ancho)) && estaVacia(posicion)); }

	private boolean estaVacia(Posicion posicion) { return obtenerElementoEnPosicion(posicion) == null; }

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

	//Se podria eliminar por la random que tenemos
	public Posicion obtenerPosicionVacia() {
		for(int i = 0; i < ancho;i++)
			for(int j = 0; j < altura;j++) {
				Posicion posicion = new Posicion(i,j);
				if(this.obtenerElementoEnPosicion(posicion) == null)
					return posicion;
			}
		return null;
	}


}
