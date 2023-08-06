package com.example.pokedex;

import com.example.pokedex.data.Pokemons;
import com.example.pokedex.entities.PokedexEntities;
import org.springframework.context.ApplicationContext;;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PokedexApplication.class, args);
		Pokemons pokemons = context.getBean(Pokemons.class);

		List<PokedexEntities> findPokemons= pokemons.loadData();
		System.out.println("El numero de pokemons en la pokedex es de -> " +  findPokemons.size());

		// Imprimir los nombres de los Pokémon
		System.out.println("Nombre de los pokemons: ");
		for (PokedexEntities poke: findPokemons) {
			System.out.println(poke.getName());
		}
	}
}