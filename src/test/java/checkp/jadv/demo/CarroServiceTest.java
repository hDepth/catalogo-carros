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
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	void testBuscarCarroPorIdInvalido() {
		Optional<Carro> carro = service.buscarPorId(UUID.randomUUID());
		assertThat(carro).isEmpty();
	}

	@Test
	void testListarTodosOsCarros() {
		List<Carro> carros = service.listarTodos();
		assertThat(carros).isNotEmpty();
		assertThat(carros.size()).isEqualTo(1);
	}

	@Test
	void testAtualizarCarro() {
		Carro carro = service.buscarPorId(carroId).orElseThrow();
		carro.setPreco(150000.00);
		Carro updatedCarro = service.salvar(carro);
		assertThat(updatedCarro.getPreco()).isEqualTo(150000.00);
	}

	@Test
	void testExcluirCarro() {
		service.excluir(carroId);
		Optional<Carro> carro = service.buscarPorId(carroId);
		assertThat(carro).isEmpty();
	}

	@Test
	void testExcluirCarroInexistente() {
		UUID idInvalido = UUID.randomUUID();
		service.excluir(idInvalido);
	}

	@Test
	void testCriarCarroComDadosInvalidos() {
		Carro carro = new Carro();
		assertThrows(Exception.class, () -> service.salvar(carro));
	}

	@Test
	void testBuscarPorModelo() {
		List<Carro> carros = repository.findByModelo("Corolla");
		assertThat(carros).isNotEmpty();
	}

	@Test
	void testFiltrarPorTipo() {
		List<Carro> carros = repository.findByTipo("Combustão");
		assertThat(carros).isNotEmpty();
	}

	@Test
	void testCriarVariosCarrosEVerificarQuantidade() {
		Carro carro2 = new Carro("Ford", "Mustang", 2021, 450, 8.5, "Combustão", 300000.00);
		service.salvar(carro2);
		List<Carro> carros = service.listarTodos();
		assertThat(carros.size()).isEqualTo(2);
	}

	@Test
	void testCriarEBuscarPeloAnoMaisRecente() {
		Carro carro = new Carro("Tesla", "Model S", 2024, 1020, 18.0, "Elétrico", 500000.00);
		service.salvar(carro);
		List<Carro> carros = repository.findByAno(2024);
		assertThat(carros).isNotEmpty();
	}

	@Test
	void testCriarCarroEletricoEVerificarEconomiaMinima() {
		Carro carro = new Carro("Nissan", "Leaf", 2023, 150, 25.0, "Elétrico", 200000.00);
		service.salvar(carro);
		assertThat(carro.getEconomia()).isGreaterThan(20.0);
	}
}

