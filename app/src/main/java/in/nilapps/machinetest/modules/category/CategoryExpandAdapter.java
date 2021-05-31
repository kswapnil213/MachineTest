package in.nilapps.machinetest.modules.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nilapps.machinetest.R;
import in.nilapps.machinetest.common.UiUtil;
import in.nilapps.machinetest.common.data.models.Level2;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class CategoryExpandAdapter extends RecyclerView.Adapter<CategoryExpandAdapter.ViewHolder> implements Filterable {

    private List<Level2> filterLevelList;
    private List<Level2> levelList;
    private Context context;
    private static int currentPosition = 0;

    CategoryExpandAdapter(Context context, List<Level2> levelList) {
        this.context = context;
        this.filterLevelList = levelList;
        this.levelList = levelList;
    }

    @NonNull
    @Override
    public CategoryExpandAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_level_two, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvTitle.setText("Item " + (position+1));
        holder.childGridView.setVisibility(View.GONE);

        if (position == currentPosition) {

            GridLayoutManager layoutManager = new GridLayoutManager(context,3);
            holder.childGridView.setLayoutManager(layoutManager);
            holder.childGridView.setHasFixedSize(true);

            LevelThreeListAdapter childAdapter = new LevelThreeListAdapter(context, filterLevelList);
            holder.childGridView.setAdapter(childAdapter);

            holder.ivExpand.setImageResource(R.drawable.ic_expand);
            UiUtil.expand(holder.childGridView, 5);
        } else {
            holder.ivExpand.setImageResource(R.drawable.ic_collapse);
            UiUtil.collapse(holder.childGridView, 5);
        }

        holder.layout.setOnClickListener(view -> {
            currentPosition = position;
            notifyDataSetChanged();
            });
    }

    @Override
    public int getItemCount() {
        return filterLevelList.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                List<Level2> arrayListFilter = new ArrayList<>();

                if(constraint == null|| constraint.length() == 0) {
                    results.count = levelList.size();
                    results.values = levelList;
                } else {
                    for (Level2 product : levelList) {
                        if(product.title.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            arrayListFilter.add(product);
                        }
                    }
                    results.count = arrayListFilter.size();
                    results.values = arrayListFilter;

                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterLevelList = (List<Level2>) filterResults.values;
                notifyDataSetChanged();

                if(filterLevelList.size() == 0) {
                    Toast.makeText(context, context.getResources().getString(R.string.no_data_found), Toast.LENGTH_LONG).show();
                }
            }
        };
        return filter;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_level_two)
        LinearLayout layout;
        @BindView(R.id.item_tv_title)
        TextView tvTitle;
        @BindView(R.id.item_iv_expand)
        ImageView ivExpand;
        @BindView(R.id.childGridView)
        RecyclerView childGridView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
