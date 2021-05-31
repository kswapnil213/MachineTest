package in.nilapps.machinetest.modules.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nilapps.machinetest.R;
import in.nilapps.machinetest.common.data.models.Component;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class LevelOneListAdapter extends RecyclerView.Adapter<LevelOneListAdapter.ViewHolder> {

    List<Component> componentList;
    Context context;
    OnItemClickListener listener;
    boolean selectDefault = true;

    public LevelOneListAdapter(Context context, OnItemClickListener listener, List<Component> componentList) {
        this.context = context;
        this.listener = listener;
        this.componentList = componentList;
    }

    @Override
    public LevelOneListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_level_one, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.textView.setText(componentList.get(position).categoryTabData.title);
        Picasso.get()
                .load(componentList.get(position).categoryTabData.backgroundImage)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_error_icon)
                .fit()
                .into(viewHolder.imageView);

        viewHolder.layout.setOnClickListener(v -> {
            v.setFilterTouchesWhenObscured(true);
            listener.onLevelOneItemClicked(position);

        });

        if( position == 0 && selectDefault) {

            listener.onLevelOneItemClicked(0);
            selectDefault = false;

        }

    }

    @Override
    public int getItemCount() {
        return componentList.size();
    }

    public interface OnItemClickListener {

        void onLevelOneItemClicked(int position);

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_product)
        RelativeLayout layout;
        @BindView(R.id.item_iv_product_image)
        ImageView imageView;
        @BindView(R.id.item_tv_product_name)
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
