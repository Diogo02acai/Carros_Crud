package service;

import model.Usuario;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {

        Usuario usuarioExistente =
                usuarioRepository.findById(id).orElse(null);

        if (usuarioExistente == null) {
            return null;
        }

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setCargo(usuario.getCargo());

        return usuarioRepository.save(usuarioExistente);
    }

    public boolean deletar(Long id) {

        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }
}
