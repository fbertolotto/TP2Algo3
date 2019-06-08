package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import static Vista.Juego.empezarJuego;

public class ControladorCambiarAMenu implements EventHandler<ActionEvent> {

    private MediaPlayer music;
    private Stage stage;

    public ControladorCambiarAMenu(MediaPlayer musica, Stage stage){
        this.music = musica;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Entrando al mundo...");
        music.stop();
        empezarJuego(stage);

    }
}
