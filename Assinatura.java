package entity;

public class Assinatura {

    private Assinante assinante;
    private Plano plano;
    private Produto produto;
    private Endereco endereco;
    private Pagamento pagamento;

    public Assinatura(Assinante assinante, Plano plano, Produto produto, Endereco endereco, Pagamento pagamento) {
        this.assinante = assinante;
        this.plano = plano;
        this.produto = produto;
        this.endereco = endereco;
        this.pagamento = pagamento;
    }

    public String gerarResumo() {
        return "Assinante: " + assinante.getNome() +
                " | Celular: " + assinante.getCelular() +
                " | Plano: " + plano.getNome() +
                " | Produto: " + produto.getNome() +
                " | Endereço: " + endereco.getDescricao() +
                " | Pagamento aprovado: " + pagamento.isAprovado();
    }
}