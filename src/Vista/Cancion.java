package Vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Cancion {

    public static MediaPlayer reproducirCancion(String ruta, double volumen){
        Media media = new Media(Main.class.getResource(ruta).toExternalForm());
        MediaPlayer player = new MediaPlayer(media);
        player.setCycleCount(INDEFINITE);
        player.setVolume(volumen);
        player.play();
        return player ;
    }
}
