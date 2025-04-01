package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarFilme(@PathVariable Integer id) {
        return filmeService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        return filmeService.atualizar(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        filmeService.deletar(id);
    }
}
