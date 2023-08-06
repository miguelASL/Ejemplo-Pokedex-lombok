package com.example.pokedex.repository;

import com.example.pokedex.entities.PokedexEntities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokeRepositorio extends CrudRepository<PokedexEntities, Long> {
}
