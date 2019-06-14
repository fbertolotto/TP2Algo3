package Vista.PosicionablesVista;

import Modelo.Posicionable.Posicionable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class PosicionableVista {
	protected String rutaImagen;
	protected Pane contenedor;
	public Posicionable posicionable;
	public int TAM_CELDA = 80;;

	public PosicionableVista(Pane container, Posicionable Posicionable){
		this.posicionable = Posicionable;
		this.contenedor = container;
	}


	public ImageView mostrarPosicionable(int corrimientoX,int corrimientoY){
		File file = new File(posicionable.rutaImagen);
		Image bgImage = new Image(file.toURI().toString());
		ImageView imageView = new ImageView();
		imageView.setImage(bgImage);
		imageView.setFitHeight(TAM_CELDA);
		imageView.setFitWidth(TAM_CELDA);
		imageView.setLayoutX(posicionable.getPosicion().getFila() * TAM_CELDA + corrimientoX);
		imageView.setLayoutY(posicionable.getPosicion().getColumna() * TAM_CELDA + corrimientoY);
		contenedor.getChildren().add(imageView);
		return imageView;
	}


}
