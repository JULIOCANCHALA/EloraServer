package com.canchala.julio.eloraserver;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Menu extends ListFragment implements OnItemClickListener {

	String[] txt1;
	String[] txt2;
	TypedArray menuIcons;


	CustomAdapter adapter;
	private List<RowItem> rowItems;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.list_fragment, null, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {

		super.onActivityCreated(savedInstanceState);

		txt1 = getResources().getStringArray(R.array.txts1);
		txt2 = getResources().getStringArray(R.array.txts2);
		menuIcons = getResources().obtainTypedArray(R.array.icons);

		rowItems = new ArrayList<RowItem>();

		for (int i = 0; i < txt1.length; i++) {
			RowItem items = new RowItem(txt1[i],txt2[i],menuIcons.getResourceId(i, -1));
			rowItems.add(items);
		}

		adapter = new CustomAdapter(getActivity(), rowItems);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		Toast.makeText(getActivity(), txt1[position], Toast.LENGTH_SHORT).show();

		Intent intent=null;

		if(position==0){intent=new Intent(getContext(),Ingresarproducto.class);	}
        if(position==1){intent=new Intent(getContext(),Eliminarproducto.class);	}
        if(position==2){intent=new Intent(getContext(),Listar.class);}
		startActivity(intent);

	}

}
