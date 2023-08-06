package com.example.pokedex.service;

import com.example.pokedex.entities.PokedexEntities;
import java.util.List;

public interface PokeService { //Define las operaciones que el servicio debe implementar para interactuar con
    //los pokemons.
    List<PokedexEntities> getAllPokemons();
    Iterable<PokedexEntities> getPokemonById(Long id);
    PokedexEntities createPokemon(PokedexEntities pokemon);
    PokedexEntities updatePokemon(Long id, PokedexEntities updatedPokemon);
    void deletePokemon(Long id);
}
