package br.com.fiap.musica.controller;

import br.com.fiap.musica.dto.MusicaCreateUpdateDTO;
import br.com.fiap.musica.dto.MusicaDTO;
import br.com.fiap.musica.dto.MusicaPrecoDTO;
import br.com.fiap.musica.dto.MusicaSimpleDTO;
import br.com.fiap.musica.service.MusicaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("songs")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping
    public List<MusicaSimpleDTO> list(
            @RequestParam(value = "name", required = false, defaultValue = "") String nome
    ) {
        return musicaService.list(nome);
    }

    @GetMapping("{id}")
    public MusicaDTO findById(
            @PathVariable long id
    ){
        return musicaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDTO create(
            @RequestBody MusicaCreateUpdateDTO musicaCreateUpdateDTO
    ){
        return musicaService.create(musicaCreateUpdateDTO);
    }

    @PutMapping("{id}")
    public MusicaDTO update(
            @PathVariable long id,
            @RequestBody MusicaCreateUpdateDTO musicaCreateUpdateDTO
    ){
        return musicaService.update(id, musicaCreateUpdateDTO);
    }

    @PatchMapping("{id}")
    public MusicaDTO updatePreco(
            @PathVariable long id,
            @RequestBody MusicaPrecoDTO musicaPrecoDTO
    ){
        return musicaService.updatePreco(id, musicaPrecoDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable long id
    ){
        musicaService.delete(id);
    }

}
