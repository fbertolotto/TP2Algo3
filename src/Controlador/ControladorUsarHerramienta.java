package Controlador;

import Modelo.Excepciones.*;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

import static Vista.Cancion.reproducirSonido;

public class ControladorUsarHerramienta implements EventHandler<ActionEvent> {
	private JuegoVista juego;

	public ControladorUsarHerramienta(JuegoVista juego) {
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {

		Posicion posicionJugador = juego.getJuego().getJugador().getPosicion();
		Rectangle rangodeAtaque = new Rectangle();
		rangodeAtaque.setFill(Color.rgb(0, 0, 0, 0.2));
		rangodeAtaque.setWidth(80*3);
		rangodeAtaque.setHeight(80*3);
		rangodeAtaque.setMouseTransparent(true);
		rangodeAtaque.setVisible(true);
		rangodeAtaque.setLayoutX( (11) * 80);
		rangodeAtaque.setLayoutY( (6) * 80);
		juego.getcontenedorJuego().getChildren().add(rangodeAtaque);

		Scene escena  = juego.getcontenedorJuego().getScene();
		escena.setOnKeyPressed(e -> {
			juego.getcontenedorJuego().getChildren().remove(rangodeAtaque);
			juego.actualizarTeclas();
			actionEvent.consume();
		});

		ArrayList<Posicionable> materialesAdyacentes = juego.getJuego().obtenerMaterialesAdyacentes();

		if (materialesAdyacentes.size() == 1) { //Esto es acceso rapido para romper un adyacente
			Posicionable posicionable = materialesAdyacentes.get(0);
			intenarObtenerElemento(posicionable);
			return;
		}
		juego.getcontenedorJuego().getScene().setOnMouseClicked(mouseEvent -> {
			Posicion posicion = new Posicion((int) ((mouseEvent.getX())/ 80)+ posicionJugador.getColumna()-12, (int) ((mouseEvent.getY()) / 80) + posicionJugador.getFila()-7);
			Posicionable posicionable = juego.getJuego().getTablero().obtenerElementoEnPosicion(posicion);
			intenarObtenerElemento(posicionable);
			actionEvent.consume();
			});
	}

	private void intenarObtenerElemento(Posicionable posicionable) {
		if (posicionable == null) { return; }
		try {
			juego.getJuego().usarHerramienta(posicionable);
			reproducirSonido("media/audio/Romper.mp3", 1, 1);
		} catch (MaterialFueraDeAlcanceException | DurabilidadAgotadaException | HerramientaEquipadaNulaException | UsarHerramientaEnJugadorException | PicoFinoMaterialInvalidoException | UsarHerramientaEnZombieException | InventarioLlenoException e) { juego.avisarUsuario(e); }
		finally { juego.getcontenedorJuego().getScene().setOnMouseClicked(null); }
		juego.actualizarTodo();
	}
}

