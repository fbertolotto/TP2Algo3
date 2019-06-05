package Controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import static Vista.Cancion.reproducirCancion;
import static Vista.Imagen.elegirImagenDeFondo;

public class ControladorCambiarAMenu implements EventHandler<ActionEvent> {

    private AudioClip music;
    private Stage stage;

    public ControladorCambiarAMenu(AudioClip musica, Stage stage){
        this.music = musica;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        System.out.println("Entrando al mundo...");
        Pane ContenedorJuego = new Pane();
        Scene escenaJuego = new Scene(ContenedorJuego, 1920, 1080);

        elegirImagenDeFondo("images/gamebackground.jpg/", ContenedorJuego);


        music.stop();
        AudioClip musicadeljuego = reproducirCancion("audio/minecraft.mp3/", 1.0);

        stage.setScene(escenaJuego);
        stage.setFullScreen(true);

        BotonGenerico botonexit = new BotonExit();
        ContenedorJuego.getChildren().add(botonexit);

       stage.show();

        ControladorCerrarApp miBotonEventHandler = new ControladorCerrarApp(musicadeljuego,stage);

        botonexit.setOnAction(miBotonEventHandler );
    }
}
