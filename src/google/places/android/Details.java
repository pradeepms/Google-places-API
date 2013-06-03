package google.places.android;



import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends MapActivity {
	MapView mapView;
	TextView nameInDetail, vicinityInDetail, ratingInDetail;
	GeoPoint point;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);

		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);

		double lat = Double.valueOf((getIntent().getStringExtra("lat")));
		double lon = Double.valueOf((getIntent().getStringExtra("lon")));

		point = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));

		// get the MapController object
		MapController controller = mapView.getController();

		// animate to the desired point
		controller.animateTo(point);
		controller.setZoom(15);
		mapView.invalidate();

		nameInDetail = (TextView) findViewById(R.id.nameInDetail);
		vicinityInDetail = (TextView) findViewById(R.id.vicinityInDetail);
		ratingInDetail = (TextView) findViewById(R.id.ratingInDetail);

		nameInDetail.setText(getIntent().getStringExtra("name"));
		vicinityInDetail.setText(getIntent().getStringExtra("vicinity"));
		ratingInDetail.setText(" "+getIntent().getStringExtra("rating") + "/5");
		
		MapOverlay mapOverlay = new MapOverlay();
		List<Overlay> listOverlays = mapView.getOverlays();
		listOverlays.clear();
		listOverlays.add(mapOverlay);
		
		mapView.invalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	private class MapOverlay extends com.google.android.maps.Overlay {
		@Override
		public boolean draw(Canvas canvas, MapView mapView, boolean shadow, long when) {
			// TODO Auto-generated method stub
			super.draw(canvas, mapView, shadow, when);
			
			Point screenPt = new Point();
			mapView.getProjection().toPixels(point, screenPt);
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pin);
			canvas.drawBitmap(bmp, screenPt.x,screenPt.y-50,null);
			
			return true;
		}
	}
}
