package hoona.zaid.featuresdemo.loader;

import android.content.Context;
import android.content.Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hoona.zaid.featuresdemo.R;

/**
 * Created by zaid on 23/7/15.
 */
public class DataLoader extends Loader<List<String>> {

    private List<String> oldData;

    public DataLoader(Context context) {
        super(context);
        oldData = new ArrayList<>();
    }

    @Override
    protected void onStartLoading() {
//        if (oldData.size() == 0) {
            forceLoad();
//        } else {
//            deliverResult(oldData);
//        }
    }

    @Override
    protected void onForceLoad() {
        String[] array = getContext().getResources().getStringArray(R.array.data_array);
        deliverResult(Arrays.asList(array));
    }

    @Override
    public void deliverResult(List<String> data) {
//        if (oldData != data) {
//            oldData.addAll(data);
//        }

        super.deliverResult(data);
    }
}
