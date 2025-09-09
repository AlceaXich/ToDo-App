# ToDo-App
To-Do App básica con RecyclerView y ViewModel

## Resumen
| Obj. | Android                             | Proyecto Android                                                         |
|------| ------------------------------------------------- | ------------------------------------------------------------------------ |
| 1    | Ciclo de vida, ViewModel, Navigation              | **To-Do App básica** con RecyclerView y ViewModel                        |

## Proceso
1. **Toolbar en ToDoApp**
   1. En `res/values/themes.xml` se creo el tema:
        ```
        <style name="Theme.ToDoApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
            <item name="colorPrimary">@color/purple</item>
        </style>
        ```
   2. Se agrego el archivo `res/layout/activity_main.xml` para la pantalla principal:
      * Uso de `CoordinatorLayout` como un contenedor flexible para coordinar el comportamiento de varias vistas que se tendra.
         - **android:layout_width="match_parent"** → ocupa todo el ancho disponible.
         - **android:layout_height="match_parent"** → ocupa todo el alto disponible.
      * Uso de `LinearLayout` para el contenedor que organiza sus hijos en una sola línea.
         - **android:orientation="vertical"** → coloca las vistas una debajo de la otra.
         - **android:orientation="horizontal"** → coloca las vistas una al lado de la otra.
      * Uso de `widget.Toolbar` para el toolbar.
        ```
        <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="70dp"
            android:background="?attr/colorPrimary"
            android:minHeight="?attr/actionBarSize"
            android:theme="?attr/actionBarTheme"
            app:titleTextColor="@android:color/white" />
        ```
      * Uso de `floatingactionbutton.FloatingActionButton` para el boton de Agregar.
        ```
        <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="50dp"
        android:contentDescription="Agregar tarea"
        app:backgroundTint="@color/purple"
        app:srcCompat="@drawable/plus"
        app:tint="@android:color/white"
        app:shapeAppearanceOverlay="@style/SquareFab"/>
        ```
         * En `res/drawable/` agregamos el icono de plus `plus.png`
         * con `android:layout_gravity="bottom|end` indicamos la posicion del boton.
2. Button(fab)
   1. En el archivo `res/layout/activity_main.xml`:
      * Dentro de `CoordinatorLayout` usamos `floatingactionbutton.FloatingActionButton` para el boton de Agregar.
        ```
        <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="50dp"
        android:contentDescription="Agregar tarea"
        app:backgroundTint="@color/purple"
        app:srcCompat="@drawable/plus"
        app:tint="@android:color/white"
        app:shapeAppearanceOverlay="@style/SquareFab"/>
        ```
         * En `res/drawable/` agregamos el icono de plus `plus.png`
         * con `android:layout_gravity="bottom|end` indicamos la posicion del boton.