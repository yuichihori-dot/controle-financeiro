    import java.util.ArrayList;
    import java.util.List;

public class Main {
    public static void main(String[] args) {

        try{
            Transacao transacao1 = new Transacao("Erro", -59.99);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar transação: " + e.getMessage());
        }

        List<Transacao> transacoes = new ArrayList<>();
        transacoes.add(new Transacao("Uber", 25.9));
        transacoes.add(new Transacao("Mercado", 30.5));
        transacoes.add(new Transacao("Salario", 15.0));
        transacoes.forEach(Transacao::exibir);
    }
}