package Modelo.Mapa;

import Modelo.Materiales.Diamante;
import Modelo.Materiales.Madera;
import Modelo.Materiales.Metal;
import Modelo.Materiales.Piedra;

public class InicializadorDeMateriales {

	PosicionadorRandom posicionador;

	public InicializadorDeMateriales(Mapa unMapa) {
		posicionador = new PosicionadorRandom(unMapa);
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
			posicionador.crearPosicionRandomYAgregarElemento(madera);
		}
	}
	private void inicializarMaterialMetal(int cant) {
		for (int i = 0; i < cant; i++) {
			Metal metal = new Metal();
			posicionador.crearPosicionRandomYAgregarElemento(metal);
		}
	}
	private void inicializarMaterialDiamante(int cant) {
		for (int i = 0; i < cant; i++) {
			Diamante diamante = new Diamante();
			posicionador.crearPosicionRandomYAgregarElemento(diamante);
		}
	}
	private void inicializarMaterialPiedra(int cant) {
		for (int i = 0; i < cant; i++) {
			Piedra piedra = new Piedra();
			posicionador.crearPosicionRandomYAgregarElemento(piedra);
		}
	}
}
