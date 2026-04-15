package RelatorioJose.controller;

import RelatorioJose.service.RelatorioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService service;


    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @PostMapping
    public String processar(@RequestBody List<String> relatorios) {
        return service.processar(relatorios);
    }
}