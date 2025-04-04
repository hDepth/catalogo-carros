package checkp.jadv.demo.Repository;

import checkp.jadv.demo.domainmodel.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CarroRepository extends JpaRepository<Carro, UUID> {
    List<Carro> findTop10ByOrderByPotenciaDesc();
    List<Carro> findTop10ByOrderByEconomiaDesc();
    List<Carro> findByTipo(String tipo);
}
