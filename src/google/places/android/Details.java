package google.places.android;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.widget.TextView;

public class Details extends SherlockFragmentActivity {
	GoogleMap googleMap;
	TextView nameInDetail, vicinityInDetail, ratingInDetail;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("Detail");

		setContentView(R.layout.details);
		googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
				R.id.mapFragment)).getMap();
		nameInDetail = (TextView) findViewById(R.id.nameInDetail);
		vicinityInDetail = (TextView) findViewById(R.id.vicinityInDetail);
		ratingInDetail = (TextView) findViewById(R.id.ratingInDetail);

		double lat = Double.valueOf((getIntent().getStringExtra("lat")));
		double lon = Double.valueOf((getIntent().getStringExtra("lon")));
		String name = getIntent().getStringExtra("name");
		String vicinity = getIntent().getStringExtra("vicinity");
		String userRating = " " + getIntent().getStringExtra("rating") + "/5";

		LatLng latlong = new LatLng(lat, lon);
		googleMap.addMarker(new MarkerOptions().position(latlong).title(name));
		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlong, 15));
		nameInDetail.setText(name);
		vicinityInDetail.setText(vicinity);
		ratingInDetail.setText(userRating);
	}

	@Override public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
