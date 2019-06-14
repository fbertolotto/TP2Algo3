package Vista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.PosicionablesVista.PosicionableVista;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.Collection;

public class InventarioVista {
	private JuegoVista juegoVista;

	public void mostrarInventario(JuegoVista juegoVista){
		this.juegoVista = juegoVista;
		Juego juego = juegoVista.getJuego();
		Collection<Posicionable> tablero  = juego.getJugador().obtenerTodosLosElementos();
		new Grilla().mostrarGrilla(juegoVista.getcontenedorJuego(), 560 ,240, Color.GRAY, Color.DARKGRAY, 80, 8,5, 1);
		for( Posicionable posicionable : tablero) {
			ImageView imagen = new PosicionableVista(juegoVista.getcontenedorJuego(), posicionable).mostrarPosicionable(560, 240);
			imagen.setOnMousePressed(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					imagen.setMouseTransparent(true);
					System.out.println("Event on Source: mouse pressed");
					event.setDragDetect(true);
				}
			});
			imagen.setOnMouseReleased(MouseEvent -> {
					imagen.setMouseTransparent(false);
					System.out.println("Event on Source: mouse released");

					double LayoutY =imagen.getLayoutY();
					int nuevaFila = (int)(imagen.getLayoutY() - 240)/80  ;
					System.out.println("Fila "+ nuevaFila);
					System.out.println("LayoutY "+ LayoutY);

					double LayoutX=imagen.getLayoutX();
					int nuevaColumna = (int)(imagen.getLayoutX()- 560)/80  ;
					System.out.println("Columna "+ nuevaColumna);
					System.out.println("LayoutX "+ LayoutX);

					juego.getJugador().removerEnInventario(posicionable);
					juego.getJugador().agregarEnInventarioEnPosicion(posicionable,new Posicion(nuevaColumna,nuevaFila));
					mostrarInventario(juegoVista);

			});
			imagen.setOnMouseDragged(MouseEvent -> {
				imagen.toFront();
				imagen.setFitHeight(30);
				imagen.setFitWidth(30);
				imagen.setLayoutX(imagen.getLayoutX() + MouseEvent.getX() - imagen.getFitWidth() / 2);
				imagen.setLayoutY(imagen.getLayoutY() + MouseEvent.getY() - imagen.getFitHeight() / 2);
			});
			imagen.setOnDragDetected(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					imagen.startFullDrag();
					System.out.println("Event on Source: drag detected");
				}
			});

		}
	}

}