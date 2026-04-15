package RelatorioJose.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelatorioService {

    public String processar(List<String> textos) {

        GerenciadorDeRelatorios g = new GerenciadorDeRelatorios();

        for (String texto : textos) {
            g.processarTexto(texto);
        }

        return "KM: " + g.calcularTotalKm() +
                " | Minutos: " + g.calcularMinutosExtras() +
                " | Valor: " + String.format("%.2f", g.calcularValorTotal());
    }
}
