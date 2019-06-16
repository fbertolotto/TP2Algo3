package Controlador;
import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCerrarCrafteo implements EventHandler<ActionEvent> {

		private JuegoVista juego;

		public ControladorCerrarCrafteo(JuegoVista juego){
			this.juego = juego;
		}

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Cerrar Mesa de Crafteo.");
			juego.actualizarTodo();
		}
	}

