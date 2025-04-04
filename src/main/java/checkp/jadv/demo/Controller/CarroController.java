package checkp.jadv.demo.Controller;

import checkp.jadv.demo.domainmodel.Carro;
import checkp.jadv.demo.Service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping
    public List<Carro> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable UUID id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new NoSuchElementException("Carro com ID " + id + " não encontrado."));
    }

    @GetMapping("/potencia")
    public List<Carro> listarPorPotencia() {
        return service.listarPorPotencia();
    }

    @GetMapping("/economia")
    public List<Carro> listarPorEconomia() {
        return service.listarPorEconomia();
    }

    @GetMapping("/eletricos")
    public List<Carro> listarEletricos() {
        return service.listarEletricos();
    }

    @PostMapping
    public Carro adicionar(@RequestBody Carro carro) {
        return service.salvar(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable UUID id, @RequestBody Carro carro) {
        if (!service.buscarPorId(id).isPresent()) {
            throw new NoSuchElementException("Carro com ID " + id + " não encontrado.");
        }
        carro.setId(id);
        return ResponseEntity.ok(service.salvar(carro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable UUID id) {
        if (!service.buscarPorId(id).isPresent()) {
            throw new NoSuchElementException("Carro com ID " + id + " não encontrado.");
        }
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}