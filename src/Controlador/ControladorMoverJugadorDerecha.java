package Controlador;

import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMoverJugadorDerecha implements EventHandler<ActionEvent> {

		private JuegoVista juego;

		public ControladorMoverJugadorDerecha(JuegoVista juego){
			this.juego = juego;
		}

		@Override
		public void handle(ActionEvent actionEvent) {
			juego.getJuego().moverJugadorEnHorizontal(1);
			juego.actualizarTodo();
		}
	}
