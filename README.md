# Conversor de Monedas
Este es un proyecto de consola en Java que permite al usuario convertir entre diferentes monedas usando sus siglas internacionales (por ejemplo, USD, EUR, COP, etc.). Utiliza Gson para manejar la conversión de datos en formato JSON y Dotenv para manejar variables de entorno de forma segura.

## Características
- Menú interactivo en consola.
- Lista de monedas disponibles.
- Conversión entre monedas introduciendo siglas y cantidad.
- Resultados formateados con dos decimales.
- Integración con una API externa para obtener tasas de cambio.
- Almacenamiento de historico de consultas.
- Uso de Gson para la manipulación de datos en formato JSON.
- Uso de Dotenv para manejar configuraciones sensibles como la clave API de la fuente de tasas de cambio.

## Cómo usar
1. Clona este repositorio o descarga el código.
2. Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, NetBeans, etc.).
3. Asegúrate de tener el archivo .env con tu clave API (https://www.exchangerate-api.com/)
4. Ejecuta la clase Main.

## Tecnologías utilizadas
- Java
- Gson para la manipulación de datos en formato JSON.
- Dotenv para gestionar configuraciones sensibles desde un archivo .env.
- Scanner (entrada por consola).
- Lógica de servicios (MonedaServicioImpl).
- 
## Requisitos
- JDK 8 o superior.
- IDE o editor de texto.
- Conexión a internet (para obtener tasas de cambio en tiempo real).

## Autor
Walter Daza - 
Proyecto realizado para Alura en el curso Backend en Java.