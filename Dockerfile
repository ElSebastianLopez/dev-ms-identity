# Etapa 1: Compilación
FROM amazoncorretto:21-alpine AS build
# Instalar Maven
RUN apk add --no-cache maven
# Establece el directorio de trabajo
WORKDIR /src
# Copia el código fuente
COPY . .
# Descarga las dependencias y compila
RUN mvn clean install -DskipTests

# Etapa 2: Ejecución
FROM amazoncorretto:21-alpine
# Instalar fuentes necesarias
# Crear usuario no root para seguridad
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
# Directorio de trabajo
WORKDIR /app
# Copia solo el JAR compilado
COPY --from=build /src/target/*.jar ./app.jar
# Asigna permisos al usuario no root
RUN chown -R appuser:appgroup /app
# Cambia al usuario no root
USER appuser
# Expone el puerto
EXPOSE 8080
# Comando de ejecución con soporte para variable de entorno
CMD ["sh", "-c", "java -jar app.jar"]