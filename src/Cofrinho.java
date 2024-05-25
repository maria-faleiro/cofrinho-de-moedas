
import java.util.ArrayList;

public class Cofrinho {

    private ArrayList<Moeda> listaMoedas;

    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    public void adicionar(Moeda moeda) {
        this.listaMoedas.add(moeda);
    }

    public boolean remover(Moeda moeda) {
        return this.listaMoedas.remove(moeda);
    }

    public void listaMoedas() {

        if (this.listaMoedas.isEmpty()) {
            System.out.println("Sem moedas no cofrinho! ): ");
            return;
        }

        for (Moeda moeda : this.listaMoedas) {
            moeda.info();
        }
    }

    public double totalConvertido() {
        if (this.listaMoedas.isEmpty()) {
            return 0;
        }

        double valorAcumulado = 0;

        for (Moeda moeda : this.listaMoedas) {// precisa acumular os valores para depois exibir
            valorAcumulado = valorAcumulado + moeda.converter();
        }

        return valorAcumulado;
    }
}
