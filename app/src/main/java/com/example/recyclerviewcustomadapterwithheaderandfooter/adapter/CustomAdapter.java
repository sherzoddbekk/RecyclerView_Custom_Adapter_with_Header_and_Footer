package com.example.recyclerviewcustomadapterwithheaderandfooter.adapter;

import android.content.Context;
import android.icu.text.MessagePattern;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcustomadapterwithheaderandfooter.R;
import com.example.recyclerviewcustomadapterwithheaderandfooter.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_HEADER =0;
    private static final int TYPE_AVAILABLE_YES =1;
    private static final int TYPE_AVAILABLE_NOT =2;
    private static final int TYPE_AVAILABLE_FOOTER =3;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeader(position)) return TYPE_AVAILABLE_HEADER;
        if (isFooter(position)) return TYPE_AVAILABLE_FOOTER;
        Member member = members.get(position);
        if (member.isAvailable()) return TYPE_AVAILABLE_YES;
        return  TYPE_AVAILABLE_NOT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_AVAILABLE_HEADER){
          View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_header,parent,false);
          return new  CustomViewHeaderHolder(view);
        }
        if (viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_yes,parent,false);
            return new CustomViewYesHolder(view);
        }
        if (viewType == TYPE_AVAILABLE_NOT){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_not,parent,false);
            return  new CustomViewNoHolder(view);
        }
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_adapter_footer,parent,false);
        return new CustomViewFooterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewYesHolder){
            TextView first_name = ((CustomViewYesHolder) holder).firstName;
            TextView last_name = ((CustomViewYesHolder) holder).lastName;
            first_name.setText(member.getFirst_name());
            last_name.setText(member.getLast_name());
        }
        if (holder instanceof CustomViewNoHolder){
            TextView firstName = ((CustomViewNoHolder) holder).firstName;
            TextView lastName = ((CustomViewNoHolder) holder).lastName;
            firstName.setText(member.getFirst_name());
            lastName.setText(member.getFirst_name());
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }
    public boolean isHeader(int position){
        return position == 0;
    }
    public boolean isFooter(int position){
        return position == (members.size() - 1);
    }
    class CustomViewYesHolder extends RecyclerView.ViewHolder{
        TextView firstName;
        TextView lastName;
        public CustomViewYesHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.yes_adapter_textView_firstName);
            lastName = itemView.findViewById(R.id.yes_adapter_textView_lastName);
        }
    }
    class CustomViewNoHolder extends RecyclerView.ViewHolder{

        TextView firstName;
        TextView lastName;

        public CustomViewNoHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.no_adapter_textView_firstName);
            lastName = itemView.findViewById(R.id.no_adapter_textView_lastName);
        }
    }
    class CustomViewFooterHolder extends RecyclerView.ViewHolder{
        TextView footer;
        public CustomViewFooterHolder(@NonNull View itemView) {
            super(itemView);
            footer =  itemView.findViewById(R.id.footer_textView);
        }
    }
    class CustomViewHeaderHolder extends RecyclerView.ViewHolder{
        TextView header;
        public CustomViewHeaderHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.header_textView);
        }
    }
}
