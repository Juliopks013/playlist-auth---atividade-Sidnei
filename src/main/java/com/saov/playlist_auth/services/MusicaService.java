package com.saov.playlist_auth.services;

import com.saov.playlist_auth.entities.Musicas;
import com.saov.playlist_auth.repositories.MusicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {

    private final MusicaRepository musicaRepository;

    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }

    public List<Musicas> listar(){
        return musicaRepository.findAll();
    }

    public Musicas buscarPorId(String id){
        return musicaRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Música não encontrada!")
        );
    }

    public Musicas criar(Musicas musica){
        return musicaRepository.save(musica);
    }

    public Musicas atualizar(String id, Musicas musica){
        Musicas existente = buscarPorId(id);
        existente.setId(musica.getId());
        existente.setId(musica.getNome());
        existente.setArtista(musica.getArtista());
        existente.setAno(musica.getAno());
        return musicaRepository.save(existente);
    }

    public void deletar(String id){
        if(!musicaRepository.existsById(id)){
            throw  new RuntimeException("Música não encontrada");
        }
        musicaRepository.deleteById(id);
    }
}
