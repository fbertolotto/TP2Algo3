package Vista.PosicionablesVista;

import Modelo.Herramientas.Herramienta;
import Modelo.Jugador.Jugador;
import Modelo.Materiales.Material;
import Modelo.Posicionable.Posicionable;
import Modelo.Tablero.Posicion;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BarraDurabilidad {

	public ProgressBar barraDurabilidad;
	public Pane contenedor;
	private double durabilidad = 0;

	public BarraDurabilidad(Pane contenedor) {
		this.contenedor = contenedor;
		barraDurabilidad = new ProgressBar();
	}

	public void mostrarBarra(Posicionable posicionable, ImageView imageView, int corrimientoX, int corrimientoY, int TAM_CELDA, Posicion posicion) {

		contenedor.getChildren().add(barraDurabilidad);
		barraDurabilidad.setVisible(false);

		if(!(posicionable instanceof Jugador)) {
			imageView.setOnMouseEntered(e -> {
				if(posicionable instanceof Herramienta) { durabilidad = ((double)((Herramienta) posicionable).getDurabilidad()) / ((double)((Herramienta) posicionable).getDurabilidadInicial()); }
				if(posicionable instanceof Material) { durabilidad = ((double)((Material) posicionable).getDurabilidad()) / ((double)((Material) posicionable).getDurabilidadInicial()); }
				barraDurabilidad.setProgress(durabilidad); //Siempre va a tener un valor.
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
	}
}
