package entity;

public class Pagamento {

    private String numeroCartao;
    private boolean aprovado;

    public Pagamento(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public boolean autorizarPagamento() {
        if (numeroCartao != null && numeroCartao.length() >= 12) {
            aprovado = true;
        } else {
            aprovado = false;
        }

        return aprovado;
    }

    public boolean isAprovado() {
        return aprovado;
    }
}