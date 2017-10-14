package com.example.arif.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String>listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.xExpLV);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this, "Postions = " + i + " " + i1 + " " + l, Toast.LENGTH_SHORT).show();
                return true;
            }
        }) ;

    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("DATA TYPE");
        listDataHeader.add("LOOP");
        listDataHeader.add("STL");
        listDataHeader.add("Algorithms");

        List<String> dataType = new ArrayList<>(), l_p = new ArrayList<>(), st_l = new ArrayList<>(), algo = new ArrayList<>();

        // =========== //
        dataType.add("int Type");
        dataType.add("double Type");
        dataType.add("float Type");
        dataType.add("char Type");

        // =========== //
        l_p.add("for loop");
        l_p.add("while loop");
        l_p.add("do while loop");
        l_p.add("nested loop");

        // ==================//
        st_l.add("vector");
        st_l.add("map");
        st_l.add("sort");
        st_l.add("set");
        st_l.add("pair");

        // ================== //
        algo.add("Bubble Sort");
        algo.add("BFS Algorithm");
        algo.add("DFS Algorithm");
        algo.add("Seive Algorithm");
        algo.add("Hasing Algorithm");
        algo.add("Dijkstra Algorithm");

        listHash.put(listDataHeader.get(0),dataType);
        listHash.put(listDataHeader.get(1),l_p);
        listHash.put(listDataHeader.get(2),st_l);
        listHash.put(listDataHeader.get(3),algo);

    }
}
