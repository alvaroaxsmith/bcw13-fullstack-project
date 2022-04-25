package SoulCode.Servicos.Controllers;

import SoulCode.Servicos.Models.Orcamento;
import SoulCode.Servicos.Repositories.OrcamentoRepository;
import SoulCode.Servicos.Services.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@CrossOrigin
@RestController
@RequestMapping("orcamentos")
public class OrcamentoController {

    @Autowired
    OrcamentoService orcamentoService;

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @PostMapping("/inserirOrcamento")
    public ResponseEntity<Orcamento> inserirOrcamento(@RequestBody Orcamento orcamento){
        orcamento = orcamentoService.inserirOrcamento(orcamento);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orcamento.getIdOrcamento()).toUri();
        return ResponseEntity.created(novaUri).build();
    }

    @GetMapping("/orcamento/{idOrcamento}")
    public ResponseEntity<Orcamento> mostrarUmOrcamento(@PathVariable Integer idOrcamento){
        if (!orcamentoRepository.existsById(idOrcamento)){
            ResponseEntity.notFound().build();
        }
        Orcamento orcamento = orcamentoService.mostrarUmOrcamento(idOrcamento);
        return ResponseEntity.ok().body(orcamento);
    }

    @PutMapping("/orcamento/{idOrcamento}")
    public ResponseEntity<Orcamento> editarOrcamento(@PathVariable Integer idOrcamento,
                                                         @RequestBody Orcamento orcamento){
        if (!orcamentoRepository.existsById(idOrcamento)){
            ResponseEntity.notFound().build();
        }
        orcamento.setIdOrcamento(idOrcamento);
        orcamento = orcamentoService.editarOrcamento(orcamento);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/orcamento/{idOrcamento}")
    public ResponseEntity<Orcamento> deletarUmOrcamento(@PathVariable Integer idOrcamento){
        if (!orcamentoRepository.existsById(idOrcamento)){
            ResponseEntity.notFound().build();
        }
        orcamentoRepository.deleteById(idOrcamento);
        return ResponseEntity.noContent().build();
    }




}
