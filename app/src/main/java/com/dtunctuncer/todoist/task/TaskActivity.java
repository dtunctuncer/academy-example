package com.dtunctuncer.todoist.task;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import com.dtunctuncer.todoist.R;
import com.dtunctuncer.todoist.TodoApp;
import com.dtunctuncer.todoist.api.response.TaskResponse;
import com.dtunctuncer.todoist.core.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskActivity extends BaseActivity implements TaskView {

    @Inject
    TaskPresenter presenter;
    @BindView(R.id.tasksRecycler)
    RecyclerView tasksRecycler;

    private TaskAdapter adapter;
    private long projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projectId = getIntent().getLongExtra("project_id", -1);

        if (projectId < 0) {
            Toast.makeText(this, "Geçersiz proje numarası", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        setContentView(R.layout.activity_task);
        ButterKnife.bind(this);
        DaggerTaskComponent.builder().applicationComponent(((TodoApp) getApplication()).getComponent()).taskModule(new TaskModule(this)).build().inject(this);
        initRecycler();
        presenter.getTasks(projectId);

    }

    private void initRecycler() {
        adapter = new TaskAdapter(null);
        tasksRecycler.setAdapter(adapter);
    }

    @OnClick(R.id.taskAddButton)
    public void onViewClicked() {
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Görev Oluştur").setMessage("Görev Adını Giriniz")
                .setView(input)
                .setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.createTask(projectId, input.getText().toString());
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();

        dialog.show();
    }

    @Override
    public void fillRecycler(List<TaskResponse> body) {
        adapter.setItems(body);
    }

    @Override
    public void taskCreateSuccess(TaskResponse body) {
        adapter.addItem(body);
    }

    @Override
    public void taskCreateError(String message) {
        Toast.makeText(this, message.isEmpty() ? "Beklenmeyen bir hata oluştu" : message, Toast.LENGTH_SHORT).show();
    }
}
