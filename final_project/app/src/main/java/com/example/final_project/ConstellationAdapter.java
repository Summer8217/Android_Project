package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class ConstellationAdapter extends RecyclerView.Adapter<ConstellationAdapter.ViewHolder>{
    // Member variables.
    private ArrayList<Constellations> mSportsData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param sportsData ArrayList containing the sports data.
     * @param context    Context of the application.
     */
    ConstellationAdapter(Context context, ArrayList<Constellations> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;
    }


    /**
     * Required method for creating the ViewHolder objects.
     *
     * @param parent   The ViewGroup into which the new View will be added
     *                 after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @NonNull
    @Override
    public ConstellationAdapter.ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.all_constellations_item_list, parent, false));
    }

    /**
     * Required method that binds the data to the ViewHolder.
     *
     * @param holder   The ViewHolder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(@NonNull ConstellationAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Constellations currentSport = mSportsData.get(position);

        // Populate the TextViews with data.
        holder.bindTo(currentSport);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mConstellationsImage;
        private TextView mDetail;
        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The root view of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);
            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mConstellationsImage = itemView.findViewById(R.id.constellationsImage);
            itemView.setOnClickListener(this);
        }

        void bindTo(Constellations currentSport) {
            // Populate the TextViews with data.
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mConstellationsImage);

        }

        @Override
        public void onClick(View v) {
            Constellations currentSport = mSportsData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, ConstellationDetail.class);
            detailIntent.putExtra("title", currentSport.getTitle());            //???data???????????????activity
            detailIntent.putExtra("detail",currentSport.getDetail());           //???data???????????????activity
            detailIntent.putExtra("image_resource", currentSport.getImageResource());   //???data???????????????activity
            mContext.startActivity(detailIntent);
        }
    }
}
