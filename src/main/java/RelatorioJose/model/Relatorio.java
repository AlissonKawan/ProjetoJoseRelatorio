package RelatorioJose.model;

public class Relatorio {
    private int totalRodado;
    private String dataRelatorio;
    private int maiorMinuto;

    public Relatorio(int totalRodado, int maiorMinuto, String dataRelatorio) {
        this.totalRodado = totalRodado;
        this.maiorMinuto = maiorMinuto;
        this.dataRelatorio = dataRelatorio;
    }

    public String getDataRelatorio() {
        return dataRelatorio;
    }

    public int getMaiorMinuto() {
        return maiorMinuto;
    }

    public int getTotalRodado() {
        return totalRodado;
    }


}
