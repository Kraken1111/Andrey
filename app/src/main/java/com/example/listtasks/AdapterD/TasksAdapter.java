package com.example.listtasks.AdapterD;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.listtasks.R;
import com.example.listtasks.UpdateTaskActivity;
import com.example.listtasks.database.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

private Context mCtx;
private List<Task> taskList;

public TasksAdapter(Context mCtx, List<Task> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
        }

@Override
public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycleview_task, parent, false);
        return new TasksViewHolder(view);
        }

@Override
public void onBindViewHolder(TasksViewHolder holder, int position) {
        Task t = taskList.get(position);
        holder.textViewTask.setText(t.getTask());

        if (t.isFinished())
        holder.textViewStatus.setText("Завершено");
        else
        holder.textViewStatus.setText("Не завершено");
        }

@Override
public int getItemCount() {
        return taskList.size();
        }

class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView textViewStatus, textViewTask;

    public TasksViewHolder(View itemView) {
        super(itemView);

        textViewStatus = itemView.findViewById(R.id.textViewStatus);
        textViewTask = itemView.findViewById(R.id.textViewTask);


        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Task task = taskList.get(getAdapterPosition());

        Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
        intent.putExtra("task", task);

        mCtx.startActivity(intent);
    }
}
}
