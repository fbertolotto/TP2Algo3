package Modelo.Jugador;

import Modelo.Excepciones.HerramientaEquipadaNulaExeption;
import Modelo.Excepciones.MaterialNoEsEquipableExeption;
import Modelo.Herramientas.*;
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
		PicoDePiedra pico = new PicoDePiedra();
		inventario.agregar(hacha);
		inventario.agregar(pico);
		herramientaEquipada = pico;
		nombre = "Steve";
	}

	public Herramienta obtenerHerramientaEquipada() { return herramientaEquipada;}

	public void cambiarHerramientaEquipada(Herramienta herramienta) { herramientaEquipada = herramienta; }

	public void cambiarHerramientaEquipada(Material material) {throw new MaterialNoEsEquipableExeption();}


	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) { return inventario.tiene(unaHerramienta); }

	public void usarHerramientaEquipada(Material material) {
		if (herramientaEquipada == null) {throw new HerramientaEquipadaNulaExeption();}
		while (material.getDurabilidad() > 0) { herramientaEquipada.usar(material); }
	}

	public void removerHerramientaEquipada() {
		removerEnInventario(herramientaEquipada);
		herramientaEquipada = null;
	}

	public void agregarEnInventario(Posicionable posicionable) { inventario.agregar(posicionable); }

	public void agregarEnInventarioEnPosicion(Posicionable posicionable, Posicion posicion) { inventario.agregarEnPosicion(posicionable,posicion); }

	public void removerEnInventario(Posicionable posicionable) { inventario.remover(posicionable); }

	public Inventario getInventario() { return inventario;}

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}