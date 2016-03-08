package arun.problems.lift;

public enum Status {

	MOVING_UP("Moving Up"),
	MOVING_DOWN("Moving Down"),
	STATIC("Static");
	
	String status;
	private Status(final String status) {
		this.status = status;
	}
}
