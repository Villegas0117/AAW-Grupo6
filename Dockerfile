# Usa una imagen base con JDK para construir la aplicación
FROM amazoncorretto:21 AS build

# Establece el directorio de trabajo para la compilación
WORKDIR /app

# Instala herramientas necesarias como tar
RUN yum install -y tar

# Copia los archivos necesarios para ejecutar Maven Wrapper
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

# Asegura que el archivo mvnw tenga permisos de ejecución
RUN chmod +x mvnw

# Descarga las dependencias sin compilar
RUN ./mvnw dependency:go-offline -B

# Copia el resto del código fuente
COPY src ./src

# Compila y empaqueta la aplicación
RUN ./mvnw clean package -DskipTests

# Usa una imagen más ligera para ejecutar la aplicación
FROM amazoncorretto:21

# Establece el directorio de trabajo para la ejecución
WORKDIR /app

# Copia el archivo JAR desde la fase de construcción
COPY --from=build /app/target/AVI_Aplicaction-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (Render lo manejará automáticamente)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
