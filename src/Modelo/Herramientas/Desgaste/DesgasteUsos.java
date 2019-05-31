package Modelo.Herramientas.Desgaste;

public class DesgasteUsos extends Desgaste {
    private int usos = 0;
    private int usosmaximos = 0;

    @Override
    public void setUsosmaximos(int usosmax) {
        this.usosmaximos = usosmax;
    }

    @Override
    public float desgastar(float numero) {
        this.usos++;
        if (this.usos == this.usosmaximos) return numero;
        return 0;
    }
    @Override
    public void setDivisor(float numero){ return; }
}