package hadiatma.ramadhan.ramadhanhadiatama_1202144104_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Adi Ramadhan on 25/02/2018.
 */

public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder> {
    private GradientDrawable mGradientDrawable;
    private ArrayList<Water> mWaterData;
    private Context mContext;

    WaterAdapter(Context context,ArrayList<Water>waterData){
        this.mWaterData=waterData;
        this.mContext=context;

        //menyiapkan placeholder
        mGradientDrawable= new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //membuat placeholder sama dengan image
        Drawable drawable = ContextCompat.getDrawable(mContext,R.drawable.ades);
        if(drawable!=null){
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        }
    }

    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item, parent,
                false),mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {
        Water currentWater = mWaterData.get(position);
        holder.bindTo(currentWater);
    }

    @Override
    public int getItemCount() {
        return mWaterData.size();
    }

    static class WaterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mWaterImage;
        private Context mContext;
        private Water mCurrentWater;
        private GradientDrawable mGradientDrawable;

        WaterViewHolder(Context context,View itemView, GradientDrawable gradientDrawable){
            super(itemView);

            //mendefinisikan view
            mTitleText = (TextView)itemView.findViewById(R.id.titleText);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitleText);
            mWaterImage = (ImageView)itemView.findViewById(R.id.waterImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //set clicklistener
            itemView.setOnClickListener(this);
        }

        void bindTo(Water currentWater){
            mTitleText.setText(currentWater.getTitle());
            mInfoText.setText(currentWater.getInfo());

            mCurrentWater = currentWater;

            Glide.with(mContext).load(currentWater.
                    getImageResource()).placeholder(mGradientDrawable).into(mWaterImage);
        }
        @Override
        public void onClick(View view) {
            Intent detailIntent = Water.starter(mContext, mCurrentWater.getTitle(),
                    mCurrentWater.getImageResource());


            mContext.startActivity(detailIntent);
        }
    }
}
