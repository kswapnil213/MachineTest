package in.nilapps.machinetest.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.nilapps.machinetest.R;

/**
 * Created by Swapnil G. on 17-04-2021.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.errorLayout)
    RelativeLayout errorLayout;
    @BindView(R.id.errorContentView)
    LinearLayout errorContentView;
    @BindView(R.id.errorMessageTitle)
    TextView errorMessageTitle;
    @BindView(R.id.errorMessageTextView)
    TextView errorMessageTextView;
    @BindView(R.id.noConnectionLayout)
    public LinearLayout noConnectionLayout;
    @BindView(R.id.networkRetryTextView)
    public TextView networkRetryTextView;

    private ConnectivityManager connectivityManager;
    private NetworkListener networkListener;

    public boolean PAUSED_ON_NO_NETWORK = false;

    private String TAG = getClass().getSimpleName();

    private BroadcastReceiver networkDetectReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkInternetConnection();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PAUSED_ON_NO_NETWORK = true;

        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager.getActiveNetworkInfo() == null) {
            return;
        }
    }
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        checkInternetConnection();

        networkRetryTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternetConnection();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(networkDetectReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            unregisterReceiver(networkDetectReceiver);
        } catch (Exception e) {
            LogUtil.info(TAG, e.getMessage());
        }
    }

    public void setNetworkListener(NetworkListener networkListener) {
        this.networkListener = networkListener;
    }

    private void checkInternetConnection() {
        errorLayout.setVisibility(View.GONE);
        noConnectionLayout.setVisibility(View.GONE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!hasConnectivity()) {
                    errorLayout.setVisibility(View.VISIBLE);
                    noConnectionLayout.setVisibility(View.VISIBLE);
                } else {
                    if (networkListener != null) {
                        LogUtil.info(TAG, "checkInternetConnection");
                        networkListener.onNetworkRestored();
                    }
                    errorLayout.setVisibility(View.GONE);
                    noConnectionLayout.setVisibility(View.GONE);
                }
            }
        }, 100);

    }

    public boolean hasConnectivity() {
        connectivityManager.getActiveNetworkInfo();
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    public interface NetworkListener {
        void onNetworkRestored();
    }

    public void onUnAuthorizedConnection(int reasonFlag) {
        errorContentView.setVisibility(View.VISIBLE);

        if (reasonFlag == AppConstants.SERVER_DOWN) {
            errorMessageTitle.setText(R.string.server_maintenance_title);
            errorMessageTextView.setText(R.string.server_down_message);
        } else if (reasonFlag == AppConstants.VOLLEY_TIMEOUT) {
            errorMessageTitle.setText(R.string.timeout_title);
            errorMessageTextView.setText(R.string.timeout_message);
        } else if (reasonFlag == AppConstants.SOMETHING_WRONG) {
            errorMessageTitle.setText(R.string.unexpected_state);
            errorMessageTextView.setText(R.string.something_went_wrong);
        }
    }

    public void goToActivity(Class targetClass, boolean killMe) {
        Intent intent = new Intent(this, targetClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        if (killMe) {
            this.finish();
        }
    }

}
