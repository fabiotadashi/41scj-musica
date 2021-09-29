package br.com.fiap.musica.service;

import br.com.fiap.musica.dto.MusicaCreateUpdateDTO;
import br.com.fiap.musica.dto.MusicaDTO;
import br.com.fiap.musica.dto.MusicaPrecoDTO;
import br.com.fiap.musica.dto.MusicaSimpleDTO;
import br.com.fiap.musica.entity.Musica;
import br.com.fiap.musica.repository.MusicaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaServiceImpl implements MusicaService {

    private PrecoValidator precoValidator;
    private MusicaRepository musicaRepository;

    public MusicaServiceImpl(
            PrecoValidator precoValidator,
            MusicaRepository musicaRepository
    ){
        this.precoValidator = precoValidator;
        this.musicaRepository = musicaRepository;
    }

    @Override
    public List<MusicaSimpleDTO> list(String nome) {
        return musicaRepository.findAllByNomeStartsWith(nome)
                .stream()
                .map(MusicaSimpleDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public MusicaDTO findById(long id) {
        Musica musica = getMusicaById(id);
        return new MusicaDTO(musica);
    }

    @Override
    public MusicaDTO create(MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        Musica musica = new Musica(musicaCreateUpdateDTO);

        validate(new MusicaDTO(musicaCreateUpdateDTO));

        Musica musicaSaved = musicaRepository.save(musica);
        return new MusicaDTO(musicaSaved);
    }

    @Override
    public MusicaDTO update(long id, MusicaCreateUpdateDTO musicaCreateUpdateDTO) {
        validate(new MusicaDTO(musicaCreateUpdateDTO));

        Musica musica = getMusicaById(id);
        musica.setNome(musicaCreateUpdateDTO.getNome());
        musica.setAutor(musicaCreateUpdateDTO.getAutor());
        musica.setDataLancamento(musicaCreateUpdateDTO.getDataLancamento());
        musica.setDuracao(musicaCreateUpdateDTO.getDuracao());
        musica.setPreco(musicaCreateUpdateDTO.getPreco());

        Musica musicaSaved = musicaRepository.save(musica);
        return new MusicaDTO(musicaSaved);
    }

    @Override
    public MusicaDTO updatePreco(long id, MusicaPrecoDTO musicaPrecoDTO) {
        Musica musica = getMusicaById(id);
        musica.setPreco(musicaPrecoDTO.getPreco());

        validate(new MusicaDTO(musica));

        Musica musicaSaved = musicaRepository.save(musica);
        return new MusicaDTO(musicaSaved);
    }

    @Override
    public void delete(long id) {
        getMusicaById(id);
        musicaRepository.deleteById(id);
    }

    private void validate(MusicaDTO musicaDTO) {
        if(!precoValidator.validate(musicaDTO)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "preco invalido");
        }
    }

    private Musica getMusicaById(long id) {
        return musicaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "musica.not.found"));
    }
}
