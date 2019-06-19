package Vista.InventarioVista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import Vista.Comunicador;
import Vista.CrafteoVista;
import Vista.JuegoVista;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class ReceptoraInventarioVista {

	public int TAM_CELDA;
	public int corrimientoX;
	public int corrimientoY;
	public ImageView imagenreceptora;
	public Comunicador comunicador;
	public JuegoVista juegoVista;
	public Juego juego;

	public ReceptoraInventarioVista(Posicion posicionaux, int tam_celda, int CorrimientoX, int CorrimientoY, Juego juego, JuegoVista juegoVista, Comunicador comunicador) {
		this.TAM_CELDA = tam_celda;
		this.corrimientoX = CorrimientoX;
		this.corrimientoY = CorrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.juego = juego;

		imagenreceptora = new ImageView();
		imagenreceptora.setImage(null);
		imagenreceptora.setPickOnBounds(true);
		imagenreceptora.setFitHeight(TAM_CELDA);
		imagenreceptora.setFitWidth(TAM_CELDA);
		imagenreceptora.setLayoutX(posicionaux.getColumna() * TAM_CELDA + corrimientoX);
		imagenreceptora.setLayoutY(posicionaux.getFila() * TAM_CELDA + corrimientoY);
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

	public void setearOnDragDropped() {

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

					if((MouseX<1300)&&(MouseX>540)&&(MouseY<720)&&(MouseY>240)){ juego.getJugador().removerEnInventario(posicionabletrasladado);
					} else if((MouseY>560)&&(MouseY<660)&&(MouseX>1400)&&(MouseX<1500)) { new CrafteoVista(juegoVista).actualizarCelda(juegoVista);
					} else { juego.getMesaDeCrafteo().removerElemento(posicionabletrasladado); }
					juego.getJugador().agregarEnInventarioEnPosicion(posicionabletrasladado, new Posicion(nuevaColumna,nuevaFila));
					new CrafteoVista(juegoVista).actualizarTodo(juegoVista,comunicador);


					event.setDropCompleted(true);
				} else { event.setDropCompleted(false); }
				event.consume();
			}
		});
	}
}
