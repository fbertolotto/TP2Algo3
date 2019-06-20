package Vista;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Grilla {

    private ArrayList<Line> lineas;
    private Pane contenedor;
    private Rectangle relleno;

    public Grilla(Pane contenedor, int PosX, int PosY,Color ColorRelleno,Color ColorLinea, int TAM_CELDA, int Ancho, int Alto, double Opacidad, double StrokeWudth){
        this.lineas = new ArrayList<Line>();
        this.contenedor = contenedor;

        Rectangle relleno = new Rectangle(TAM_CELDA * (Ancho+1), TAM_CELDA *(Alto+1));
        relleno.setLayoutX(PosX);
        relleno.setLayoutY(PosY);
        relleno.setFill(ColorRelleno);
        relleno.setOpacity(Opacidad);
        this.relleno = relleno;

        for (int j = 0; j <= Ancho + 1; j++) {
            Line line = new Line(PosX + j * TAM_CELDA, PosY, PosX +(j * TAM_CELDA), PosY + (Alto+1) * TAM_CELDA);
            line.setStroke(ColorLinea);
            line.setOpacity(Opacidad);
            line.setStrokeWidth(StrokeWudth);
            lineas.add(line);
        }
        for (int i = 0; i <= Alto + 1; i++) {
            Line line = new Line(PosX , PosY + i * TAM_CELDA, PosX+(Ancho + 1) * TAM_CELDA, PosY + i * TAM_CELDA);
            line.setStroke(ColorLinea);
            line.setOpacity(Opacidad);
            line.setStrokeWidth(StrokeWudth);
            lineas.add(line);
        }
        actualizar();
    }

    public void actualizar() {
        contenedor.getChildren().add(relleno);
        for (Line linea : lineas) { contenedor.getChildren().add(linea); }
    }
}
