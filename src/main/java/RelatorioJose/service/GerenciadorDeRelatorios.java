package RelatorioJose.service;


import RelatorioJose.model.Relatorio;

import java.util.ArrayList;
import java.util.HashSet;

public class GerenciadorDeRelatorios {

    private int minutosUteis = 18 * 60 + 5; // 18:05
    private ArrayList<Relatorio> listaDeRelatorios;
    private HashSet<String> datasProcessadas;

    public GerenciadorDeRelatorios() {
        listaDeRelatorios = new ArrayList<>();
        datasProcessadas = new HashSet<>();
    }

    public void processarTexto(String texto) {

        //  LIMPEZA DO TEXTO
        texto = texto.replaceAll("\\[.*?\\]", ""); // remove [20:17,...]
        texto = texto.replaceAll(".*?: Relatório", "Relatório"); // remove nome antes


        String[] blocos = texto.split("Relatório de");

        for (String bloco : blocos) {

            if (bloco.isBlank()) continue;

            int km = 0;
            int maiorMinuto = 0;
            String data = "";

            String[] linhas = bloco.split("\\n");

            for (String linha : linhas) {

                // DATA
                if (linha.contains("Data:")) {
                    data = linha.replace("Data:", "").trim();
                }

                // KM
                if (linha.contains("Total Rodado")) {
                    String valor = linha
                            .replace("Total Rodado:", "")
                            .replace("km", "")
                            .trim();

                    if (valor.matches("\\d+")) {
                        km = Integer.parseInt(valor);
                    }
                }

                // SAÍDA
                if (linha.contains("Saída:")) {

                    String valorSaida = linha
                            .replace("Saída:", "")
                            .trim();

                    // valida horário (aceita 8:05 e 08:05)
                    if (!valorSaida.matches("\\d{1,2}:\\d{2}")) continue;

                    String[] partes = valorSaida.split(":");

                    int h = Integer.parseInt(partes[0]);
                    int m = Integer.parseInt(partes[1]);

                    int totalMin = h * 60 + m;

                    if (totalMin > maiorMinuto) {
                        maiorMinuto = totalMin;
                    }
                }
            }

            // valida bloco
            if (km == 0 || data.isEmpty()) continue;

            // evita duplicado por data
            if (datasProcessadas.contains(data)) continue;

            datasProcessadas.add(data);

            Relatorio r = new Relatorio(km, maiorMinuto, data);
            listaDeRelatorios.add(r);
        }
    }

    public int calcularTotalKm() {
        int total = 0;

        for (Relatorio r : listaDeRelatorios) {
            total += r.getTotalRodado();
        }

        return total;
    }

    public int calcularMinutosExtras() {
        int total = 0;

        for (Relatorio r : listaDeRelatorios) {

            int extra = r.getMaiorMinuto() - minutosUteis;

            if (extra > 0) {
                total += extra;
            }
        }

        return total;
    }

    public double calcularValorTotal() {
        double valorPorMinuto = 33.0 / 60;
        return calcularMinutosExtras() * valorPorMinuto;
    }
}