package Vista;

import javafx.scene.media.AudioClip;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Cancion {

    public static AudioClip ReproducirCancion(String ruta, double volumen){
        AudioClip intro = new AudioClip(Main.class.getResource(ruta).toExternalForm());
        intro.setCycleCount(INDEFINITE);
        intro.setVolume(volumen);
        intro.play();
        return intro;
    }
}
