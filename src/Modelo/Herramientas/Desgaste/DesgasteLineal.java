package Modelo.Herramientas.Desgaste;

public class DesgasteLineal extends Desgaste{
    private float divisor = 1;

    @Override
    public void setDivisor(float numero) {
        this.divisor = numero;
    }

    @Override
    public float desgastar(float valor) {
        return valor/this.divisor;
    }

    @Override
    public void setUsosmaximos(int usosmax) { return;}
}
