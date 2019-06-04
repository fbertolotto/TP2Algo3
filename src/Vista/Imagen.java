package Vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Imagen {

    public static void ElegirImagenDeFondo(String ruta, Pane Contenedor){

        Image bgImage = new Image(Main.class.getResource(ruta).toExternalForm());
        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(1080);
        imageView.setFitWidth(1920);
        Contenedor.getChildren().add(imageView);
    }
}
