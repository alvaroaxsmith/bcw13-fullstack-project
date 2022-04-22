package SoulCode.Servicos.Controllers;

import SoulCode.Servicos.Models.Servico;
import SoulCode.Servicos.Repositories.ServicoRepository;
import SoulCode.Servicos.Services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @Autowired
    ServicoRepository servicoRepository;

    // o método get serve para fazer buscar no banco de dados
    @GetMapping("/servico")
    public List<Servico> mostrarTodosServicos() {
        List<Servico> servicos = servicoService.mostrarTodosServicos();
        return servicos;
    }

    @GetMapping("/servico/{idServico}")
    public ResponseEntity<Servico> buscarUmServico(@PathVariable Integer idServico) {
        if(!servicoRepository.existsById(idServico)){
            return ResponseEntity.notFound().build();
        }
        Servico servico = servicoService.buscarUmServico(idServico);
        return ResponseEntity.ok().body(servico);

    }

    @DeleteMapping("/servico/{idServico}")
    public ResponseEntity<Servico> deletarUmServico(@PathVariable Integer idServico) {
        if(!servicoRepository.existsById(idServico)){
            return ResponseEntity.notFound().build();
        }
        servicoRepository.deleteById(idServico);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/card57")
    public List<Servico> card57(@RequestParam("idServico") Integer idServico,
                                @RequestParam("inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date inicial) {

        return servicoRepository.card57(idServico, inicial);
    }

    @GetMapping("/card56")
    public List<Servico> card56(@RequestParam("idServico") Integer idServico,
                                @RequestParam("inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date inicial,
                                @RequestParam("ultima") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date ultima) {

        return servicoRepository.card56(idServico, inicial, ultima);
    }

    @GetMapping("/card55")
    public List<Servico> card55(@RequestParam("inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date inicial,
                                @RequestParam("ultima") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date ultima) {

        return servicoRepository.card55(inicial, ultima);
    }


    @GetMapping("/card54")
    public List<Servico> card54(@RequestParam("idServico") Integer idServico) {

        return servicoRepository.card54(idServico);
    }


    @GetMapping("/card53")
    public List<Servico> card53(@RequestParam("inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date inicial) {

        return servicoRepository.card53(inicial);
    }


    @GetMapping("/card52")
    public List<Servico> card52(@RequestParam("idServico") Integer idServico,
                                @RequestParam("inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date inicial) {

        return servicoRepository.card52(idServico, inicial);
    }


}
