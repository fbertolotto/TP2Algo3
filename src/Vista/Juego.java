package Vista;


import Controlador.ControladorAbrirCrafteo;
import Controlador.BotonCrafteo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import static Vista.Cancion.reproducirCancion;
import static Vista.Imagen.elegirImagenDeFondo;

public class Juego {

    public static void empezarJuego(Stage stage){

    Pane ContenedorJuego = new Pane();
    Scene escenaJuego = new Scene(ContenedorJuego, 1920, 1080);

    elegirImagenDeFondo("images/gamebackground.jpg/", ContenedorJuego);
    AudioClip musicadeljuego = reproducirCancion("audio/minecraft.mp3/", 1.0);

    escenaJuego.setOnKeyPressed(e -> {
        if (e.getCode() == KeyCode.ESCAPE) {
            System.out.println("Cerrando App");
            musicadeljuego.stop();
            stage.close();
        }
        });

    new Grilla().MostrarGrilla(ContenedorJuego, 0 ,0, Color.DARKGRAY, 40, 47,24);
    new Grilla().MostrarGrilla(ContenedorJuego, 560 ,1000, Color.GRAY,80, 9,1);
    Button Botoncrafteo = new BotonCrafteo();
    ContenedorJuego.getChildren().add(Botoncrafteo);
    ControladorAbrirCrafteo controladorAbrirCrafteo = new ControladorAbrirCrafteo(Botoncrafteo, ContenedorJuego);
    Botoncrafteo.setOnAction(controladorAbrirCrafteo);
    stage.setScene(escenaJuego);
    stage.setFullScreen(true);
    stage.show();


    }

}
