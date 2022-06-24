
import java.util.Scanner;

/**
 * A classe Main e um aplicativo que permite
 * gerenciar contas bancarias.
 * 
 * @author marco.mangan@pucrs.br
 * @author 2022-06-24
 */
public class Main
{
    
    /**
     * Gerencia operaçoes sobre as contas bancarias.
     * 
     * @param args nao utilizado
     */
    public static void main(String[] args) {
        BankAccount[] contas = { 
                new BankAccount(),
                new BankAccount(100.00),
                new BankAccount(1_000.00)
            };

        Scanner sc = new Scanner(System.in);
        int op = 0;
        int origem;
        int destino;
        double valor;

        do {          
            
            System.out.println("\n\t        MENU");
            System.out.println("\t        ====");
            System.out.println("\t1 - Consultar saldo");
            System.out.println("\t2 - Depositar");
            System.out.println("\t3 - Retirar");
            System.out.println("\t4 - Transferir");
            System.out.println("\t9 - Sair");
            op = sc.nextInt();

            switch(op) {
                case 1:
                    System.out.println("Consulta de saldo");
                    System.out.print("\tInforme a conta: ");
                    origem = sc.nextInt();
                    System.out.println(contas[origem].getBalance());
                    break;
                case 2:
                    System.out.println("Depósito");
                    System.out.print("\tInforme a conta: ");
                    origem = sc.nextInt();
                    System.out.print("\tInforme o valor: ");
                    valor = sc.nextDouble();
                    contas[origem].deposit(valor);
                    break;
                case 3:
                    System.out.println("Retirada");
                    System.out.print("\tInforme a conta: ");
                    origem = sc.nextInt();
                    System.out.print("\tInforme o valor: ");
                    valor = sc.nextDouble();
                    contas[origem].withdraw(valor);
                    break;
                case 4:
                    System.out.println("Transferência");
                    System.out.print("\tInforme a origem: ");
                    origem = sc.nextInt();
                    System.out.print("\tInforme o destino: ");
                    destino = sc.nextInt();
                    System.out.print("\tInforme o valor: ");
                    valor = sc.nextDouble();
                    contas[origem].transferTo(contas[destino], valor);                    
                    break;                    
            }
        } while (op != 9);
        System.out.println("** FIM **");
    }
}
