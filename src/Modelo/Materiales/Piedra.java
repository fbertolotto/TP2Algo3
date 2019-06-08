package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Piedra extends Material {

    public Piedra() {
        this.durabilidad = 30;
    }

    @Override
    public void desgastar(Herramienta herramienta) {
        if (Pico.class.isAssignableFrom(herramienta.getClass())) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }
}
