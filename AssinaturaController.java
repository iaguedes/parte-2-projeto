package controller;

import entity.*;
import persistence.AssinaturaRepository;

public class AssinaturaController {

    private Plano plano;
    private Produto produto;
    private Endereco endereco;
    private Pagamento pagamento;
    private AssinaturaRepository repository = new AssinaturaRepository();

    public boolean validarCelular(String celular) {
        return celular != null && celular.length() >= 10;
    }

    public void selecionarPlano(String nomePlano) {
        this.plano = new Plano(nomePlano);
    }

    public void escolherProduto(String nomeProduto) {
        this.produto = new Produto(nomeProduto);
    }

    public void informarEndereco(String enderecoTexto) {
        this.endereco = new Endereco(enderecoTexto);
    }

    public boolean realizarPagamento(String numeroCartao) {
        this.pagamento = new Pagamento(numeroCartao);
        return pagamento.autorizarPagamento();
    }

    public void confirmarAssinatura(String nome, String celular) {
        Assinante assinante = new Assinante(nome, celular);

        String[] produtosEscolhidos = produto.getNome().split(",");

        for (String nomeProduto : produtosEscolhidos) {
            nomeProduto = nomeProduto.trim();

            if (!nomeProduto.isEmpty()) {
                Produto produtoSeparado = new Produto(nomeProduto);
                Assinatura assinatura = new Assinatura(assinante, plano, produtoSeparado, endereco, pagamento);
                repository.salvar(assinatura);
            }
        }
    }
}
