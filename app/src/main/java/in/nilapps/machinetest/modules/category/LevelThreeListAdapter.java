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
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nilapps.machinetest.R;
import in.nilapps.machinetest.common.data.models.Level2;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class LevelThreeListAdapter extends RecyclerView.Adapter<LevelThreeListAdapter.ViewHolder> {

    private List<Level2> filterLevelList;
    private List<Level2> levelList;
    private Context context;
    private Random random;
    private String TAG = getClass().getSimpleName();

    public LevelThreeListAdapter(Context context, List<Level2> originalLevelList) {
        this.filterLevelList = originalLevelList;
        this.levelList = originalLevelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_level_one, parent, false);
        random = new Random();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(filterLevelList.get(position).title);
        Picasso.get()
                .load(getTempImage())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_error_icon)
                .fit()
                .into(holder.imageView);
    }

    //Temporary images has been set as Level 3 images not available
    private String getTempImage() {

        int randomNum = random.nextInt(5 - 1 + 1) + 1;

        switch (randomNum) {
            case 1: return "https://demedia.hayatmart.com/pub/media/catalog/category/6.jpg";
            case 2: return "https://demedia.hayatmart.com/pub/media/catalog/category/7.jpg";
            case 3: return "https://demedia.hayatmart.com/pub/media/catalog/category/8.jpg";
            case 4: return "https://demedia.hayatmart.com/pub/media/catalog/category/1.jpg";
            case 5: return "https://demedia.hayatmart.com/pub/media/catalog/category/4.jpg";
            default: return "https://demedia.hayatmart.com/pub/media/catalog/category/2.jpg";
        }

    }

    @Override
    public int getItemCount() {
        return filterLevelList.size();
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
