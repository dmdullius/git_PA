package revisaopa_univates;
/**
 *
 * @author jonasdhein
 */
public class Conta {
    
    private String nome;
    private int conta;
    private Double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome2) {
        nome = nome2;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public void saque(Double valor){
        saldo = saldo - valor;
    }
    
    public void deposito(Double valor){
        saldo = saldo + valor;
    }
    
    double limite_d = 100000.00;

    /**
     * Get the value of limite_d(limite diario de transferencia e saque)
     *
     * @return the value of limite_d
     */
    public  double getLimite_d() {
        return limite_d;
    }

    /**
     * Set the value of limite_d
     *
     * @param limite_d new value of limite_d
     */
    public void setLimite_d(double limite_d) {
        this.limite_d = limite_d;
    }

    public String toString(){
        return "---\nConta: " + conta + "\n" +
               "Nome: " + nome + "\n" + 
               "Saldo: " + saldo + "\n" + 
                "limite diario: " + limite_d + "\n" +
               "\n---";
    }
    
}
