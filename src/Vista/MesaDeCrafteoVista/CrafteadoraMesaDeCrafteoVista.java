package Vista.MesaDeCrafteoVista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.Comunicador;
import Vista.JuegoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class CrafteadoraMesaDeCrafteoVista {

	public int TAM_CELDA;
	public int corrimientoX;
	public int corrimientoY;
	public ImageView imagencrafteada;
	public Comunicador comunicador;
	private JuegoVista juegoVista;
	public Juego juego;


	public CrafteadoraMesaDeCrafteoVista(ImageView imagencrafteada, int TAM_CELDA, int corrimientoX, int corrimientoY, JuegoVista juegoVista, Comunicador comunicador) {
		this.imagencrafteada = imagencrafteada;
		this.TAM_CELDA = TAM_CELDA;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.juego = juegoVista.getJuego();
	}

	public void setearOnDragDetected(Posicionable posicionablecrafteado) {

		imagencrafteada.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Image imagenaextraer = imagencrafteada.getImage();

				if (imagenaextraer == null) {
					event.consume();
					return;
				}


				Dragboard dragboard = imagencrafteada.startDragAndDrop(TransferMode.COPY_OR_MOVE);


				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenaextraer);
				dragboard.setContent(content);
				comunicador.asignarPosicionable(posicionablecrafteado);
				comunicador.asignarPosicionMouse(event.getX()+corrimientoX, event.getY()+corrimientoY);
				event.consume();
			}
		});
	}



	public void setearOnDragDone() {
		imagencrafteada.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				TransferMode modeUsed = event.getTransferMode();

				if (modeUsed == TransferMode.MOVE) {
					imagencrafteada.setImage(null);
				}
				juegoVista.getCrafteoVista().actualizarTodo();
				event.consume();
			}
		});
	}
}
