package com.androidmov.nestedscrolling;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerView.Adapter<MyViewHolder>() {
            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new MyViewHolder(getLayoutInflater().inflate(R.layout.item_text, parent,
                        false));
            }

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                holder.tvName.setText(getResources().getStringArray(R.array.list)[position]);
            }

            @Override
            public int getItemCount() {
                return getResources().getStringArray(R.array.list).length;
            }
        });
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
