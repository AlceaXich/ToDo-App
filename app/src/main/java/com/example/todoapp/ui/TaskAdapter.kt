package com.example.todoapp.ui.theme

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.Task

class TaskAdapter(
    private val tasks: MutableList<Task>,
    private val onTaskChecked: (Task) -> Unit,
    private val onTaskDeleted: (Task) -> Unit
) :  RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTaskTitle: CheckBox = itemView.findViewById(R.id.tvTask)
        val btnDelete: ImageView = itemView.findViewById(R.id.btnDelete)
    }

    private fun showDeleteTaskDialog(task: Task, context: Context) {
        AlertDialog.Builder(context)
            .setTitle("Eliminar tarea")
            .setMessage("Esta seguro de eliminar la tarea?")
            .setPositiveButton("Eliminar") { _, _, ->
                onTaskDeleted(task)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.tvTaskTitle.text = task.title

        // Evitar que se dispare en cada bind
        holder.tvTaskTitle.setOnCheckedChangeListener(null)

        // Seteamos el estado actual
        holder.tvTaskTitle.isChecked = task.done

        // Aplicamos tachado según estado
        holder.tvTaskTitle.paintFlags = if (task.done) {
            holder.tvTaskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.tvTaskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        holder.tvTaskTitle.setOnCheckedChangeListener { _, isChecked ->
            task.done = isChecked
            onTaskChecked(task)

            // Aquí actualizamos el tachado en tiempo real
            holder.tvTaskTitle.paintFlags = if (isChecked) {
                holder.tvTaskTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.tvTaskTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }

        //Boton Eliminar
        holder.btnDelete.setOnClickListener {
            showDeleteTaskDialog(task, holder.tvTaskTitle.context)
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun addTask(task: Task) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }

    fun setTasks(newTask: List<Task>) {
        tasks.clear()
        tasks.addAll(newTask)
        notifyDataSetChanged()
    }
}