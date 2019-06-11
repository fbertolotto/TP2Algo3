package Vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Cancion {

    public static MediaPlayer reproducirCancion(String ruta, double volumen){
        File file = new File(ruta);
        Media media = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setCycleCount(INDEFINITE);
        player.setVolume(volumen);
        player.play();
        return player ;
    }
}
