package Controlador;

import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMoverJugadorIzquierda implements EventHandler<ActionEvent> {

		private JuegoVista juego;

		public ControladorMoverJugadorIzquierda(JuegoVista juego){
			this.juego = juego;
		}

		@Override
		public void handle(ActionEvent actionEvent) {
			juego.getJuego().moverJugadorEnHorizontal(-1);
			juego.actualizarTodo();
		}
	}
