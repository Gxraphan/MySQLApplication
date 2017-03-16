package com.fanqfang.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        final EditText newTodoListText = (EditText) findViewById(R.id.editTextAddTask);
        final Button newTodoListButton = (Button) findViewById(R.id.btnAddNewTask); //final ใช้แค่ใน class นี้
        newTodoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList todoList = new TodoList(); //สร้าง object
                todoList.setTaskname(String.valueOf(newTodoListText.getText())); //Taskname = ชื่อคอลลัมในฐานข้อมูล
                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.add(todoList);
                todoListDAO.close();
                finish();
            }
        });

    }

}
