package persistence;

import entity.Assinatura;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AssinaturaRepository {

    public void salvar(Assinatura assinatura) {
        try {
            String nomeArquivo = gerarNomeArquivoPorProduto(assinatura.getNomeProduto());

            FileWriter arquivo = new FileWriter(nomeArquivo, true);
            PrintWriter gravador = new PrintWriter(arquivo);

            gravador.println(assinatura.gerarResumo());

            gravador.close();
            arquivo.close();

        } catch (IOException e) {
            System.out.println("Erro ao salvar assinatura.");
        }
    }

    private String gerarNomeArquivoPorProduto(String nomeProduto) {
        String produtoSemQuantidade = nomeProduto
                .toLowerCase()
                .trim()
                .replaceAll("^[0-9]+\\s*", "");

        String produtoFormatado = produtoSemQuantidade
                .replaceAll("\\s+", "_")
                .replaceAll("[^a-z0-9_áàâãéèêíïóôõöúçñ-]", "");

        return "assinaturas_" + produtoFormatado + ".txt";
    }
}
