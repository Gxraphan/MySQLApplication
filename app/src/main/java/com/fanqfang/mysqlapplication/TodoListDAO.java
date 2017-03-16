package com.fanqfang.mysqlapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by fanqfang on 2/10/2017 AD.
 */

public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;


        public TodoListDAO (Context context){
            dbHelper = new DbHelper(context);
        }

        public void open(){
            database = dbHelper.getWritableDatabase();
        }

        public void close (){
            dbHelper.close();
        }

        public ArrayList<TodoList> getAlltodoList(){
            ArrayList<TodoList> todoList = new ArrayList<TodoList>();
            Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;",null);
            cursor.moveToFirst();
            //add TodoList
            TodoList todoList1;

            while (!cursor.isAfterLast()){
                //add TodoList
                todoList1 = new TodoList();
                todoList1.setTaskid(cursor.getInt(0));
                todoList1.setTaskname(cursor.getString(1));
                todoList.add(todoList1);
                cursor.moveToNext();
            }
            cursor.close();
            return todoList;
        }

    public void add(TodoList todoList){
        //object was throws and recieve it
        TodoList newTodoList = new TodoList();
        newTodoList = todoList;

        //after that GET value from object TodoList and send to ContentValues
        ContentValues values = new ContentValues();
        //put table name and value to put it
        values.put("taskname", newTodoList.getTaskname());
        this.database.insert("tbtodo_list", null, values);
        //to show result message
        Log.d("Todo List Demo ::: ", "Add OK");
    }

    public  void update(TodoList todoList){

        TodoList updateTodoList = todoList;
        ContentValues values = new ContentValues();
        values.put("taskname",updateTodoList.getTaskname());
        values.put("taskid",updateTodoList.getTaskid());
        String where = "taskid=" + updateTodoList.getTaskid();

        this.database.update("tbtodo_list",values,where,null);
        Log.d("Todo List Demo :::","Update OK");

    }

    public void delete (TodoList todoList){
        TodoList delTodolist = todoList;
        //String sqlText = "DELETE * FROM todo_list WHERE taskid ="+ delTodolist.getTaskid();
        //this.database.execSQL(sqlText);
        TodoList updateTodoList = todoList;
        ContentValues values = new ContentValues();
        values.put("taskname",delTodolist.getTaskname());
        values.put("taskid",delTodolist.getTaskid());
        String where = "taskid=" + delTodolist.getTaskid();

        this.database.delete("tbtodo_list",where,null);
        Log.d("Todo List Demo :::","Update OK");

    }



}

