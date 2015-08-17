package hoona.zaid.featuresdemo.dataFragment.fragment;

import android.app.Fragment;
import android.os.Bundle;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by zaid on 18/7/15.
 */
public class DataFragment extends Fragment implements DataStore {
    private final Map<String, Bundle> data;

    public DataFragment() {
        super();
        data = new Hashtable<>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public boolean isDataPresent(String id) {
        return data.containsKey(id);
    }

    @Override
    public void addData(String id, Bundle bundle) {
        data.put(id, bundle);
    }

    @Override
    public Bundle getData(String id) {
        Bundle bundle = null;
        if (isDataPresent(id)) {
            bundle = data.get(id);
            data.remove(id);
        }
        return bundle;
    }
}
