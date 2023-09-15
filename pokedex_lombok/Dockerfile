FROM openjdk:17-slim

LABEL authors="mike"

WORKDIR /app

RUN echo "Hazte con todos los pokemon !!!"

# Copia los archivos necesarios para la construcción
COPY pom.xml .
COPY src ./src

# Instala Maven, construye el proyecto y luego limpia
RUN apt-get update && apt-get install -y maven && mvn clean install

EXPOSE 8079

ENTRYPOINT ["java", "-jar", "pokedexoficial-0.0.1-SNAPSHOT.jar"]
