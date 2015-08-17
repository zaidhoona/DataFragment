package hoona.zaid.featuresdemo.adapters.holder;

import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import hoona.zaid.featuresdemo.R;

/**
 * View Holder for the main menu. It contains a view holding and click handling for a button
 *
 * Created by zaid on 18/7/15.
 */
public class ButtonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final Button button;
    private final OnClickListener onClickListener;

    public ButtonHolder(View itemView, OnClickListener onClickListener) {
        super(itemView);
        button = (Button) itemView.findViewById(R.id.list_item);
        button.setOnClickListener(this);
        this.onClickListener = onClickListener;
    }

    public void setText(CharSequence text) {
        if (text == null) text = "";
        button.setText(text);
    }

    public void setText(@StringRes int id) {
        button.setText(id);
    }

    @Override
    public void onClick(View v) {
        this.onClickListener.onClick(v);
    }

    public interface OnClickListener {
        void onClick(View view);
    }
}
