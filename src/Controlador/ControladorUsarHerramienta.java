package Controlador;

import Modelo.Excepciones.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

public class ControladorUsarHerramienta implements EventHandler<ActionEvent> {
	private JuegoVista juego;

	public ControladorUsarHerramienta(JuegoVista juego) {
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		//Esto es acceso rapido para romper un adyacente
		ArrayList<Posicionable> materialesAdyacentes = juego.getJuego().obtenerMaterialesAdyacentes();
		if (materialesAdyacentes.size() == 1) {
			Posicionable posicionable = materialesAdyacentes.get(0);
			try {juego.getJuego().usarHerramienta(posicionable);}
			catch ( UsarHerramientaEnJugadorExeption | HerramientaEquipadaNulaExeption | DurabilidadAgotadaException | PicoFinoMaterialInvalidoExeption e) {juego.escribirEnConsola(e.getMessage());}
			juego.actualizarTodo();
			return;
		}
		//Fin acceso rapido
		juego.getcontenedorJuego().getScene().setOnMouseClicked(mouseEvent -> {
			Posicion posicionJugador = juego.getJuego().getJugador().getPosicion();
			Posicion posicion = new Posicion((int) ((mouseEvent.getX())/ 80)+posicionJugador.getColumna()-12, (int) ((mouseEvent.getY()) / 80)+posicionJugador.getFila()-7);
			Posicionable posicionable = juego.getJuego().getTablero().obtenerElementoEnPosicion(posicion);
			if (posicionable == null) { return; }
			try {juego.getJuego().usarHerramienta(posicionable);}
			catch (MaterialFueraDeAlcanceExeption | DurabilidadAgotadaException | HerramientaEquipadaNulaExeption | UsarHerramientaEnJugadorExeption | PicoFinoMaterialInvalidoExeption e) { juego.escribirEnConsola(e.getMessage());}
			finally {juego.getcontenedorJuego().getScene().setOnMouseClicked(null);}
			juego.actualizarTodo();
			actionEvent.consume();
		});
	}
}

