package hoona.zaid.featuresdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import hoona.zaid.featuresdemo.adapters.MainMenuAdapter;
import hoona.zaid.featuresdemo.adapters.holder.ButtonHolder;
import hoona.zaid.featuresdemo.dataFragment.DaysListActivity;


public class MainActivity extends AppCompatActivity implements ButtonHolder.OnClickListener{

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MainMenuAdapter adapter = new MainMenuAdapter(this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        Intent intent = null;

        switch (button.getText().toString()) {
            case "Data Fragment":
                intent = new Intent(this, DaysListActivity.class);
                break;
        }

        if (intent != null)
            startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        recyclerView.setLayoutManager(null);
        recyclerView.setAdapter(null);
    }
}
