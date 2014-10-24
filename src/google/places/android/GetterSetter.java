package google.places.android;

public class GetterSetter {
	String name, rating, vicinity, lon, lat;

	public void setName(String name) {
		this.name = name;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getName() {
		return name;
	}

	public String getRating() {
		return rating;
	}

	public String getVicinity() {
		return vicinity;
	}

	public String getLat() {
		return lat;

	}

	public String getLon() {
		return lon;

	}

	@Override public String toString() {
		return (this.getName() + this.getRating() + this.getVicinity());
	}
}
