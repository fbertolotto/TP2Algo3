package Vista.PosicionablesVista;

import Modelo.Herramientas.Herramienta;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class PosicionableVista {
	protected String rutaImagen;
	protected Pane contenedor;
	public Posicionable posicionable;
	public BarraDurabilidad barraDurabilidad;


	public PosicionableVista(Pane container, Posicionable Posicionable) {
		this.posicionable = Posicionable;
		this.contenedor = container;
		barraDurabilidad = new BarraDurabilidad(contenedor);
	}

	public ImageView mostrarPosicionable(int corrimientoX, int corrimientoY, int TAM_CELDA, Posicion posicion, String Extra, boolean mostrarBarraDurabilidadHerramienta) {

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

		if (mostrarBarraDurabilidadHerramienta) { if (posicionable instanceof Herramienta) { barraDurabilidad.mostrarBarra(posicionable, imageView, corrimientoX, corrimientoY, TAM_CELDA, posicion); }
		} else { barraDurabilidad.mostrarBarra(posicionable, imageView, corrimientoX, corrimientoY, TAM_CELDA, posicion); }

		return imageView;
	}


	public String generadorRuta(String tipo,String nombre,String extra) {
		return "media/" + tipo + "/" + nombre + extra + ".png/";
	}


}
