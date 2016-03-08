package arun.problems.lift;

public interface ILift {

	LiftStatus getStatus(final Integer liftNumber);
	
	void startLift();
	
	void stopLift();
	
	void openLift();
	
	void closeLift();
	
	
}
