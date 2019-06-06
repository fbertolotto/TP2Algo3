package Vista;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Grilla {

    public void MostrarGrilla(Pane contenedor, int PosX, int PosY,Color ColorRelleno,Color ColorLinea, int TAM_CELDA, int Ancho, int Alto){
        Rectangle relleno = new Rectangle(TAM_CELDA * (Ancho+1), TAM_CELDA *(Alto+1));
        relleno.setLayoutX(PosX);
        relleno.setLayoutY(PosY);
        relleno.setFill(ColorRelleno);
        relleno.setOpacity(0.1);
        contenedor.getChildren().add(relleno);

        for (int j = 0; j <= Ancho + 1; j++) {
            Line line = new Line(PosX + j * TAM_CELDA, PosY, PosX +(j * TAM_CELDA), PosY + (Alto+1) * TAM_CELDA);
            line.setStroke(ColorLinea);
            line.setOpacity(0.5);
            contenedor.getChildren().add(line);
        }
        for (int i = 0; i <= Alto + 1; i++) {
            Line line = new Line(PosX , PosY + i * TAM_CELDA, PosX+(Ancho + 1) * TAM_CELDA, PosY + i * TAM_CELDA);
            line.setStroke(ColorLinea);
            line.setOpacity(0.5);
            contenedor.getChildren().add(line);
        }
    }
}
