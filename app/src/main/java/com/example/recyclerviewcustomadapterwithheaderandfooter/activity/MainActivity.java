package com.example.recyclerviewcustomadapterwithheaderandfooter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewcustomadapterwithheaderandfooter.R;
import com.example.recyclerviewcustomadapterwithheaderandfooter.adapter.CustomAdapter;
import com.example.recyclerviewcustomadapterwithheaderandfooter.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        List<Member> members = prepareMemberList();
        refleshAdapter(members);
    }
    void initView(){
        recyclerView = findViewById(R.id.recycleViewMean);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private  void refleshAdapter(List<Member>members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private  List<Member> prepareMemberList(){

        List<Member> members = new ArrayList<>();
        members.add(new Member()); // for header;
        for (int i = 0; i <30 ; i++) {
            if(i == 0 || i == 5 || i == 16 || i ==25){
                members.add(new Member("Sherzod" + i, "Jurabekov" + i ,false));
            } else
            {
                members.add(new Member("Sherzod" + i, "Jurabekov" + i ,true ));
            }
        }
        members.add(new Member());
        return members;
    }
}