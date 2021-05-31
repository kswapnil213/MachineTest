package in.nilapps.machinetest.modules.category;

import android.content.Context;

import com.android.volley.NoConnectionError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import in.nilapps.machinetest.common.AppConstants;
import in.nilapps.machinetest.common.LogUtil;
import in.nilapps.machinetest.common.data.models.Category;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class CategoryPresenter implements CategoryContract.Presenter, CategoryContract.Model.OnVolleyResponseListener {

    private CategoryContract.View view;
    private CategoryContract.Model model;

    private Context context;
    private Category category;
    private String TAG = getClass().getSimpleName();

    CategoryPresenter(Context context, CategoryContract.View view) {
        this.context = context;
        this.view = view;
        this.model = new CategoryModel();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void callCategoryDataFromServer() {
        view.showProgressBar();
        model.getCategoryDataFromServer(context, this);
    }

    @Override
    public void onSuccess(Category category) {
        if (category != null) {
            LogUtil.printObject(category);

            setCategoryData(category);

            if (category.component.size() > 0)
                view.setLevelOneList(category.component);
            else {
                view.onNoLevelOneDataFound();
            }
        } else {
            view.onUnStableInteraction(AppConstants.SOMETHING_WRONG);
        }
        view.dismissProgressBar();
    }

    @Override
    public void onFailure(VolleyError error) {
        view.dismissProgressBar();
        if (error instanceof TimeoutError) {
            view.onUnStableInteraction(AppConstants.VOLLEY_TIMEOUT);
        } else if (error instanceof NoConnectionError
                || (error.networkResponse != null && error.networkResponse.statusCode == AppConstants.SERVICE_UNAVAILABLE)) {
            view.onUnStableInteraction(AppConstants.SERVER_DOWN);
        } else {
            view.onUnStableInteraction(AppConstants.SOMETHING_WRONG);
        }
    }

    @Override
    public void loadLevel2List(int position) {

        if (getCategoryData().component.get(position).categoryTabData.level2.size() > 0) {
            view.setLevelTwoList(getCategoryData().component.get(position).categoryTabData.level2);
        } else {
            view.onNoLevelTwoDataFound();
        }

    }

    @Override
    public void setCategoryData(Category category) {
        this.category = category;
    }

    @Override
    public Category getCategoryData() {
        return category;
    }
}
