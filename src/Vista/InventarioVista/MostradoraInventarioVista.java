package Vista.InventarioVista;

import Modelo.Posicionable.Posicionable;
import Vista.Comunicador;
import Vista.CrafteoVista;
import Vista.JuegoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class MostradoraInventarioVista {

	public ImageView imagen;
	public int corrimientoX;
	public int corrimientoY;
	public Comunicador comunicador;
	public Posicionable posicionable;
	public JuegoVista juegoVista;


	public MostradoraInventarioVista(ImageView imagenMostradora, Posicionable posicionable, int corrimientoY, int corrimientoX, Comunicador comunicador, JuegoVista juegoVista) {
		this.imagen = imagenMostradora;
		this.posicionable = posicionable;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
	}

	public void setearOnDragDetected() {
		imagen.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Image imagenaextraer = imagen.getImage();

				if (imagenaextraer == null) {
					event.consume();
					return;
				}

				// Initiate a drag-and-drop gesture
				Dragboard dragboard = imagen.startDragAndDrop(TransferMode.MOVE);

				// Add the source text to the Dragboard
				ClipboardContent content = new ClipboardContent();
				content.putImage(imagenaextraer);
				dragboard.setContent(content);
				comunicador.asignarPosicionable(posicionable);
				comunicador.asignarPosicionMouse(event.getX()+corrimientoX, event.getY()+corrimientoY);
				event.consume();
			}
		});
	}

	public void setearOnDragDone() {
		imagen.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				TransferMode modeUsed = event.getTransferMode();

				if (modeUsed == TransferMode.MOVE) {
					imagen.setImage(null);
				}
				new CrafteoVista().actualizarTodo(juegoVista,comunicador);
				event.consume();
			}
		});
	}
}
