FROM ubuntu:latest

# Instala dependencias (si es necesario)
RUN apt-get update && apt-get install -y wget unzip

# Descarga e instala Java 23 (reemplaza con el enlace y el nombre del archivo correcto)
RUN wget <enlace-de-descarga-java23>.tar.gz && \
    tar -xzf <nombre-del-archivo-java23>.tar.gz && \
    mv <directorio-extraido-java23> /opt/java23 && \
    export JAVA_HOME=/opt/java23 && \
    export PATH=$JAVA_HOME/bin:$PATH

# Verifica la instalación de Java
RUN java -version

# Copia tu aplicación Spring Boot
COPY target/your-application.jar /app/app.jar

# Expone el puerto y ejecuta la aplicación
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]