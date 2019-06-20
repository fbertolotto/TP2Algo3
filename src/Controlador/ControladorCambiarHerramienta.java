package Controlador;

import Modelo.Excepciones.MaterialNoEsEquipableException;
import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class ControladorCambiarHerramienta  implements EventHandler<ActionEvent> {

	private JuegoVista juego;

	public ControladorCambiarHerramienta(JuegoVista juego){ this.juego = juego; }

	@Override
	public void handle(ActionEvent actionEvent) {
		juego.getCrafteoVista().getInventarioVista().mostrarInventarioCambiar();
		juego.getcontenedorJuego().getScene().setOnMousePressed(mouseEvent -> {
			Posicion posicion = new Posicion((int) (mouseEvent.getX()-540 ) / 80, (int) (mouseEvent.getY()-240) / 80);
			Posicionable posicionable = juego.getJuego().getJugador().getInventario().obtenerElementoEnPosicion(posicion);
			if (posicionable instanceof Herramienta) {juego.getJuego().getJugador().cambiarHerramientaEquipada((Herramienta)posicionable);}
			else if (posicionable != null){ juego.escribirEnConsola(new MaterialNoEsEquipableException().getMessage());}
			juego.getcontenedorJuego().getScene().setOnMousePressed(null);
			juego.actualizarTodo();
			actionEvent.consume();
		});

		Scene escena  = juego.getcontenedorJuego().getScene();
		escena.setOnKeyPressed(e -> {
			if(e.getCode()== KeyCode.Q){
				juego.actualizarTodo();
				actionEvent.consume();
			}
		});


	}
}

