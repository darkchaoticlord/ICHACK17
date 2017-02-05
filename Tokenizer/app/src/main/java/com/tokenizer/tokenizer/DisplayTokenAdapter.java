package com.tokenizer.tokenizer;


import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DisplayTokenAdapter extends RecyclerView.Adapter<DisplayTokenAdapter.ViewHolder> {

    private Context mContext;
    private List<DisplayToken> cardViewInfo;

    public DisplayTokenAdapter(Context mContext, List<DisplayToken> cardViewInfo) {
        this.mContext = mContext;
        this.cardViewInfo = cardViewInfo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DisplayToken eventData = cardViewInfo.get(position);


        holder.getOption().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView expiryTextView;
        private TextView organisationTextView;
        private TextView quantityTextView;
        private ImageView option;

        private ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.event_card_text);
            expiryTextView = (TextView) itemView.findViewById(R.id.event_expiry_text);
            organisationTextView = (TextView) itemView.findViewById(R.id.event_organiser_text);
            quantityTextView = (TextView) itemView.findViewById(R.id.event_token_text);
            option = (ImageView) itemView.findViewById(R.id.options);
        }

        public TextView getNameTextView() {
            return nameTextView;
        }

        public TextView getExpiryTextView() {
            return expiryTextView;
        }

        public TextView getOrganisationTextView() {
            return organisationTextView;
        }

        public TextView getQuantityTextView() {
            return quantityTextView;
        }

        public RelativeLayout getOption() {
            return option;
        }
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.card_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return cardViewInfo.size();
    }
}
