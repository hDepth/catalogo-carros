package checkp.jadv.demo.Service;

import checkp.jadv.demo.domainmodel.Carro;
import checkp.jadv.demo.Repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarroService {
    @Autowired
    private CarroRepository repository;

    public List<Carro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Carro> buscarPorId(UUID id) {
        return repository.findById(id);
    }

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }

    public void excluir(UUID id) {
        repository.deleteById(id);
    }

    public List<Carro> listarPorPotencia() {
        return repository.findTop10ByOrderByPotenciaDesc();
    }

    public List<Carro> listarPorEconomia() {
        return repository.findTop10ByOrderByEconomiaDesc();
    }

    public List<Carro> listarEletricos() {
        return repository.findByTipo("eletrico");
    }
}