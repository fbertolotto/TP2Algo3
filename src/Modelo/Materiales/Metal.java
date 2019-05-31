package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Metal extends Material {

    public Metal() {
        this.durabilidad = 50;
    }

    public void desgastar(Herramienta herramienta) {
        if (PicoDePiedra.class.isAssignableFrom(herramienta.getClass())) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }
}
