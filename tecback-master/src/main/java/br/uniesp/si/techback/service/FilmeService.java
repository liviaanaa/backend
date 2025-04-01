package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    public Filme buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Filme salvar(Filme filme) {
        return repository.save(filme);
    }

    public Filme atualizar(Long id, Filme filmeAtualizado) {
        return repository.findById(id)
                .map(filme -> {
                    filme.setTitulo(filmeAtualizado.getTitulo());
                    filme.setAutor(filmeAtualizado.getAutor());
                    return repository.save(filme);
                }).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}