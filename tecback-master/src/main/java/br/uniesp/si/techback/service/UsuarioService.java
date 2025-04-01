package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UsuarioService {

    @Autowired // dar sinal para o spring se encarregar de instanciar automaticamente.
    UsuarioRepository repository = null;

    public static Usuario cadastrar(Usuario usuario) {
        return repository.save(usuario);
    }

    Usuario salvar(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario buscarPorId(Long id);

    Usuario atualizar(Long id, Usuario usuario);

    void deletar(Long id);
}
