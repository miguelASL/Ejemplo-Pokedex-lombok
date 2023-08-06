package com.example.pokedex.service;

import com.example.pokedex.entities.PokedexEntities;
import com.example.pokedex.repository.PokeRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Esta anotación marca la clase como un servicio de Spring, lo que permite que Spring la gestione como un
//componente y se pueda inyectar en otras clases.
public class PokeServiceImpl implements PokeService { //Es la implementación del servicio PokeService. Implementa las
    //operaciones definidas en la interfaz PokeService para interactuar con la base de datos a través del repositorio.
    private final PokeRepositorio repositorio;

    public PokeServiceImpl(PokeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<PokedexEntities> getAllPokemons() {
        return (List<PokedexEntities>) repositorio.findAll();
    }

    @Override
    public Iterable<PokedexEntities> getPokemonById(Long id) {
        return repositorio.findAll();
    }

    @Override
    public PokedexEntities createPokemon(PokedexEntities pokemon) {
        return repositorio.save(pokemon);
    }

    @Override
    public PokedexEntities updatePokemon(Long id, PokedexEntities updatedPokemon) {
        Optional<PokedexEntities> existingPokemon = repositorio.findById(id);
        if (existingPokemon.isPresent()) {
            updatedPokemon.setId(id);
            return repositorio.save(updatedPokemon);
        } else {
            throw new IllegalArgumentException("Pokemon with ID " + id + " not found.");
        }
    }

    @Override
    public void deletePokemon(Long id) {
        repositorio.deleteById(id);
    }
}
