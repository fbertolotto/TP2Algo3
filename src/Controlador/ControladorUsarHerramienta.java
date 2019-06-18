package Controlador;

import Modelo.Excepciones.DurabilidadAgotadaException;
import Modelo.Excepciones.MaterialFueraDeAlcanceExeption;
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
		ArrayList<Posicionable> materialesAdyacentes = juego.getJuego().obtenerMaterialesAdyacentes();
		if (materialesAdyacentes.size() == 1) {
			Posicionable posicionable = materialesAdyacentes.get(0);
			try {juego.getJuego().usarHerramienta(posicionable);}
			catch (DurabilidadAgotadaException e) {}
			juego.actualizarTodo();
			return;
		}
		juego.getcontenedorJuego().getScene().setOnMouseClicked(mouseEvent -> {
			Posicion posicion = new Posicion((int) mouseEvent.getX() / 80, (int) (mouseEvent.getY() / 80));
			Posicionable posicionable = juego.getJuego().getTablero().obtenerElementoEnPosicion(posicion);
			if (posicionable == null) {
				return;
			}
			System.out.println(posicionable.getNombre());
			try {juego.getJuego().usarHerramienta(posicionable);}
			catch (MaterialFueraDeAlcanceExeption | DurabilidadAgotadaException e) {}
			finally {juego.getcontenedorJuego().getScene().setOnMouseClicked(null);}
			juego.actualizarTodo();
			actionEvent.consume();
		});
	}
}

