package com.example.pokedex.controllers;

import com.example.pokedex.entities.PokedexEntities;
import com.example.pokedex.repository.PokeRepositorio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController //Se utiliza para marcar una clase como un controlador en una aplicación web basada en Spring.
//Un controlador es responsable de manejar las solicitudes HTTP entrantes y devolver las respuestas correspondientes.
@RequestMapping("/pokedex") //Se utiliza para mapear las solicitudes HTTP entrantes a los métodos de un controlador.
//Esta anotación permite asociar un método del controlador con una o más rutas de solicitud específicas.
public class PokeControllers {

    private final PokeRepositorio repositorio;

    public PokeControllers(PokeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/pokemons")
    public List<PokedexEntities> findAll() {
        return (List<PokedexEntities>) repositorio.findAll();
    }

    @GetMapping("/pokemons/{id}")
    public ResponseEntity<PokedexEntities> findById(@PathVariable Long id) {
        Optional<PokedexEntities> pokemonOptional = repositorio.findById(id);
        if (pokemonOptional.isPresent()) {
            PokedexEntities pokemon = pokemonOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Acierto-Message", "Pokemon encontrado con éxito");
            return ResponseEntity.ok().headers(headers).body(pokemon);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Error-Message", "Ese Pokemon no está en esta generación o no existe");
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PostMapping("/añadir")
    public ResponseEntity<PokedexEntities> crear(@RequestBody PokedexEntities pokemon) {
        PokedexEntities nuevoPokemon = repositorio.save(pokemon);
        return ResponseEntity.ok().body(nuevoPokemon);
    }

    @PutMapping("/modificacion/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id) {
        Optional<PokedexEntities> pokemonOptional = repositorio.findById(id);
        if (pokemonOptional.isPresent()) {
            PokedexEntities poke = pokemonOptional.get();
            poke.setName("");
            poke.setTipo("");
            repositorio.save(poke);
            return ResponseEntity.ok("Cambio realizado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Optional<PokedexEntities> pokemonOptional = repositorio.findById(id);
        if (pokemonOptional.isPresent()) {
            PokedexEntities pokeDelete = pokemonOptional.get();
            repositorio.delete(pokeDelete);
            String mensaje = "El pokemon con el id " + id + " ha sido eliminado";
            return ResponseEntity.noContent().header("Mensaje", mensaje).build();
        } else {
            String mensaje = "El pokemon con id " + id + " no existe";
            return ResponseEntity.notFound().header("Error-Message", mensaje).build();
        }
    }
}