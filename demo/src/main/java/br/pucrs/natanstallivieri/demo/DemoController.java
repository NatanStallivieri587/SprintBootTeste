package br.pucrs.natanstallivieri.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class DemoController {

    private final List<Livro> livros;

    public DemoController() {
        this.livros = new ArrayList<>();
        this.livros.add(new Livro(1, "1984", "George Orwell", 1949));
        this.livros.add(new Livro(2, "dom quixote", "Miguel de Cervantes", 1605));
        this.livros.add(new Livro(3, "o alienista", "Machado de Assis", 1882));
    }

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicacao Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return livros;
    }

    @GetMapping("/titulos")
    public List<String> getTitulos() {
        List<String> titulos = new ArrayList<>();
        for (Livro livro : livros) {
            titulos.add(livro.getTitulo());
        }
        return titulos;
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        List<String> autores = new ArrayList<>();
        for (Livro livro : livros) {
            autores.add(livro.getAutor());
        }
        return autores;
    }
}
