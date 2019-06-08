package Controlador;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;


public class ControladorVolumen implements EventHandler<ActionEvent>  {
    private Pane contenedor;
    private Button BotondeVolumen;
    private MediaPlayer musica;
    private Slider slider;

    public ControladorVolumen(Button boton, Pane contenedor , MediaPlayer musicadeljuego){
        this.contenedor = contenedor;
        this.BotondeVolumen = boton;
        this.musica = musicadeljuego;
        Slider BarradeVolumen = new Slider(0, 1, musica.getVolume());
        BarradeVolumen.setOrientation(Orientation.VERTICAL);
        BarradeVolumen.setLayoutX(520);
        BarradeVolumen.setLayoutY(850);
        musica.volumeProperty().bind(BarradeVolumen.valueProperty());
        this.slider = BarradeVolumen;



    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Abrir Volumen.");
        this.contenedor.getChildren().add(slider);
        slider.setVisible(true);

        BotondeVolumen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("Cerrar Volumen.");
                slider.setVisible(false);
                ControladorVolumen  controladorVolumen = new ControladorVolumen(BotondeVolumen, contenedor, musica);
                BotondeVolumen.setOnAction(controladorVolumen );
            }
        });
    }
}

