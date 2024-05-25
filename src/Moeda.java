
public abstract class Moeda {
    // Deixei como protected pois as classes filhas precisam ter acesso a classe mãe
    protected double valor;

    public abstract void info();

    public abstract double converter();
}
