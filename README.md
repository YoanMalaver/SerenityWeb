# Proyecto de pruebas automatizadas

Este proyecto contiene pruebas automatizadas utilizando Cucumber, Selenium y Serenity BDD. Con lenguaje JAVA

## Requisitos

- Java JDK 8 o superior
- Maven
- Tener instalado el IDE IntelliJ

## Instrucciones de ejecución

1. Clona el repositorio en tu máquina local.

2. Abre una terminal o línea de comandos y navega hasta el directorio del proyecto.

3. Ejecuta el siguiente comando para compilar y ejecutar las pruebas:

mvn clean verify


4. Después de que las pruebas se completen, se generará un informe en la carpeta `target/site/serenity`.

5. Abre el archivo `target/site/serenity/index.html` en tu navegador para ver el informe de Serenity.

## Ejecutar todos los feature del proyecto con chrome

```
mvn clean verify -Denvironment=chrome
```
## Ejecutar todos los feature del proyecto con Firefox

```

mvn clean verify -Denvironment=firefox
```
Ejecutar todos los feature del proyecto con edge

```
mvn clean verify -Denvironment=edge
```

```
mvn clean verify -Dcucumber.filter.tags=@ActualizarPerfilBasico

```

## Ejecutar el feature de Login
```
mvn clean verify -Dcucumber.features=src/test/resources/features/
```
