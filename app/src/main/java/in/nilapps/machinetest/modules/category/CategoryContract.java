package in.nilapps.machinetest.modules.category;

import android.content.Context;

import com.android.volley.VolleyError;

import java.util.List;

import in.nilapps.machinetest.common.BasePresenter;
import in.nilapps.machinetest.common.BaseView;
import in.nilapps.machinetest.common.data.models.Category;
import in.nilapps.machinetest.common.data.models.Component;
import in.nilapps.machinetest.common.data.models.Level2;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class CategoryContract {

    interface Model {

        interface OnVolleyResponseListener {

            void onSuccess(Category category);

            void onFailure(VolleyError error);
        }

        void getCategoryDataFromServer(Context context, OnVolleyResponseListener onVolleyResponseListener);

    }

    interface View extends BaseView {

        void setLevelOneList(List<Component> componentList);

        void setLevelTwoList(List<Level2> levelList);

        void onNoLevelOneDataFound();

        void onNoLevelTwoDataFound();

    }

    interface Presenter extends BasePresenter {

        void callCategoryDataFromServer();

        void setCategoryData(Category category);

        void loadLevel2List(int position);

        Category getCategoryData();

    }

}
