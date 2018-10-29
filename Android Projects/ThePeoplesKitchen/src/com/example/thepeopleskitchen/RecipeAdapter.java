package com.example.thepeopleskitchen;

import java.util.List;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

public class RecipeAdapter extends ArrayAdapter<Recipe>{

	List<Recipe> mData;
	Context mcontext ;
	int mResource;
	
	public RecipeAdapter(Context context, int resource, List<Recipe> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		
		this.mcontext = context;
		this.mData = objects;
		this.mResource = resource;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if(convertView == null)
		{
			LayoutInflater inflator = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflator.inflate(mResource, parent, false);
		
		}
		Recipe recipe1 = mData.get(position);
		
		ImageView iv1 = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView tv1 = (TextView) convertView.findViewById(R.id.ingtextview);
		TextView tv2 = (TextView) convertView.findViewById(R.id.textView2);
		
		Picasso.with(getContext()).load(recipe1.image_url).into(iv1);
		//iv1.setScaleType(ScaleType.CENTER_INSIDE); 
		
		tv1.setText(recipe1.title);
		tv2.setText(recipe1.publisher);
		
		return convertView;
	}
	
	

}
