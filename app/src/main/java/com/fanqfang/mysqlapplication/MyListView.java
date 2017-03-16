package com.fanqfang.mysqlapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fanqfang on 2/23/2017 AD.
 */

public class MyListView extends BaseAdapter{ //ตัวที่ทำให้ listview สามารถทำงานได้ ตัวเชื่อม

    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<TodoList> myTodoList;

    public MyListView(Activity activity, ArrayList<TodoList> myTodoList) {
        this.myTodoList = myTodoList; this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() { // check data listview ที่ดึงมา ว่ามีเท่าไหร่
        return myTodoList.size();
    }

    @Override
    public Object getItem(int position) { //ตำแหน่ง
        return myTodoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myTodoList.get(position).getTaskid();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //**สำคัญ
        View v = convertView;
        v = inflater.inflate(R.layout.my_list_layout, null);
        TextView textView = (TextView) v.findViewById(R.id.listview_text);
        TodoList todoList = myTodoList.get(position);
        textView.setText(todoList.getTaskname());
        return v;

    }
}
