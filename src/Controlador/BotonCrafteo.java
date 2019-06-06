package Controlador;

import Vista.Main;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonCrafteo extends Button {

    public  BotonCrafteo() {
        Image image = new Image(Main.class.getResource("images/mesa-crafteo-minecraft.jpg/").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        this.setGraphic(imageView);
        this.setLayoutX(1280);
        this.setLayoutY(1000);
    }
}


