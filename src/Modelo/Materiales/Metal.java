package Modelo.Materiales;

import Modelo.Herramientas.*;

public class Metal extends Material {

    public Metal() {
        this.durabilidad = 50;
    }

    @Override
    public void desgastar(Herramienta herramienta) {
        if (PicoDePiedra.class == herramienta.getClass()) {
            this.durabilidad -= herramienta.getFuerza();
        }
    }
}
