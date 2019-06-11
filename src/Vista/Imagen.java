package Vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class Imagen {

    public static void elegirImagenDeFondo(String ruta, Pane Contenedor){

        File file=new File(ruta);
        Image bgImage = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
        imageView.setImage(bgImage);
        imageView.setFitHeight(1080);
        imageView.setFitWidth(1920);
        Contenedor.getChildren().add(imageView);
    }
}
