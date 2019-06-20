package Vista.MesaDeCrafteoVista;

import Modelo.Juego.Juego;
import Modelo.Posicionable.Posicionable;
import Vista.Comunicador;
import Vista.JuegoVista;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class MostradoraMesaDeCrafteoVista {

	public int TAM_CELDA;
	public int corrimientoX;
	public int corrimientoY;
	public ImageView imagen;
	public Comunicador comunicador;
	private JuegoVista juegoVista;
	public Juego juego;


	public MostradoraMesaDeCrafteoVista(ImageView imagenMostradora, int TAM_CELDA, int corrimientoX, int corrimientoY, Juego juego, JuegoVista juegoVista, Comunicador comunicador) {
		this.imagen = imagenMostradora;
		this.TAM_CELDA = TAM_CELDA;
		this.corrimientoX = corrimientoX;
		this.corrimientoY = corrimientoY;
		this.comunicador = comunicador;
		this.juegoVista = juegoVista;
		this.juego = juego;
		imagen.setFitWidth(100);
		imagen.setFitHeight(100);
	}

	public void setearOnDragDetected(Posicionable posicionable) {
		imagen.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Image imagenaextraer = imagen.getImage();

				if (imagenaextraer == null) {
					event.consume();
					return;
				}


				Dragboard dragboard = imagen.startDragAndDrop(TransferMode.COPY_OR_MOVE);

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
