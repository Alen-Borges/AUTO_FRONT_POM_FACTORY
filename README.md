# AUTO_FRONT_POM_FACTORY 🚀

Proyecto de automatización de pruebas de interfaz de usuario (UI) para el sistema de gestión de tickets de **Atlas Fiber**. Este marco utiliza **Serenity BDD**, **Cucumber** y **Java 21**, implementando el patrón de diseño **Page Object Model (POM)**.

---

## 🛠️ Tecnologías y Versiones

*   **Java**: 21 (Amazon Corretto / Temurin)
*   **Framework**: Serenity BDD 4.0.12 (Migrado para compatibilidad con Chromium moderno)
*   **BDD**: Cucumber 7.15.0
*   **Gestor de dependencias**: Gradle
*   **Navegador**: Chrome / Chromium (Ejecución local y headless)

---

## 📂 Estructura del Proyecto

```text
src/test/java/com/automatizacion/
├── pages/          # Clases Page Object (Mapeo de elementos y acciones de UI)
│   ├── FormularioPage.java
│   └── TicketsPage.java
├── steps/          # Clases Step Definition (Conexión Gherkin -> Java)
│   ├── FormularioSteps.java
│   └── TicketsSteps.java
└── runners/        # Clase TestRunner para ejecución de Cucumber
    └── TestRunner.java

src/test/resources/
├── features/       # Escenarios de prueba en lenguaje Gherkin (Español)
│   └── gestion_tickets.feature
└── serenity.conf   # Configuración centralizada de WebDriver y Entornos
```

---

## 🚀 Cómo empezar

### Requisitos previos
1. Tener instalado **Java 21**.
2. Tener **Chrome** o **Chromium** instalado.
3. Asegurarse de que el frontend esté corriendo en `http://localhost`.

### Ejecución de Pruebas

Para ejecutar todos los escenarios y generar el reporte:
```bash
./gradlew test
```

Para filtrar por etiquetas específicas (tags):
```bash
./gradlew test -Dcucumber.filter.tags="@reporte"
./gradlew test -Dcucumber.filter.tags="@dashboard or @filtro"
```

---

## 📊 Reportes de Serenity

Una de las mayores ventajas de este proyecto son sus reportes vivos. Después de cada ejecución, puedes visualizar el resultado detallado con capturas de pantalla:

1. Navega a `target/site/serenity/`.
2. Abre el archivo `index.html` en tu navegador.

*Comando rápido en Linux:*
```bash
xdg-open target/site/serenity/index.html
```

---

## 🏗️ Patrón de Diseño: POM (Page Object Model)

Este proyecto sigue un estándar **Senior** de POM:
- **Páginas**: Extienden `PageObject` y utilizan la anotación `@DefaultUrl`.
- **Inyección**: Los Page Objects se inyectan automáticamente en los Steps sin necesidad de instanciación manual.
- **Acciones**: Las interacciones son semánticas y encapsulan esperas explícitas para mayor estabilidad.
- **Validaciones**: Se utiliza **AssertJ** para aserciones fluidas y legibles.

---

## ⚙️ Configuración (serenity.conf)

La configuración se ha migrado a un formato centralizado que permite:
- **Modo Headless**: Activado por defecto para ejecuciones rápidas en entornos Linux/CI.
- **Binarios**: Configurado para buscar Chromium en `/usr/bin/chromium`.
- **Envoltorios**: Uso de flags como `--no-sandbox` e `--incognito` para asegurar un entorno de prueba limpio.