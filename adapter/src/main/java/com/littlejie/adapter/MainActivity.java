package com.littlejie.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.littlejie.adapter.array.ArrayAdapterActivity;
import com.littlejie.adapter.cursor.CursorAdapterActivity;
import com.littlejie.demoutil.ItemInfo;
import com.littlejie.demoutil.Util;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mLv;
    private List<ItemInfo> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLv = (ListView) findViewById(R.id.lv);
        mItems = generateItems();
        mLv.setAdapter(new ArrayAdapter<ItemInfo>(this, android.R.layout.simple_list_item_1, generateItems()));
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Util.startActivity(MainActivity.this, mItems.get(position).getClz());
            }
        });
    }

    private List<ItemInfo> generateItems() {
        List<ItemInfo> items = new ArrayList<>();
        items.add(new ItemInfo("ArrayAdapter Demo", ArrayAdapterActivity.class));
        items.add(new ItemInfo("CursorAdapter Demo", CursorAdapterActivity.class));
        return items;
    }
}
