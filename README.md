## Dependecias a descargar.

- `Spring Data JPA`-> Se utiliza para facilitar la interacción con la base de datos y proporcionar operaciones CRUD
  mediante interfaces de repositorio.
- `H2`-> Es una base de datos en memoria que se utiliza principalmente para pruebas y desarrollo, permitiendo una
  configuración fácil y rápida de una base de datos temporal.
- `Spring WEB`-> Es un conjunto de funcionalidades para desarrollar aplicaciones web en Spring, incluyendo soporte
  para el manejo de solicitudes HTTP y el desarrollo de controladores web.
- `Lombok` -> puede hacer que el código sea más conciso y fácil de leer, ya que elimina la necesidad de escribir 
 manualmente estos métodos comunes en muchas clases

------------------------------------------------------------------------------------------------------------------------
## Paquete y sus significados.

* `Entities`-> Lo usaremos para crear nuestra base de datos. en este caso fue la "pokedex", con sus atributos.
* `Repository`-> Fue donde se creo el repositorio, se puede usar tanto CrudRepository como JpaRepository,
  es mas completo.
* `Controllers`-> Que es donde realizaremos las llamadas HTTP
* `Service`-> El archivo de servicio actúa como el cerebro de la aplicación, encargándose de la lógica de negocio
  y coordinando las operaciones entre los controladores y los repositorios. Proporciona una abstracción entre las capas y
  promueve una arquitectura más modular y mantenible para la aplicación.
* `Data`-> En este caso fue componente que se encarga de cargar datos iniciales en la base de datos, ya sea
  datos de prueba para desarrollo o datos básicos que deben estar disponibles al inicio de la aplicación. Esto puede ser
  útil para probar y asegurar que la funcionalidad de la aplicación que depende de estos datos funcione correctamente.
-----------------------------------------------------------------------------------------------------------------------

## Propiedad Descripción
`Lombok.config →` Es un archivo de configuración utilizado por el framework Lombok en proyectos Java. Lombok es una 
biblioteca que ayuda a reducir la cantidad de código repetitivo en clases Javas, constructores, etc .
* **`config.stopBubbling`** -> Se utiliza para controlar si las configuraciones de Lombok deben detenerse de propagarse 
* en un proyecto.
Esto significa que si estableces lombok.config.stopBubbling = true, las configuraciones de Lombok no se propagarán
a través de los directorios secundarios del proyecto, lo que permitirá tener configuraciones específicas 
para cada subdirectorio.
* 
    **`lombok.addGeneratedAnnotation`** -> Indica si Lombok debe agregar la anotación @Generated en los elementos 
generados automáticamente. Valor predeterminado: false.
* 
    **`lombok.accessors.prefix`** -> Prefijo para los nombres de los métodos getter y setter generados por Lombok.
Por ejemplo, si estableces lombok.accessors.prefix = "get" y tienes un campo llamado foo, Lombok generará
el método getFoo() para acceder al valor del campo. Valor predeterminado: vacío.
* 
    **`lombok.accessors.fluent`** -> Indica si Lombok debe generar métodos getter y setter en estilo "fluent", 
donde los métodos setter devuelven la instancia del objeto para permitir un encadenamiento de llamadas.
Valor predeterminado: false.
* 
    **`lombok.accessors.chain`** -> Indica si Lombok debe generar métodos setter en cadena, donde los métodos setter
devuelven la instancia del objeto para permitir un encadenamiento de llamadas. Valor predeterminado: false.
* 
    **`lombok.accessors.dynamic`** -> Indica si Lombok debe generar métodos getter y setter dinámicos para
campos no existentes en tiempo de compilación, basados en la convención de nombres. Valor predeterminado: false.
* 
    **`lombok.copyableAnnotations`** -> Anotaciones que se copiarán desde los campos o métodos de la clase original
cuando se usa la anotación @CopyAnnotations. Valor predeterminado: vacío.
* 
    **`config.stopBubbling`** -> Indica si Lombok debe dejar de procesar la configuración de anotaciones
más arriba en la jerarquía de clases. Valor predeterminado: false.
* 
    **`lombok.log.fieldIsStatic`** -> Indica si los campos generados por Lombok (@Log, @CommonsLog, etc.) deben ser
estáticos. Valor predeterminado: false.
* 
    **`lombok.log.flagUsage`** -> Indica si Lombok debe agregar una bandera para habilitar o deshabilitar
la generación de campos de registro. Valor predeterminado: getter. Posibles valores: getter, field, none.