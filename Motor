import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class MotorRun {

	private static DifferentialPilot pilot = new DifferentialPilot(2.1f,4.4f,Motor.B,Motor.A);
	
	
	public MotorRun(){
		pilot.setTravelSpeed(7);
		pilot.setRotateSpeed(1000);
		
	}

	public void AdjLeft(int degree)
	{
		pilot.rotate(degree);
	}
	public void AdjRight(int degree)
	{
		
		pilot.rotate(-degree);
	}
	
	public void TurnLeft()
	{
		pilot.rotateLeft();
	}
	public void TurnRight()
	{
		pilot.rotateRight();
	}
	public void forward()
	{
		
		pilot.forward();
			
	}
	
	public void backward(){
		pilot.backward();
	}
	
	public void stop(){
		pilot.stop();
	}
}
