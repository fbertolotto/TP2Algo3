package Modelo.Jugador;

import Modelo.Excepciones.MaterialNoEsEquipable;
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
		inventario.agregar(hacha);
		herramientaEquipada = hacha;
		nombre = "Jugador";
		rutaImagen = "media/images/Steve.png/";

	}

	public Herramienta obtenerHerramientaEquipada() { return herramientaEquipada;}

	public void cambiarHerramientaEquipada(Herramienta herramienta) { herramientaEquipada = herramienta; }

	public void cambiarHerramientaEquipada(Material material) {throw new MaterialNoEsEquipable();}

	public boolean tieneUnaHerramienta(Herramienta unaHerramienta) { return inventario.tiene(unaHerramienta); }

	public void agregarEnInventario(Posicionable posicionable) { inventario.agregar(posicionable); }

	public void agregarEnInventarioEnPosicion(Posicionable posicionable, Posicion posicion) { inventario.agregarEnPosicion(posicionable,posicion); }

	public void removerEnInventario(Posicionable posicionable) { inventario.remover(posicionable); }

	public Inventario getInventario() { return inventario;}

	//Sirve para la vista
	public Collection<Posicionable> obtenerTodosLosElementos(){ return inventario.obtenerTodosLosElementos(); }
}