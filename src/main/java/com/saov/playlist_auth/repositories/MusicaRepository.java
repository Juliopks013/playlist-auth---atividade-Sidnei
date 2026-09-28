package com.saov.playlist_auth.repositories;

import com.saov.playlist_auth.entities.Musicas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends MongoRepository<Musicas, String> {
}
