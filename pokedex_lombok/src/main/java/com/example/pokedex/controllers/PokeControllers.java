package com.example.pokedex.controllers;

import com.example.pokedex.entities.PokedexEntities;
import com.example.pokedex.repository.PokeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //Se utiliza para marcar una clase como un controlador en una aplicación web basada en Spring.
//Un controlador es responsable de manejar las solicitudes HTTP entrantes y devolver las respuestas correspondientes.
@RequestMapping("/pokedex") //Se utiliza para mapear las solicitudes HTTP entrantes a los métodos de un controlador.
//Esta anotación permite asociar un método del controlador con una o más rutas de solicitud específicas.
public class PokeControllers {

    @Autowired
    private PokeRepositorio repositorio;

    @GetMapping
    public ResponseEntity<List<PokedexEntities>> findAll() {
        return ResponseEntity.ok((List<PokedexEntities>) repositorio.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokedexEntities> findById(@PathVariable Long id) {
        return repositorio.findById(id)
                .map(pokemon -> ResponseEntity.ok()
                        .header("Acierto-Message", "Pokemon encontrado con éxito")
                        .body(pokemon))
                .orElseGet(() -> ResponseEntity.notFound()
                        .header("Error-Message", "Ese Pokemon no está en esta generación o no existe")
                        .build());
    }

    @PostMapping
    public ResponseEntity<PokedexEntities> add(@RequestBody PokedexEntities pokemon) {
        PokedexEntities nuevoPokemon = repositorio.save(pokemon);
        return new ResponseEntity<>(nuevoPokemon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody PokedexEntities updatedPokemon) {
        return repositorio.findById(id)
                .map(pokemon -> {
                    pokemon.setName(updatedPokemon.getName());
                    pokemon.setTipo(updatedPokemon.getTipo());
                    repositorio.save(pokemon);
                    return ResponseEntity.ok("Cambio realizado con éxito");
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return repositorio.findById(id)
                .map(pokemon -> {
                    repositorio.delete(pokemon);
                    return ResponseEntity.noContent().header("Mensaje", "El pokemon con el id " + id + " ha sido eliminado").build();
                })
                .orElseGet(() -> ResponseEntity.notFound().header("Error-Message", "El pokemon con id " + id + " no existe").build());
    }
}