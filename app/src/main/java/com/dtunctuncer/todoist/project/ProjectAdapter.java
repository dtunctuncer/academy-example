package com.dtunctuncer.todoist.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dtunctuncer.todoist.R;
import com.dtunctuncer.todoist.api.response.ProjectResponse;
import com.dtunctuncer.todoist.core.AdapterOnClickListener;
import com.dtunctuncer.todoist.db.Project;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {
    private List<ProjectResponse> items;
    private AdapterOnClickListener listener;

    public ProjectAdapter(List<ProjectResponse> items, AdapterOnClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_project, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ProjectResponse item = items.get(position);
        holder.projectName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public void setList(List<ProjectResponse> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    public ProjectResponse getItem(int position) {
        return items.get(position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.projectName)
        TextView projectName;

        ViewHolder(View view, final AdapterOnClickListener listener) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
            ButterKnife.bind(this, view);
        }
    }
}
