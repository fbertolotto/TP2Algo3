package Vista;

import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class Video {

    public static void elegirVideoDeFondo(String ruta, Pane Contenedor){
        File file = new File(ruta);
        Media media = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setOnError(() -> System.out.println("error player"));
        player.setAutoPlay(true);
        player.setCycleCount(1000);
        MediaView view = new MediaView(player);
        Contenedor.getChildren().add(view);
    }
}
