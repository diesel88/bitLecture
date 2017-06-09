package day13.exam;

public class LocationVO implements Comparable<LocationVO>{
	
	public static LocationVO target;

	private String regionName;
	private double latitude;
	private double longitude;
	
	private double distance;
	
	public LocationVO(String regionName, double latitude, double longitude) {
		this.regionName = regionName;
		this.latitude = latitude;
		this.longitude = longitude;
		
	}

	public String getRegionName() {
		return regionName;
	}
	
	@Override
	public String toString() {
		return "LocationVO [regionName=" + regionName + ", latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
	
	public void calcDistance() {
		double x = Math.abs(latitude - target.latitude);
		double y = Math.abs(longitude - target.longitude);
		distance = Math.sqrt( x * x + y * y);
	}
	

	public double getDistance() {
		return distance;
	}

	@Override
	public int compareTo(LocationVO o) {
		// TODO Auto-generated method stub
		calcDistance();
		if (distance == o.getDistance())return 0;
		return distance > o.getDistance() ? 1 : -1; 
	}
}








