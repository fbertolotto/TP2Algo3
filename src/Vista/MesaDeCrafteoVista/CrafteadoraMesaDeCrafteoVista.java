package Vista.MesaDeCrafteoVista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.Comunicador;
import Vista.CrafteoVista;
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


	public CrafteadoraMesaDeCrafteoVista(ImageView imagencrafteada, int TAM_CELDA, int corrimientoX, int corrimientoY, Juego juego, JuegoVista juegoVista, Comunicador comunicador) {
		this.imagencrafteada = imagencrafteada;
		this.TAM_CELDA = TAM_CELDA;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.juego = juego;
	}

	public void setearOnDragDetected(Posicionable posicionable, Posicionable posicionablecrafteado) {
		imagencrafteada.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				System.out.println("Event on Source: drag detected");
				Image imagenaextraer = imagencrafteada.getImage();
				System.out.println("posicionable enviado: " + posicionable);

				if (imagenaextraer == null) {
					event.consume();
					return;
				}

				// Initiate a drag-and-drop gesture
				Dragboard dragboard = imagencrafteada.startDragAndDrop(TransferMode.COPY_OR_MOVE);

				// Add the source text to the Dragboard
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
				System.out.println("Event on Source: drag done");
				TransferMode modeUsed = event.getTransferMode();

				if (modeUsed == TransferMode.MOVE) {
					imagencrafteada.setImage(null);
				}
				new CrafteoVista().actualizarTodo(juegoVista,comunicador);
				event.consume();
			}
		});
	}
}
