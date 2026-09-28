package com.saov.playlist_auth.controllers;

import com.saov.playlist_auth.entities.Musicas;
import com.saov.playlist_auth.services.MusicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/musicas")
public class MusicaController {

    private final MusicaService musicaService;

    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }

    @GetMapping
    public ResponseEntity<List<Musicas>> listar(){
        return ResponseEntity.ok(musicaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musicas> buscarPorId(@PathVariable String id){
        return ResponseEntity.ok(musicaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Musicas> criar(@RequestBody Musicas musica){
        return ResponseEntity.ok(musicaService.criar(musica));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Musicas> atualizar(@PathVariable String id, @RequestBody Musicas musica){
        return ResponseEntity.ok(musicaService.atualizar(id,musica));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        musicaService.deletar(id);
    }
}
