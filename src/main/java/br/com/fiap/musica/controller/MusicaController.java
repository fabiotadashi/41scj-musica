package br.com.fiap.musica.controller;

import br.com.fiap.musica.dto.MusicaCreateUpdateDTO;
import br.com.fiap.musica.dto.MusicaDTO;
import br.com.fiap.musica.dto.MusicaPrecoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("songs")
public class MusicaController {

    private List<MusicaDTO> musicas = new ArrayList<>();

    public MusicaController(){
        // mock
        MusicaDTO musicaDTO = new MusicaDTO();
        musicaDTO.setId(1);
        musicaDTO.setNome("Pais e Filhos");
        musicaDTO.setAutor("Legião Urbana");
        musicaDTO.setDataLancamento(LocalDate.of(1989, 1, 10));
        musicaDTO.setDuracao(180);
        musicas.add(musicaDTO);

        MusicaDTO musicaDTO1 = new MusicaDTO();
        musicaDTO1.setId(2);
        musicaDTO1.setNome("Você");
        musicaDTO1.setAutor("Tim Maia");
        musicaDTO1.setDataLancamento(LocalDate.of(1985, 5, 11));
        musicaDTO1.setDuracao(200);
        musicas.add(musicaDTO1);
    }

    @GetMapping
    public List<MusicaDTO> list(
            @RequestParam(value = "name", required = false, defaultValue = "") String nome
    ) {
        return musicas.stream()
                .filter(dto -> dto.getNome().startsWith(nome))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MusicaDTO findById(
            @PathVariable long id
    ){
        return getSongById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicaDTO create(
            @RequestBody MusicaCreateUpdateDTO musicaCreateUpdateDTO
    ){
        MusicaDTO musicaDTO = new MusicaDTO(musicaCreateUpdateDTO);
        musicaDTO.setId(musicas.size() + 1);
        musicas.add(musicaDTO);
        return musicaDTO;
    }

    @PutMapping("{id}")
    public MusicaDTO update(
            @PathVariable long id,
            @RequestBody MusicaCreateUpdateDTO musicaCreateUpdateDTO
    ){
        MusicaDTO musicaDTO = getSongById(id);
        musicaDTO.setNome(musicaCreateUpdateDTO.getNome());
        musicaDTO.setDuracao(musicaCreateUpdateDTO.getDuracao());
        musicaDTO.setDataLancamento(musicaCreateUpdateDTO.getDataLancamento());
        musicaDTO.setAutor(musicaCreateUpdateDTO.getAutor());
        musicaDTO.setPreco(musicaCreateUpdateDTO.getPreco());

        return musicaDTO;
    }

    @PatchMapping("{id}")
    public MusicaDTO updatePreco(
            @PathVariable long id,
            @RequestBody MusicaPrecoDTO musicaPrecoDTO
    ){
        MusicaDTO musicaDTO = getSongById(id);
        musicaDTO.setPreco(musicaPrecoDTO.getPreco());
        return musicaDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable long id
    ){
        MusicaDTO musicaDTO = getSongById(id);
        musicas.remove(musicaDTO);
    }

    private MusicaDTO getSongById(@PathVariable long id) {
        return musicas.stream()
                .filter(dto -> dto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "song not found"));
    }

}
