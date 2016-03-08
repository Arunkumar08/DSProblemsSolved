package arun.problems.lift;

public class LiftStatus {

	private Status lifTStatus = Status.STATIC;
	
	private final Integer liftId;
	
	public LiftStatus(final Integer id) {
		this.liftId = id;
	}

	public Status getLifTStatus() {
		return lifTStatus;
	}

	public void setLifTStatus(Status lifTStatus) {
		this.lifTStatus = lifTStatus;
	}

	public Integer getLiftId() {
		return liftId;
	}
}
