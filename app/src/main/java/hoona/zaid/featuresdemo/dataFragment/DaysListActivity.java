package hoona.zaid.featuresdemo.dataFragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hoona.zaid.featuresdemo.R;
import hoona.zaid.featuresdemo.dataFragment.fragment.DataFragment;
import hoona.zaid.featuresdemo.dataFragment.fragment.ListFragment;

/**
 * Created by zaid on 19/7/15.
 */
public class DaysListActivity extends AppCompatActivity {

    public static final String DATA_TAG = "Data";
    ListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty_frame);
        fragment = new ListFragment();

        if (getFragmentManager().findFragmentByTag(DATA_TAG) == null)
            getFragmentManager().beginTransaction().add(new DataFragment(), DATA_TAG).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
