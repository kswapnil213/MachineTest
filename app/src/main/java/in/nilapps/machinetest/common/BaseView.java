package in.nilapps.machinetest.common;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public interface BaseView {

    void onUnStableInteraction(int reasonFlag);

    void showProgressBar();

    void dismissProgressBar();

}
