package Modelo.Jugador;

import Modelo.Excepciones.HerramientaEquipadaNulaException;
import Modelo.Excepciones.InventarioLlenoException;
import Modelo.Excepciones.MaterialNoEsEquipableException;
import Modelo.Herramientas.HachaDeMadera;
import Modelo.Herramientas.Herramienta;
import Modelo.Materiales.Material;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;

import java.util.Collection;

public class Jugador extends Posicionable {

	private Inventario inventario;
	private Herramienta herramientaEquipada;

	public Jugador() {
		inventario = new Inventario();
		HachaDeMadera hacha = new HachaDeMadera();
		inventario.agregar(hacha);
		herramientaEquipada = hacha;
		nombre = "Steve";
	}

	public Inventario getInventario() { return inventario;}

	public Herramienta obtenerHerramientaEquipada() { return herramientaEquipada;}

	public void cambiarHerramientaEquipada(Herramienta herramienta) { herramientaEquipada = herramienta; }

	public void cambiarHerramientaEquipada(Material material) {throw new MaterialNoEsEquipableException();}

	public boolean inventarioLleno() { return obtenerTodosLosElementos().size() == inventario.getTam();}


	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) { return inventario.tiene(unaHerramienta); }

	public void usarHerramientaEquipada(Material material) {

		if(inventarioLleno()) throw new InventarioLlenoException();
		if (herramientaEquipada == null) {throw new HerramientaEquipadaNulaException();}
		while (material.getDurabilidad() > 0) { herramientaEquipada.usar(material); }
	}

	public void removerHerramientaEquipada() {
		removerEnInventario(herramientaEquipada);
		herramientaEquipada = null;
	}

	public void agregarEnInventario(Posicionable posicionable) { inventario.agregar(posicionable); }

	public void agregarEnInventarioEnPosicion(Posicionable posicionable, Posicion posicion) { inventario.agregarEnPosicion(posicionable,posicion); }

	public void removerEnInventario(Posicionable posicionable) { inventario.remover(posicionable); }

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}