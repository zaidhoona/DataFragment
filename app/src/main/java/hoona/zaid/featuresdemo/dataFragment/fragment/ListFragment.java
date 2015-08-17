package hoona.zaid.featuresdemo.dataFragment.fragment;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import hoona.zaid.featuresdemo.R;
import hoona.zaid.featuresdemo.adapters.holder.ListAdapter;
import hoona.zaid.featuresdemo.dataFragment.DaysListActivity;
import hoona.zaid.featuresdemo.loader.DataLoader;

/**
 * Created by zaid on 19/7/15.
 */
public class ListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<String>> {
    RecyclerView recyclerView;
    ListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ListAdapter();

        if (getLoaderManager().getLoader(10) == null) {
            getLoaderManager().initLoader(10, null, this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.recycler_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        DataFragment fragment = (DataFragment) getFragmentManager().findFragmentByTag(DaysListActivity.DATA_TAG);
        if (fragment != null) {
            Bundle bundle = new Bundle();
            List<String> list = adapter.getList();
            bundle.putStringArray("Data", list.toArray(new String[list.size()]));
            fragment.addData("MyData", bundle);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        DataFragment fragment = (DataFragment) getFragmentManager().findFragmentByTag(DaysListActivity.DATA_TAG);
        if (fragment != null && fragment.isDataPresent("MyData")) {
            Bundle bundle = fragment.getData("MyData");
            String[] array = bundle.getStringArray("Data");
            adapter.setList(Arrays.asList(array));
        }
    }

    @Override
    public Loader<List<String>> onCreateLoader(int id, Bundle args) {
        return new DataLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> data) {
        adapter.setList(data);
    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {
        adapter.setList(null);
    }
}
