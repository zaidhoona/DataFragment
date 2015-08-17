package hoona.zaid.featuresdemo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hoona.zaid.featuresdemo.R;
import hoona.zaid.featuresdemo.adapters.holder.ButtonHolder;

/**
 * Created by zaid on 18/7/15.
 */
public class MainMenuAdapter extends RecyclerView.Adapter<ButtonHolder> {

    private final String[] modules;
    private final ButtonHolder.OnClickListener onClickListener;

    public MainMenuAdapter(Context context, ButtonHolder.OnClickListener onClickListener) {
        modules = context.getResources().getStringArray(R.array.main_menu_items);
        this.onClickListener = onClickListener;
    }

    @Override
    public ButtonHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_button, viewGroup, false);
        return new ButtonHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(ButtonHolder buttonHolder, int position) {
        buttonHolder.setText(modules[position]);
    }

    @Override
    public int getItemCount() {
        return modules.length;
    }
}
