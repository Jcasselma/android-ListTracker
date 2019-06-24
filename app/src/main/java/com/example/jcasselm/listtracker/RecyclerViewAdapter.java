package com.example.jcasselm.listtracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private List<ListObject> listObjects; // cached listObjects
    private RecyclerViewOnClickListener clickListener;
    private RecyclerViewOnLongClickListener longClickListener;

    public interface RecyclerViewOnClickListener
    {
        void onClick(View view, int position);
    }
    public interface RecyclerViewOnLongClickListener
    {
        boolean onLongClick(View view, int position);
    }

    public void updateData() {
        listObjects.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener
    {
        private TextView listNameTextView;
        private TextView listItem1TextView;
        private TextView listItem2TextView;
        private TextView listItem3TextView;
        private TextView listItem4TextView;
        private TextView listItem5TextView;

        private RecyclerViewOnClickListener clickListener;
        private RecyclerViewOnLongClickListener longClickListener;

        ViewHolder(View view,
                   RecyclerViewOnClickListener clickListener,
                   RecyclerViewOnLongClickListener longClickListener)
        {
            super(view);
            listNameTextView = view.findViewById(R.id.listName);
            listItem1TextView = view.findViewById(R.id.listItem1);
            listItem2TextView = view.findViewById(R.id.listItem2);
            listItem3TextView = view.findViewById(R.id.listItem3);
            listItem4TextView = view.findViewById(R.id.listItem4);
            listItem5TextView = view.findViewById(R.id.listItem5);

            this.clickListener = clickListener;
            this.longClickListener = longClickListener;
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view)
        {
            clickListener.onClick(view, getAdapterPosition());
        }
        @Override
        public boolean onLongClick(View view)
        {
            return longClickListener.onLongClick(view,
                    getAdapterPosition());
        }

    }

    RecyclerViewAdapter(RecyclerViewOnClickListener clickListener,
                        RecyclerViewOnLongClickListener longClickListener)
    {
        this.clickListener = clickListener;
        this.longClickListener = longClickListener;
    }
    public void setListObjects(List<ListObject> listObjects)
    {
        this.listObjects = listObjects;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType)
    {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item_view, parent,
                        false);
        return new ViewHolder(view, clickListener, longClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (listObjects != null) {
            ListObject listObject = listObjects.get(position);
            holder.listNameTextView.setText(listObject.getName());
            holder.listItem1TextView.setText(listObject.getItem1());
            holder.listItem2TextView.setText(listObject.getItem2());
            holder.listItem3TextView.setText(listObject.getItem3());
            holder.listItem4TextView.setText(listObject.getItem4());
            holder.listItem5TextView.setText(listObject.getItem5());

        } else {
            // Covers the case of data not being ready yet.
            holder.listNameTextView.setText("No List");
            holder.listItem1TextView.setText("No item1");
            holder.listItem2TextView.setText("No item2");
            holder.listItem3TextView.setText("No item3");
            holder.listItem4TextView.setText("No item4");
            holder.listItem5TextView.setText("No item5");

        }
    }
        @Override
        public int getItemCount()
        {
            return listObjects != null ? listObjects.size() : 0;
        }


}