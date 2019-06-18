package Controlador;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class BotonCambiarHerramienta extends Button {

	public BotonCambiarHerramienta() {
		File file = new File("media/images/cambiarHerramienta.png/");
		Image image = new Image(file.toURI().toString());
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(35);
		imageView.setFitWidth(35);
		this.setGraphic(imageView);
		this.setLayoutX(1859);
		this.setLayoutY(1010);
	}
}
