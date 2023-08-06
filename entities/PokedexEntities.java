package com.example.pokedex.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Esta anotación de JPA (Java Persistence API) indica que la clase es una entidad persistente y se mapea a una
//tabla en la base de datos.
@Data //Es una anotación de Lombok que genera automáticamente los métodos mencionados anteriormente. Con esta anotación,
//no necesitas escribir los getters, setters, equals, hashCode y toString manualmente, Lombok los generará por ti.
@NoArgsConstructor //Es una anotación de Lombok que genera automáticamente un constructor sin argumentos.
@AllArgsConstructor //Es una anotación de Lombok que genera automáticamente un constructor con todos los argumentos.
public class PokedexEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String tipo;
}