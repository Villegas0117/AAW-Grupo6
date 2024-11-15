# Etapa 1: Construcción del .jar
FROM amazoncorretto:21 AS build
WORKDIR /app
COPY . .
RUN yum install -y tar  # Instalar tar
RUN chmod +x ./mvnw  # Dar permisos de ejecución a mvnw
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución de la aplicación
FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /app/target/AVI_Aplicaction-0.0.1-SNAPSHOT.jar AVIAPP.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/AVIAPP.jar"]
