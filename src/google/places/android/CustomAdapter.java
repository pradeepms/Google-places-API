package google.places.android;



import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<GetterSetter> {

	Context context;
	ArrayList<GetterSetter> myList;
	int textViewResourceId;
	public CustomAdapter(Context context, int textViewResourceId, List<GetterSetter> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		 this.myList = (ArrayList<GetterSetter>) objects;
		 this.context=context;
		 this.textViewResourceId=textViewResourceId;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View row = convertView;
		TextViewHolder holder = null;
		
		if(row==null){
			LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(textViewResourceId, parent, false);
            
            holder = new TextViewHolder();
            holder.name= (TextView)row.findViewById(R.id.name);
            holder.rating = (TextView)row.findViewById(R.id.rating);
            holder.ratingText=(TextView)row.findViewById(R.id.ratingRext);
            row.setTag(holder);
		}else{
			holder = (TextViewHolder)row.getTag();
		}
		
		holder.name.setText(myList.get(position).name);
		holder.rating.setText(myList.get(position).rating); 
		
		
		return row;
	}
	static class TextViewHolder{
		TextView name;
		TextView rating;
		TextView ratingText;
	}
}
