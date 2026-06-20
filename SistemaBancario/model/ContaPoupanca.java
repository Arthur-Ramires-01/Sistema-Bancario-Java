package SistemaBancario.model;

public class ContaPoupanca extends Conta {
    

    private double taxaRendimento;
    private int diaAniversario;

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }
    public ContaPoupanca(int numeroConta, double saldo, String tipoConta, Cliente titular) {
        super(numeroConta, saldo, tipoConta, titular);
        
    }
    @Override
    public void sacar(double valor) {
       if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        if (valor > getSaldo()){
            throw new IllegalArgumentException("Saldo insuficiente para saque");
        } else {
            setSaldo(getSaldo() - valor);
        }
    } 

    public void renderJuros(){
      setSaldo(getSaldo() + (getSaldo() * taxaRendimento));

    }


    public double getTaxaRendimento() {
        return taxaRendimento;
    }
    
    public int getDiaAniversario() {
        return diaAniversario;
    }

  
}
