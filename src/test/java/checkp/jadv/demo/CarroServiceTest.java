package checkp.jadv.demo;

import checkp.jadv.demo.domainmodel.Carro;
import checkp.jadv.demo.Repository.CarroRepository;
import checkp.jadv.demo.Service.CarroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CarroServiceTest {

	@Autowired
	private CarroService service;

	@Autowired
	private CarroRepository repository;

	private UUID carroId;

	@BeforeEach
	void setUp() {
		repository.deleteAll(); // Limpa o banco antes de cada teste

		Carro carro = new Carro();
		carro.setMarca("Toyota");
		carro.setModelo("Corolla");
		carro.setAno(2022);
		carro.setPotencia(169);
		carro.setEconomia(14.5);
		carro.setTipo("Combustão");
		carro.setPreco(145000.00);

		Carro savedCarro = repository.save(carro);
		carroId = savedCarro.getId(); // Guarda o ID para os outros testes
	}

	@Test
	void testCriarCarro() {
		Carro carro = new Carro();
		carro.setMarca("Honda");
		carro.setModelo("Civic");
		carro.setAno(2023);
		carro.setPotencia(180);
		carro.setEconomia(13.8);
		carro.setTipo("Combustão");
		carro.setPreco(160000.00);

		Carro savedCarro = service.salvar(carro);

		assertThat(savedCarro).isNotNull();
		assertThat(savedCarro.getId()).isNotNull();
	}

	@Test
	void testBuscarCarroPorId() {
		Optional<Carro> carro = service.buscarPorId(carroId);

		assertThat(carro).isPresent();
		assertThat(carro.get().getMarca()).isEqualTo("Toyota");
	}

	@Test
	void testListarTodosOsCarros() {
		List<Carro> carros = service.listarTodos();

		assertThat(carros).isNotEmpty();
		assertThat(carros.size()).isEqualTo(1); // Apenas 1 carro inserido no @BeforeEach
	}

	@Test
	void testAtualizarCarro() {
		Carro carro = service.buscarPorId(carroId).orElseThrow();
		carro.setPreco(150000.00); // Atualizando o preço

		Carro updatedCarro = service.salvar(carro);

		assertThat(updatedCarro.getPreco()).isEqualTo(150000.00);
	}

	@Test
	void testExcluirCarro() {
		service.excluir(carroId);

		Optional<Carro> carro = service.buscarPorId(carroId);

		assertThat(carro).isEmpty();
	}
}
