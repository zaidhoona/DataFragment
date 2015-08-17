package hoona.zaid.featuresdemo.adapters.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import hoona.zaid.featuresdemo.R;

/**
 * Created by zaid on 23/7/15.
 */
public class TextHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView textView;

    public TextHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.list_item);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView) v;
        Toast.makeText(v.getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
