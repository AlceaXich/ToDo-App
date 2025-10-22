# 📱 ToDo App

Una aplicación de lista de tareas moderna desarrollada en Android con Kotlin, utilizando las mejores prácticas de desarrollo móvil.

## 🎥 Demo en Video

### 📱 Demostración de la Aplicación

![Demo de la ToDo App](app-video.gif)

*Demostración de las funcionalidades principales de la ToDo App*

### 🎯 Funcionalidades Mostradas en el Demo

- ✅ **Agregar nueva tarea** - Usando el botón flotante
- ✅ **Marcar como completada** - Con efecto de tachado visual
- ✅ **Eliminar tarea** - Con confirmación de diálogo
- ✅ **Persistencia de datos** - Las tareas se guardan automáticamente
- ✅ **Interfaz moderna** - Material Design con tema personalizado

## 🚀 Características

- ✅ **Gestión de tareas**: Crear, editar, marcar como completadas y eliminar tareas
- 🎨 **Interfaz moderna**: Diseño Material Design con tema personalizado
- 💾 **Persistencia de datos**: Base de datos local con Room
- 🔄 **Actualización en tiempo real**: Cambios reflejados inmediatamente en la UI
- 📱 **Responsive**: Adaptable a diferentes tamaños de pantalla
- 🎯 **Fácil de usar**: Interfaz intuitiva y simple

## 🛠️ Tecnologías Utilizadas

### Core Technologies
- **Kotlin** - Lenguaje de programación principal
- **Android SDK** - Framework de desarrollo móvil
- **Room Database** - Persistencia de datos local
- **RecyclerView** - Lista eficiente de tareas
- **Material Design** - Componentes de UI modernos

### Dependencies
- **AndroidX Core KTX** (1.17.0)
- **Lifecycle Runtime KTX** (2.9.3)
- **Room Runtime & KTX** (2.6.1)
- **Material Components** (1.12.0)
- **AppCompat** (1.7.1)
- **ConstraintLayout** (2.2.0)

## 📋 Requisitos del Sistema

- **Android Studio** Arctic Fox o superior
- **Android SDK** API 24 (Android 7.0) o superior
- **Target SDK** API 35
- **Java 11** o superior
- **Kotlin** 2.0.21

## 🏗️ Arquitectura del Proyecto

```
app/
├── src/main/
│   ├── java/com/example/todoapp/
│   │   ├── data/                    # Capa de datos
│   │   │   ├── AppDatabase.kt      # Configuración de Room
│   │   │   ├── Task.kt             # Entidad de tarea
│   │   │   └── TaskDao.kt          # Acceso a datos
│   │   ├── ui/
│   │   │   └── TaskAdapter.kt       # Adaptador RecyclerView
│   │   └── MainActivity.kt         # Actividad principal
│   ├── res/
│   │   ├── layout/                 # Diseños XML
│   │   ├── values/                 # Recursos (colores, strings, temas)
│   │   └── drawable/               # Iconos y formas
│   └── AndroidManifest.xml
└── build.gradle.kts               # Configuración del módulo
```

## 🎨 Diseño y UI

### Componentes Principales
- **Toolbar personalizada** con tema Material Design
- **RecyclerView** para lista eficiente de tareas
- **FloatingActionButton** para agregar nuevas tareas
- **CheckBox** con funcionalidad de tachado para tareas completadas
- **AlertDialog** para confirmaciones de eliminación

### Tema Personalizado
```xml
        <style name="Theme.ToDoApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
            <item name="colorPrimary">@color/purple</item>
        </style>
        ```

### Colores
- **Purple Primary**: #955DE0
- **Purple Light**: #E9E1F7
- **Purple Water**: #EEE2FB

## 💾 Base de Datos

### Entidad Task
```kotlin
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    var done: Boolean = false
)
```

### Operaciones CRUD
- **Create**: Insertar nuevas tareas
- **Read**: Obtener todas las tareas
- **Update**: Marcar tareas como completadas
- **Delete**: Eliminar tareas

## 🚀 Instalación y Configuración

### 1. Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/ToDo-App.git
cd ToDo-App
```

### 2. Abrir en Android Studio
- Abrir Android Studio
- Seleccionar "Open an existing project"
- Navegar a la carpeta del proyecto y seleccionarla

### 3. Sincronizar dependencias
- Android Studio sincronizará automáticamente las dependencias
- O ejecutar manualmente: `./gradlew build`

### 4. Ejecutar la aplicación
- Conectar dispositivo Android o iniciar emulador
- Hacer clic en "Run" o presionar Shift+F10

## 📱 Uso de la Aplicación

### Funcionalidades Principales

1. **Agregar Tarea**
   - Tocar el botón flotante (+)
   - Escribir el título de la tarea
   - Presionar "Agregar"

2. **Marcar como Completada**
   - Tocar el checkbox junto a la tarea
   - La tarea se marcará con tachado

3. **Eliminar Tarea**
   - Tocar el icono de eliminar (🗑️)
   - Confirmar en el diálogo

## 🔧 Configuración del Proyecto

### Gradle Configuration
```kotlin
android {
    namespace = "com.example.todoapp"
    compileSdk = 36
    
    defaultConfig {
        applicationId = "com.example.todoapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
```

### Dependencies Management
El proyecto utiliza **Version Catalog** (`gradle/libs.versions.toml`) para gestionar las versiones de dependencias de forma centralizada.

## 🧪 Testing

### Estructura de Testing
```
src/
├── test/                    # Unit tests
└── androidTest/            # Instrumented tests
```

### Ejecutar Tests
```bash
# Unit tests
./gradlew test

# Instrumented tests
./gradlew connectedAndroidTest
```

## 📦 Build y Release

### Debug Build
```bash
./gradlew assembleDebug
```

### Release Build
```bash
./gradlew assembleRelease
```

### APK Location
```
app/build/outputs/apk/debug/app-debug.apk
```

## 🎯 Características Técnicas

### Patrones de Diseño
- **Repository Pattern**: Para acceso a datos
- **Observer Pattern**: Para actualizaciones de UI
- **Singleton Pattern**: Para instancia de base de datos

### Mejores Prácticas
- **Coroutines**: Para operaciones asíncronas
- **Lifecycle-aware**: Componentes que respetan el ciclo de vida
- **Material Design**: Componentes estándar de Android
- **Room Database**: Persistencia eficiente y type-safe

## 🚀 Próximas Mejoras

- [ ] **Categorías de tareas** con colores
- [ ] **Fechas de vencimiento** para tareas
- [ ] **Notificaciones** para recordatorios
- [ ] **Sincronización en la nube**
- [ ] **Temas oscuros y claros**
- [ ] **Búsqueda y filtros**
- [ ] **Exportar/Importar tareas**

## 👨‍💻 Autor

Desarrollado con ❤️ usando las mejores prácticas de Android development.

## 📞 Contacto

Para preguntas o sugerencias, no dudes en abrir un issue en el repositorio.

---

**¡Gracias por usar ToDo App! 🎉**