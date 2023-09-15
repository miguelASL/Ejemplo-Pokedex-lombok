package com.example.pokedex.data;

import com.example.pokedex.entities.PokedexEntities;
import com.example.pokedex.repository.PokeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class Pokemons {

    private final PokeRepositorio repositorio;

    @Autowired
    public Pokemons(PokeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<PokedexEntities> loadData() {
        List<String> nombres = Arrays.asList(
                "Chikorita", "Bayleef", "Meganium", "Cyndaquil", "Quilava",
                "Typhlosion", "Totodile", "Croconaw", "Feraligatr", "Sentret",
                "Furret", "Hoothoot", "Noctowl", "Ledyba", "Ledian", "Spinarak",
                "Ariados", "Crobat", "Chinchou", "Lanturn", "Pichu", "Cleffa",
                "Igglybuff", "Togepi", "Togetic", "Natu", "Xatu", "Mareep",
                "Flaaffy", "Ampharos", "Bellossom", "Marill", "Azumarill",
                "Sudowoodo", "Politoed", "Hoppip", "Skiploom", "Jumpluff",
                "Aipom", "Sunkern", "Sunflora", "Yanma", "Wooper", "Quagsire",
                "Espeon", "Umbreon", "Murkrow", "Slowking", "Misdreavus", "Unown"
        );

        List<String> tipos = Arrays.asList(
                "Planta", "Planta", "Planta", "Fuego", "Fuego",
                "Fuego", "Agua", "Agua", "Agua", "Normal",
                "Normal", "Normal/Volador", "Normal/Volador", "Bicho/Volador",
                "Bicho/Volador", "Bicho/Veneno", "Bicho/Veneno", "Veneno/Volador",
                "Agua/Eléctrico", "Agua/Eléctrico", "Eléctrico", "Hada",
                "Normal/Hada", "Hada", "Hada/Volador", "Psíquico/Volador", "Psíquico/Volador",
                "Eléctrico", "Eléctrico", "Eléctrico", "Planta", "Agua/Hada",
                "Agua/Hada", "Roca", "Agua", "Planta/Volador", "Planta/Volador",
                "Planta/Volador", "Normal", "Planta", "Planta", "Bicho/Volador",
                "Agua/Tierra", "Agua/Tierra", "Psíquico", "Siniestro", "Siniestro/Volador",
                "Agua/Psíquico", "Fantasma", "Desconocido"
        );

        List<PokedexEntities> pokedexList = IntStream.range(0, nombres.size())
                .mapToObj(i -> new PokedexEntities(null, nombres.get(i), tipos.get(i)))
                .collect(Collectors.toList());

        repositorio.saveAll(pokedexList);
        return pokedexList;
    }
}