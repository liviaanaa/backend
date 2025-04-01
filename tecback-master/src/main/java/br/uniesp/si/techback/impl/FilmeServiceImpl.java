package br.uniesp.si.techback.impl;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import br.uniesp.si.techback.service.FilmeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmeServiceImpl extends FilmeService {
    private final FilmeRepository filmeRepository;

    @Override
    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    @Override
    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    @Override
    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new EntityNotFoundException("Filme com ID " + id + " não encontrado."));
    }

    @Override
    public Filme atualizar(Long id, Filme filme) {
        if (!filmeRepository.existsById(Math.toIntExact(id))) {
            throw new EntityNotFoundException("Filme com ID " + id + " não encontrado.");
        }
        filme.setId(Math.toIntExact(id));
        return filmeRepository.save(filme);
    }

    @Override
    public void deletar(Long id) {
        if (!filmeRepository.existsById(Math.toIntExact(id))) {
            throw new EntityNotFoundException("Filme com ID " + id + " não encontrado.");
        }
        filmeRepository.deleteById(Math.toIntExact(id));
    }
}

