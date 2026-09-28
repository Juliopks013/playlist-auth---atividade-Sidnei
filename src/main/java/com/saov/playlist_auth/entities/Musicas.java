package com.saov.playlist_auth.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "musicas")
public class Musicas {

    @Id
    private String id;
    private String nome;
    private String artista;
    private String ano;

    public Musicas(){}

    public Musicas(String id, String nome, String artista, String ano) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.ano = ano;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
