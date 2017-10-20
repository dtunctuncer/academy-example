package com.dtunctuncer.todoist.task;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dtunctuncer.todoist.R;
import com.dtunctuncer.todoist.api.response.TaskResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<TaskResponse> items;

    public TaskAdapter(List<TaskResponse> item) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TaskResponse item = items.get(position);

        holder.taskName.setText(item.getContent());

        if (item.isCompleted()) {
            holder.itemView.setBackgroundColor(Color.parseColor("#807FFF00"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#007FFF00"));
        }
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public List<TaskResponse> getItems() {
        return items;
    }

    public void setItems(List<TaskResponse> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItem(TaskResponse body) {
        items.add(body);
        notifyItemInserted(items.size() - 1);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.taskName)
        TextView taskName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
