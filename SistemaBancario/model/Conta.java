package SistemaBancario.model;

public abstract class Conta {
    private int numeroConta;
    private double saldo;
    private String tipoConta;
    private Cliente titular;

    public Conta(int numeroConta, double saldo, String tipoConta, Cliente titular){
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.titular = titular;
    }





public abstract void sacar(double valor);


public void depositar (double valor) {
 if (valor > 0) {
    this.saldo += valor;
 }
}


public void setNumeroConta(int numeroConta) {
    this.numeroConta = numeroConta;
}





public void setSaldo(double saldo) {
    this.saldo = saldo;
}





public void setTipoConta(String tipoConta) {
    this.tipoConta = tipoConta;
}





public void setTitular(Cliente titular) {
    this.titular = titular;
}





public int getNumeroConta() {
    return numeroConta;
}





public double getSaldo() {
    return saldo;
}





public String getTipoConta() {
    return tipoConta;
}





public Cliente getTitular() {
    return titular;
}




}