package service;

import model.Carro;
import org.springframework.stereotype.Service;
import repository.CarroRepository;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Carro buscarPorId(Long id) {
        return carroRepository.findById(id).orElse(null);
    }

    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro atualizar(Long id, Carro carro) {
        Carro carroExistente = carroRepository.findById(id).orElse(null);

        if (carroExistente == null) {
            return null;
        }

        carroExistente.setModelo(carro.getModelo());
        carroExistente.setMarca(carro.getMarca());
        carroExistente.setPreco(carro.getPreco());
        carroExistente.setAno(carro.getAno());

        return carroRepository.save(carroExistente);
    }

    public boolean deletar(Long id) {
        if (!carroRepository.existsById(id)) {
            return false;
        }

        carroRepository.deleteById(id);
        return true;
    }
}
