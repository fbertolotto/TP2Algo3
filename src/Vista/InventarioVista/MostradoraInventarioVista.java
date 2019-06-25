package Vista.InventarioVista;

import Modelo.Posicionable.Posicionable;
import Vista.Comunicador;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class MostradoraInventarioVista {

	private ImageView imagen;
	private int corrimientoX;
	private int corrimientoY;
	private Comunicador comunicador;
	private Posicionable posicionable;
	private int TAM_CELDA;


	public MostradoraInventarioVista(ImageView imagenMostradora, Posicionable posicionable, int corrimientoY, int corrimientoX, Comunicador comunicador, int TAM_CELDA) {
		this.imagen = imagenMostradora;
		this.posicionable = posicionable;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.TAM_CELDA = TAM_CELDA;
	}

	public void setearOnDragDetected() {

		imagen.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Image imagenaextraer = imagen.getImage();

				if (imagenaextraer == null) {
					event.consume();
					return;
				}

				Dragboard dragboard = imagen.startDragAndDrop(TransferMode.MOVE);

				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenaextraer);
				dragboard.setContent(content);
				comunicador.asignarPosicionable(posicionable);
				comunicador.asignarPosicionMouse(event.getX()+corrimientoX+ (posicionable.getPosicion().getColumna()*TAM_CELDA), event.getY()+corrimientoY+(posicionable.getPosicion().getFila()*TAM_CELDA));
				event.consume();
			}
		});
	}

	public void setearOnDragDone() {
		imagen.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				TransferMode modeUsed = event.getTransferMode();
				if (modeUsed == TransferMode.MOVE) { imagen.setImage(null); }
				event.consume();
			}
		});
	}
}
