package SistemaBancario.model;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(int numeroConta, double saldo, String tipoConta, Cliente titular, double limite) {
        super(numeroConta, saldo, tipoConta, titular);
        this.limite = limite;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        if (valor > getSaldo() + getLimite()){
            throw new IllegalArgumentException("Saldo insuficiente");
                        }else {
                            setSaldo(getSaldo() - valor); 
                        }

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
