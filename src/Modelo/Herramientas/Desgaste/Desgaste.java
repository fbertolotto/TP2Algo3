package Modelo.Herramientas.Desgaste;

public abstract class Desgaste {

    public abstract void setUsosmaximos(int usosmax);
    public abstract float desgastar(float numero);
    public abstract void setDivisor(float numero);
}
