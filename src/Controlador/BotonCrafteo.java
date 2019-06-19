package Controlador;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class BotonCrafteo extends Button {

    public  BotonCrafteo() {
        File file = new File("media/images/mesa-crafteo-minecraft.jpg/");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        this.setGraphic(imageView);
        this.setLayoutX(1285);
        this.setLayoutY(991);
    }
}


