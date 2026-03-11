# AUTO_FRONT_POM_FACTORY

Proyecto de automatización de pruebas de interfaz de usuario (UI) utilizando **Serenity BDD**, **Cucumber** y **Java**, siguiendo el patrón de diseño **Page Object Model (POM)**.

## Requisitos
- Java 21+ instalado.
- Gradle instalado (o usar `./gradlew`).
- Google Chrome instalado.

## Estructura del proyecto
- `src/test/java/com/automatizacion/pages/`: Clases de mapeo de elementos y acciones de página.
- `src/test/java/com/automatizacion/steps/`: Definiciones de los pasos de Cucumber.
- `src/test/java/com/automatizacion/runners/`: Clase `TestRunner` para ejecutar las pruebas.
- `src/test/resources/features/`: Escenarios de prueba escritos en lenguaje Gherkin.
- `src/test/resources/serenity.conf`: Configuración del framework y del WebDriver.

## Cómo ejecutar

Para ejecutar todas las pruebas, utiliza el siguiente comando:
```bash
./gradlew test
```

Para filtrar por tags:
```bash
./gradlew test -Dcucumber.filter.tags="@mi_tag"
```

## Ver reporte
Después de la ejecución, el reporte detallado de Serenity se genera en la siguiente ruta:
`target/site/serenity/index.html`

Abre este archivo en cualquier navegador para visualizar los resultados paso a paso y las capturas de pantalla de los fallos.