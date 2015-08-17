package hoona.zaid.featuresdemo.dataFragment.fragment;

import android.os.Bundle;

/**
 * Created by zaid on 18/7/15.
 */
public interface DataStore {
    boolean isDataPresent(String id);
    void addData(String id, Bundle bundle);
    Bundle getData(String id);
}
