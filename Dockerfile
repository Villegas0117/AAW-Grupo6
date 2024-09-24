FROM amazoncorretto:21

COPY target/AVI_Aplicaction-0.0.1-SNAPSHOT.jar AVIAPP.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/AVIAPP.jar"]



