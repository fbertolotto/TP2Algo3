package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Piedra extends Material {

    public Piedra() {
        this.durabilidad = 30;
    }

    public void desgastar(Pico pico) { this.durabilidad -= pico.getFuerza();}

}
