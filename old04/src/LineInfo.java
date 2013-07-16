
public class LineInfo {
	private String start;
	private String end;
	private int distance;
	
	public LineInfo(String [] data) {
		this.start = data[0];
		this.end = data[1];
		this.distance = Integer.parseInt(data[2]);
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	public String getStart() {
		return start;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEnd() {
		return end;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getDistance() {
		return distance;
	}
}
