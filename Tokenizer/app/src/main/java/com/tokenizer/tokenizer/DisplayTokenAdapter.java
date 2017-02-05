package com.tokenizer.tokenizer;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayTokenAdapter extends RecyclerView.Adapter<DisplayTokenAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView expiryTextView;
        public TextView organisationTextView;
        public TextView quantityTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.token_name);
            expiryTextView = (TextView) itemView.findViewById(R.id.token_expiryDate);
            organisationTextView = (TextView) itemView.findViewById(R.id.token_organisation);
            quantityTextView = (TextView) itemView.findViewById(R.id.token_quantity);
        }
    }

}
