# 🏟️ BetAnalyzier: Smart Betting & Data Analysis

![Android](https://img.shields.io/badge/Platform-Android-brightgreen.svg) 
![Kotlin](https://img.shields.io/badge/Language-Kotlin-orange.svg) 
![Architecture](https://img.shields.io/badge/Architecture-MVVM%20/%20Clean-blue.svg)
![Design](https://img.shields.io/badge/UI-Material%203%20(Dark%20%26%20Red)-red.svg)

**BetAnalyzier** no es una app de apuestas común. Es una herramienta de **inteligencia deportiva** diseñada para analizar miles de puntos de datos en tiempo real y ofrecer predicciones basadas en estadísticas puras, eliminando el factor emocional del juego.

---

## 🚀 Características Principales

### 🧠 El "Cerebro" (Deep Analysis Engine)
Nuestra app no lanza una moneda al aire. El algoritmo analiza:
* **H2H (Head to Head):** Historial de enfrentamientos directos de los últimos años.
* **Factor Forma:** Rendimiento de los últimos 5 partidos (Goles, posesión, tiros a puerta).
* **Disponibilidad Real:** Cruce de datos de lesiones y sanciones de última hora.
* **Mercados Especializados:** Análisis profundo de córneres y tarjetas basado en tendencias de árbitros y equipos.

### 📱 Experiencia de Usuario (UI/UX)
* **Diseño Premium:** Estética *Dark & Red* (Negro profundo y Rojo Bet) para reducir la fatiga visual.
* **Navegación Intuitiva:** Menú lateral "hamburguesa" con acceso rápido a las 5 grandes ligas y competiciones internacionales.
* **En Directo:** Marcadores en tiempo real con notificaciones push instantáneas para goles, tarjetas y córneres.

---

## 🛠️ Stack Tecnológico

| Componente | Tecnología |
| :--- | :--- |
| **Lenguaje** | Kotlin |
| **Arquitectura** | MVVM (Model-View-ViewModel) + Clean Architecture |
| **Redes** | Retrofit 2 & GSON para consumo de API-Football |
| **Imágenes** | Glide / Coil (Carga optimizada de escudos y fotos) |
| **Asincronía** | Kotlin Coroutines & Flow |
| **Base de Datos** | Room (Para favoritos y caché offline) |
| **Notificaciones** | Firebase Cloud Messaging & WorkManager |
| **Diseño** | Material Design 3 (M3) |

---

## 📂 Estructura del Proyecto

```text
app/
├── src/main/java/com/example/betalyzer/
│   ├── data/           # Repositorios, APIs y Modelos de datos (Retrofit)
│   ├── logic/          # El motor de análisis (Algoritmos de IA)
│   ├── ui/             # Fragments, Activities y ViewModels
│   └── utils/          # Extensiones, validadores y constantes
├── src/main/res/
│   ├── layout/         # Diseños XML (Item_match, Fragments, Drawer)
│   ├── menu/           # Navegación del Drawer (Ligas y Secciones)
│   └── values/         # Temas (Dark Mode) y Colores (Negro/Rojo)
