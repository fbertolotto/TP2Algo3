package Modelo.Herramientas.Desgaste;

public abstract class Desgaste {

    protected int usosmaximos = 0;
    protected float divisor = 1;

    public abstract float desgastar(float numero);

    public void setUsosmaximos(int usosmax) {
        this.usosmaximos = usosmax;
    }

    public void setDivisor(float numero) {
        this.divisor = numero;
    }
}
