
/**
 * Uma conta bancaria possui um saldo que pode ser 
 * alterado por depositos e saques.
 *
 * @author Cay Horstmann
 * @version 2022-06-17
 */
public class BankAccount
{
    private double balance;

    /**
     * Controi uma conta bancaria com saldo zero.
     */
    public BankAccount()
    {
        this.balance = 0.0;
    }

    /**
     * Controi uma conta bancaria com um saldo determinado.
     * @param amount valor inicial do saldo
     */
    public BankAccount(double amount)
    {
        if (amount < 0.0) {
            throw new IllegalArgumentException("O valor a retirar deve ser maior do que R$ 0,00!");
        }
        this.balance = amount;
    }
    
    
    /**
     * Obtem o saldo atual da conta bancaria.
     * @return    o saldo atual da conta bancaria
     */
    public double getBalance()
    {
        return this.balance;
    }
    
    /**
     * Deposita um valor na conta bancaria.
     * @param amount o valor a depositar
     */
    public void deposit(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("O valor a depositar deve ser maior do que R$ 0,00!");
        }
        this.balance = this.balance + amount;
    }

    /**
     * Retira um valor da conta bancaria.
     * @param amount o valor a retirar
     */
    public void withdraw(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("O valor a retirar deve ser maior do que R$ 0,00!");
        }
        if (this.balance < amount) {
            throw new IllegalArgumentException("SALDO INSUFICIENTE! (withdraw)");
        }
        this.balance = this.balance - amount;
    }  

    /**
     * Transfere um valor entre contas.
     * @param toAccount a conta destino
     * @param amount o valor a retirar
     */
    public void transferTo(BankAccount toAccount, double amount) {
        if (toAccount == null) {
            throw new IllegalArgumentException("A conta destino nao foi informada (null)!");
        }
        if (amount <= 0.0) {
            throw new IllegalArgumentException("O valor a retirar deve ser maior do que R$ 0,00!");
        }
        if (this.balance < amount) {
            throw new IllegalArgumentException("SALDO INSUFICIENTE! (transferTo)");
        }
        this.withdraw(amount);
        toAccount.deposit(amount);
    }

}













