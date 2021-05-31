package in.nilapps.machinetest.modules.category;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import in.nilapps.machinetest.R;
import in.nilapps.machinetest.common.BaseActivity;
import in.nilapps.machinetest.common.data.models.Component;
import in.nilapps.machinetest.common.data.models.Level2;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class CategoryActivity extends BaseActivity implements CategoryContract.View,
        LevelOneListAdapter.OnItemClickListener, BaseActivity.NetworkListener, View.OnClickListener {

    @BindView(R.id.errorLayout)
    RelativeLayout errorLayout;
    @BindView(R.id.btnTryAgain)
    Button btnTryAgain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rvLevelOne)
    RecyclerView rvLevelOne;
    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.rvLevelTwo)
    RecyclerView rvLevelTwo;
    @BindView(R.id.progressLayout)
    RelativeLayout progressLayout;
    @BindView(R.id.layoutProduct)
    LinearLayout layoutProduct;
    @BindView(R.id.tvNoDataFoundMain)
    TextView tvNoDataFoundMain;
    @BindView(R.id.tvNoDataFound)
    TextView tvNoDataFound;

    private String TAG = getClass().getSimpleName();

    CategoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catogory);

        init();

        if (hasConnectivity()) {
            presenter = new CategoryPresenter(this, this);
            presenter.callCategoryDataFromServer();
        } else
            PAUSED_ON_NO_NETWORK = true;

    }

    public void init() {

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        btnTryAgain.setOnClickListener(this);

        setNetworkListener(this);
    }

    @Override
    public void onLevelOneItemClicked(int position) {
        presenter.loadLevel2List(position);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNetworkRestored() {

        if (PAUSED_ON_NO_NETWORK) {
            if (presenter.getCategoryData() == null)
                presenter.callCategoryDataFromServer();
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnTryAgain) {
            errorLayout.setVisibility(View.GONE);
            presenter.callCategoryDataFromServer();
        }

    }

    @Override
    public void setLevelOneList(List<Component> componentList) {

        layoutProduct.setVisibility(View.VISIBLE);
        tvNoDataFoundMain.setVisibility(View.GONE);

        LevelOneListAdapter adapter = new LevelOneListAdapter(this, this, componentList);
        rvLevelOne.setAdapter(adapter);
        rvLevelOne.setHasFixedSize(true);
        rvLevelOne.setLayoutManager(new LinearLayoutManager(this));
        rvLevelOne.setItemAnimator(new DefaultItemAnimator());
        rvLevelOne.addItemDecoration(new DividerItemDecoration(rvLevelOne.getContext(), DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onNoLevelOneDataFound() {
        layoutProduct.setVisibility(View.GONE);
        tvNoDataFoundMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void setLevelTwoList(List<Level2> levelList) {

        rvLevelTwo.setVisibility(View.VISIBLE);
        tvNoDataFound.setVisibility(View.GONE);

        CategoryExpandAdapter adapter = new CategoryExpandAdapter(this, levelList);
        rvLevelTwo.setAdapter(adapter);
        rvLevelTwo.setHasFixedSize(true);
        rvLevelTwo.setLayoutManager(new LinearLayoutManager(this));
        rvLevelTwo.setItemAnimator(new DefaultItemAnimator());
        rvLevelTwo.addItemDecoration(new DividerItemDecoration(rvLevelTwo.getContext(), DividerItemDecoration.VERTICAL));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onNoLevelTwoDataFound() {

        rvLevelTwo.setVisibility(View.GONE);
        tvNoDataFound.setVisibility(View.VISIBLE);

    }

    @Override
    public void onUnStableInteraction(int reasonFlag) {
        onUnAuthorizedConnection(reasonFlag);
    }

    @Override
    public void showProgressBar() {
        progressLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgressBar() {
        progressLayout.setVisibility(View.GONE);
    }
}
