Este proyecto utiliza Spring Boot para construir una aplicación web con acceso a una base de datos. A continuación, se describen las dependencias necesarias, la estructura de los paquetes y las propiedades de configuración relevantes.

## Dependencias a descargar

- **Spring Data JPA**: Facilita la interacción con la base de datos y proporciona operaciones CRUD mediante interfaces de repositorio.
- **H2**: Base de datos en memoria utilizada principalmente para pruebas y desarrollo, permitiendo una configuración fácil y rápida de una base de datos temporal.
- **Spring WEB**: Conjunto de funcionalidades para desarrollar aplicaciones web en Spring, incluyendo soporte para el manejo de solicitudes HTTP y el desarrollo de controladores web.
- **Lombok**: Biblioteca que ayuda a reducir la cantidad de código repetitivo en clases Java, constructores, etc. Puede hacer que el código sea más conciso y fácil de leer.

## Paquetes y sus significados

- **Entities**: Aquí se definen las entidades que representarán la estructura de nuestra base de datos. En este caso, se crea la entidad "Pokedex" con sus respectivos atributos.
- **Repository**: Contiene los repositorios que interactúan con la base de datos. Se puede utilizar tanto `CrudRepository` como `JpaRepository`, siendo este último más completo.
- **Controllers**: Define los controladores que manejan las solicitudes HTTP.
- **Service**: Actúa como el cerebro de la aplicación, encargándose de la lógica de negocio y coordinando las operaciones entre los controladores y los repositorios. Proporciona una abstracción entre las capas y promueve una arquitectura más modular y mantenible.
- **Data**: Componente encargado de cargar datos iniciales en la base de datos, ya sea para pruebas de desarrollo o datos básicos necesarios al inicio de la aplicación. Esto asegura que la funcionalidad de la aplicación que depende de estos datos funcione correctamente.

## Propiedades de configuración de Lombok

A continuación se detallan algunas propiedades de configuración importantes para el uso de Lombok en el proyecto:

- **`config.stopBubbling`**: Se utiliza para controlar si las configuraciones de Lombok deben detenerse de propagarse en un proyecto. Si se establece en `true`, las configuraciones de Lombok no se propagarán a través de los directorios secundarios del proyecto.
- **`lombok.addGeneratedAnnotation`**: Indica si Lombok debe agregar la anotación `@Generated` en los elementos generados automáticamente. Valor predeterminado: `false`.
- **`lombok.accessors.prefix`**: Prefijo para los nombres de los métodos getter y setter generados por Lombok. Por ejemplo, si se establece en "get" y se tiene un campo llamado `foo`, Lombok generará el método `getFoo()`.
- **`lombok.accessors.fluent`**: Indica si Lombok debe generar métodos getter y setter en estilo "fluent", donde los métodos setter devuelven la instancia del objeto para permitir un encadenamiento de llamadas. Valor predeterminado: `false`.
- **`lombok.accessors.chain`**: Indica si Lombok debe generar métodos setter en cadena, donde los métodos setter devuelven la instancia del objeto para permitir un encadenamiento de llamadas. Valor predeterminado: `false`.
- **`lombok.accessors.dynamic`**: Indica si Lombok debe generar métodos getter y setter dinámicos para campos no existentes en tiempo de compilación, basados en la convención de nombres. Valor predeterminado: `false`.
- **`lombok.copyableAnnotations`**: Anotaciones que se copiarán desde los campos o métodos de la clase original cuando se usa la anotación `@CopyAnnotations`. Valor predeterminado: vacío.
- **`lombok.log.fieldIsStatic`**: Indica si los campos generados por Lombok (`@Log`, `@CommonsLog`, etc.) deben ser estáticos. Valor predeterminado: `false`.
- **`lombok.log.flagUsage`**: Indica si Lombok debe agregar una bandera para habilitar o deshabilitar la generación de campos de registro. Valor predeterminado: `getter`. Posibles valores: `getter`, `field`, `none`.
