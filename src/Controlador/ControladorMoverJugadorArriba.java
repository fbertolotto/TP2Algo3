package Controlador;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.Grilla;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.Collection;

import static Vista.Imagen.elegirImagenDeFondo;

public class ControladorMoverJugadorArriba implements EventHandler<ActionEvent> {

		private Juego juego;
		private Pane contenedor;

		public ControladorMoverJugadorArriba(Juego juego, Pane contenedor){
			this.juego = juego;
			this.contenedor = contenedor;
		}

		@Override
		public void handle(ActionEvent actionEvent) {
			juego.moverJugadorEnVertical(-1);
		}
	}
