package Controlador;

import Modelo.Excepciones.MaterialFueraDeAlcanceExeption;
import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorUsarHerramienta implements EventHandler<ActionEvent> {
	private JuegoVista juego;
	private Herramienta herramienta;

	public ControladorUsarHerramienta(JuegoVista juego){
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		herramienta = juego.getJuego().getJugador().obtenerHerramientaEquipada();
		juego.getcontenedorJuego().getScene().setOnMouseClicked(mouseEvent -> {
			Posicion posicion = new Posicion((int) mouseEvent.getX() / 80, (int) (mouseEvent.getY() / 80));
			Posicionable posicionable = juego.getJuego().getTablero().obtenerElementoEnPosicion(posicion);
			if (posicionable == null) {return;}
			try { juego.getJuego().usarHerramienta(posicionable);}
			catch (MaterialFueraDeAlcanceExeption e) {}
			finally { juego.getcontenedorJuego().getScene().setOnMouseClicked(null); }
			juego.actualizarTodo();
		});
	}
}
