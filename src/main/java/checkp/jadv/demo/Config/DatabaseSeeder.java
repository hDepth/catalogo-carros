/*package checkp.jadv.demo.Config;

import checkp.jadv.demo.domainmodel.Carro;
import checkp.jadv.demo.Repository.CarroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(CarroRepository repository) {
        return args -> {
            if (repository.count() == 0) { // Evita inserção duplicada
                List<Carro> carros = List.of(
                        new Carro(UUID.randomUUID(), "Toyota", "Corolla", 2022, 168, 12.5, "combustao", 120000),
                        new Carro(UUID.randomUUID(), "Honda", "Civic", 2023, 180, 13.2, "combustao", 130000),
                        new Carro(UUID.randomUUID(), "Ford", "Mustang", 2021, 450, 7.5, "combustao", 350000),
                        new Carro(UUID.randomUUID(), "Chevrolet", "Camaro", 2022, 455, 8.0, "combustao", 360000),
                        new Carro(UUID.randomUUID(), "Tesla", "Model S", 2023, 1020, 20.0, "eletrico", 600000),
                        new Carro(UUID.randomUUID(), "BMW", "iX", 2023, 516, 21.5, "eletrico", 550000),
                        new Carro(UUID.randomUUID(), "Audi", "e-tron", 2022, 402, 19.0, "eletrico", 500000),
                        new Carro(UUID.randomUUID(), "Mercedes", "EQC", 2022, 408, 18.5, "eletrico", 520000),
                        new Carro(UUID.randomUUID(), "Volkswagen", "Golf GTE", 2023, 245, 15.0, "hibrido", 200000),
                        new Carro(UUID.randomUUID(), "Toyota", "Prius", 2022, 121, 20.5, "hibrido", 150000),
                        new Carro(UUID.randomUUID(), "Hyundai", "Ioniq", 2023, 134, 21.0, "hibrido", 160000),
                        new Carro(UUID.randomUUID(), "Nissan", "Leaf", 2023, 214, 17.5, "eletrico", 220000),
                        new Carro(UUID.randomUUID(), "Porsche", "Taycan", 2023, 750, 19.2, "eletrico", 700000),
                        new Carro(UUID.randomUUID(), "Jaguar", "I-PACE", 2022, 394, 19.8, "eletrico", 480000),
                        new Carro(UUID.randomUUID(), "Volvo", "XC40 Recharge", 2023, 408, 18.3, "eletrico", 470000),
                        new Carro(UUID.randomUUID(), "Kia", "EV6", 2023, 577, 19.5, "eletrico", 490000),
                        new Carro(UUID.randomUUID(), "Renault", "Zoe", 2022, 135, 22.0, "eletrico", 180000),
                        new Carro(UUID.randomUUID(), "Peugeot", "e-208", 2023, 136, 21.8, "eletrico", 190000),
                        new Carro(UUID.randomUUID(), "Fiat", "500e", 2023, 118, 23.0, "eletrico", 170000),
                        new Carro(UUID.randomUUID(), "Chevrolet", "Bolt", 2023, 200, 20.5, "eletrico", 230000),
                        new Carro(UUID.randomUUID(), "Mazda", "MX-30", 2023, 143, 21.0, "eletrico", 240000),
                        new Carro(UUID.randomUUID(), "Subaru", "Solterra", 2023, 215, 18.9, "eletrico", 260000),
                        new Carro(UUID.randomUUID(), "Ford", "F-150 Lightning", 2023, 563, 17.8, "eletrico", 500000),
                        new Carro(UUID.randomUUID(), "Lucid", "Air", 2023, 1111, 21.2, "eletrico", 800000)
                );

                repository.saveAll(carros);
                System.out.println("25 carros foram inseridos no banco de dados!");
            }
        };
    }
}
*/