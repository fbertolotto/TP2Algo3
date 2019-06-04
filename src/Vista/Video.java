package Vista;

import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Video {

    public static void ElegirVideoDeFondo(String ruta, Pane Contenedor){
        Media media = new Media(Main.class.getResource(ruta).toExternalForm());
        MediaPlayer player = new MediaPlayer(media);
        player.setOnError(() -> System.out.println("error player"));
        player.setAutoPlay(true);
        player.setCycleCount(1000);
        MediaView view = new MediaView(player);
        Contenedor.getChildren().add(view);
        System.out.println("Exito");
    }

}
