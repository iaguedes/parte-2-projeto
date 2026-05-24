package persistence;

import entity.Assinatura;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AssinaturaRepository {

    public void salvar(Assinatura assinatura) {
        try {
            FileWriter arquivo = new FileWriter("assinaturas.txt", true);
            PrintWriter gravador = new PrintWriter(arquivo);

            gravador.println(assinatura.gerarResumo());

            gravador.close();
            arquivo.close();

        } catch (IOException e) {
            System.out.println("Erro ao salvar assinatura.");
        }
    }
}