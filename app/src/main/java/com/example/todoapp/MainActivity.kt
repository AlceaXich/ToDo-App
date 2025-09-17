package com.example.todoapp

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.AppDatabase
import com.example.todoapp.data.Task
import com.example.todoapp.ui.theme.TaskAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private val db by lazy { AppDatabase.getDatabase(this) }
    private val taskDao by lazy { db.taskDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "To Do App"

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(
            tasks = mutableListOf(),
            onTaskChecked = { task ->
                lifecycleScope.launch(Dispatchers.IO) {
                    taskDao.updateTask(task)
                }
            }
            /*onTaskDeleted = { task ->
                lifecycleScope.launch(Dispatchers.IO) {
                    taskDao.deleteTask(task)
                    loadTasksFromDb()
                }
            }*/
        )
        recyclerView.adapter = taskAdapter

        // Cargar tareas desde BD
        loadTasksFromDb()

        // Configurar FAB
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun loadTasksFromDb() {
        lifecycleScope.launch(Dispatchers.IO) {
            val dbTasks = taskDao.getAllTasks()
            withContext(Dispatchers.Main) {
                taskAdapter.setTasks(dbTasks)
            }
        }
    }

    private fun showAddTaskDialog() {
        val input = EditText(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Nueva tarea")
            .setView(input)
            .setPositiveButton("Agregar") { _, _ ->
                val taskTitle = input.text.toString()
                if (taskTitle.isNotEmpty()) {
                    val task = Task(title = taskTitle, content = taskTitle, done = false)
                    lifecycleScope.launch(Dispatchers.IO) {
                        taskDao.insertTask(task)
                        loadTasksFromDb()
                    }
                } else {
                    Toast.makeText(this, "La tarea no puede estar vacía", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
    }
}

