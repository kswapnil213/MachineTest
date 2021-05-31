package in.nilapps.machinetest.modules.splash;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import in.nilapps.machinetest.R;
import in.nilapps.machinetest.common.BaseActivity;
import in.nilapps.machinetest.modules.category.CategoryActivity;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class SplashActivity extends BaseActivity implements BaseActivity.NetworkListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (hasConnectivity())
            init();
        else
            PAUSED_ON_NO_NETWORK = true;

        setNetworkListener(this);

    }

    private void init() {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                goToActivity(CategoryActivity.class, true);

            }
        }, 2000);

    }

    @Override
    public void onNetworkRestored() {
        if (PAUSED_ON_NO_NETWORK) {
            init();
        }
    }
}
