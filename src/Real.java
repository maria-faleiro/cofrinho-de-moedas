
//para indicar que uma classe extende da outra usa se o 'extends e o nome da classe que vai se referenciar'
public class Real extends Moeda {

    public Real(double valorInicial) {
        this.valor = valorInicial;
    }

    @Override
    public void info() {

        System.out.println("Real - " + valor);
    }

    @Override
    public double converter() {
        return this.valor;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this.getClass() != objeto.getClass()) {
            return false;
        }

        Real objetoDeReal = (Real) objeto;

        if (this.valor != objetoDeReal.valor) {
            return false;
        }

        return true;
    }
}
