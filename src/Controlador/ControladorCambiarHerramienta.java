package Controlador;

import Modelo.Excepciones.MaterialNoEsEquipableExeption;
import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.InventarioVista.InventarioVista;
import Vista.JuegoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorCambiarHerramienta  implements EventHandler<ActionEvent> {
	private JuegoVista juego;

	public ControladorCambiarHerramienta(JuegoVista juego){
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		new InventarioVista().mostrarInventarioCambiar(juego);
		juego.getcontenedorJuego().getScene().setOnMousePressed(mouseEvent -> {
			Posicion posicion = new Posicion((int) (mouseEvent.getX()-540 ) / 80, (int) (mouseEvent.getY()-240) / 80);
			Posicionable posicionable = juego.getJuego().getJugador().getInventario().obtenerElementoEnPosicion(posicion);
			if (posicionable instanceof Herramienta) {juego.getJuego().getJugador().cambiarHerramientaEquipada((Herramienta)posicionable);}
			else if (posicionable == null) {}
			else {juego.escribirEnConsola(new MaterialNoEsEquipableExeption().getMessage());}
			juego.getcontenedorJuego().getScene().setOnMousePressed(null);
			juego.actualizarTodo();
			actionEvent.consume();
		});
	}
}

