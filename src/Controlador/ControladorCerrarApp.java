package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;



public class ControladorCerrarApp implements EventHandler<ActionEvent> {

    private MediaPlayer music;
    private Stage stage;

    public ControladorCerrarApp(MediaPlayer music, Stage stage){
        this.music = music;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Se cierra la app");
        music.stop();
        stage.close();
    }
}
