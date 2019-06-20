package Vista.MesaDeCrafteoVista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.JuegoVista;
import javafx.event.EventHandler;
import javafx.scene.Node;

import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class ReceptoraMesaDeCrafteoVista {

	public int TAM_CELDA;
	public int corrimientoX;
	public int corrimientoY;
	public ImageView imagenreceptora;
	public Comunicador comunicador;
	public JuegoVista juegoVista;
	public Juego juego;


	public ReceptoraMesaDeCrafteoVista(int tam_celda, int corrimientoX, int corrimientoY, Juego juego, JuegoVista juegoVista, Comunicador comunicador, Posicion posicionaux) {
		this.TAM_CELDA = tam_celda;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.juego = juego;
		this.imagenreceptora = new ImageView();
		imagenreceptora.setImage(null);
		imagenreceptora.setPickOnBounds(true);
		imagenreceptora.setFitHeight(TAM_CELDA);
		imagenreceptora.setFitWidth(TAM_CELDA);
		imagenreceptora.setLayoutX(posicionaux.getColumna() * TAM_CELDA + corrimientoX);
		imagenreceptora.setLayoutY(posicionaux.getFila()* TAM_CELDA + corrimientoY);
	}

	public Node getImagen() {
		return imagenreceptora;
	}

	public void setearOnDragOver() {
		imagenreceptora.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard dragboard = event.getDragboard();

				if (dragboard.hasImage()) {
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
				event.consume();
			}
		});
	}

	public void setearOnDragDroppped() {

		imagenreceptora.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard dragboard = event.getDragboard();

				if (dragboard.hasImage()) {
					imagenreceptora.setImage(dragboard.getImage());
					Posicionable posicionabletrasladado = comunicador.consultarPosicionable();
					int nuevaFila = (int)(imagenreceptora.getLayoutY() - corrimientoY)/TAM_CELDA   ;
					int nuevaColumna = (int)(imagenreceptora.getLayoutX()- corrimientoX)/TAM_CELDA   ;
					double MouseX = comunicador.consultarPosicionMouseX();
					double MouseY = comunicador.consultarPosicionMouseY();
					if((MouseX>1300)&&(MouseX<1600)&&(MouseY>240)&&(MouseY<540)){ juego.getMesaDeCrafteo().removerElemento(posicionabletrasladado);
					} else if((MouseX>1400)&&(MouseX<1500)&&(MouseY>560)&&(MouseY<660)) { juegoVista.getJuego().getMesaDeCrafteo().limpiar();
					} else { juego.getJugador().removerEnInventario(posicionabletrasladado); }
					juego.getMesaDeCrafteo().colocarElementoEnPosicion(posicionabletrasladado, new Posicion(nuevaColumna,nuevaFila));
					juegoVista.getCrafteoVista().actualizarTodo();

					event.setDropCompleted(true);
				} else { event.setDropCompleted(false); }
				event.consume();
			}
		});
	}
}
