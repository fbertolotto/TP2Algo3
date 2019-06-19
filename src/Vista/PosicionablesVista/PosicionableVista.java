package Vista.PosicionablesVista;

import Modelo.Herramientas.Herramienta;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.Material;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class PosicionableVista {
	protected String rutaImagen;
	protected Pane contenedor;
	public Posicionable posicionable;
	public ProgressBar barraDurabilidad = new ProgressBar();

	public PosicionableVista(Pane container, Posicionable Posicionable) {
		this.posicionable = Posicionable;
		this.contenedor = container;
	}

	public ImageView mostrarPosicionable(int corrimientoX, int corrimientoY, int TAM_CELDA, Posicion posicion, String Extra) {
		String ruta = generadorRuta("images", posicionable.getNombre(), Extra);
		File file = new File(ruta);
		Image bgImage = new Image(file.toURI().toString());
		ImageView imageView = new ImageView();
		imageView.setImage(bgImage);
		imageView.setFitHeight(TAM_CELDA);
		imageView.setFitWidth(TAM_CELDA);
		imageView.setLayoutX(posicion.getColumna() * TAM_CELDA + corrimientoX);
		imageView.setLayoutY(posicion.getFila() * TAM_CELDA + corrimientoY);
		contenedor.getChildren().add(imageView);
		contenedor.getChildren().add(barraDurabilidad);
		barraDurabilidad.setVisible(false);
		if(!(posicionable instanceof Jugador)) {
			imageView.setOnMouseEntered(e -> {
				if(posicionable instanceof Herramienta) {
					double durabilidad = ((double) ((Herramienta) posicionable).getDurabilidad()) / ((double) 100);
					barraDurabilidad.setProgress(durabilidad);
				}
				if(posicionable instanceof Material) barraDurabilidad.setProgress(((Material) posicionable).getDurabilidad());
				barraDurabilidad.setLayoutX(posicion.getColumna() * TAM_CELDA + corrimientoX);
				barraDurabilidad.setLayoutY(posicion.getFila() * TAM_CELDA + corrimientoY);
				barraDurabilidad.setVisible(true);
				e.consume();
			});
			imageView.setOnMouseExited(e ->{
				barraDurabilidad.setVisible(false);
				e.consume();
			});
		}
		return imageView;
	}


	public String generadorRuta(String tipo,String nombre,String extra) {
		return "media/" + tipo + "/" + nombre + extra + ".png/";
	}


}
