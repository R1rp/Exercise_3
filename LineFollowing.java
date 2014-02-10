import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;


public class LineFollowing extends MotorRun{

	private static LightSensor light;
	private static MotorRun motor;
	private final static int black = 400;
	private static UltrasonicSensor sensor;
	
	
	public static void main(String[] args) {
		System.out.println("line following");
		Button.waitForAnyPress();
		int degree = 2;
		light = new LightSensor(SensorPort.S2);
		motor = new MotorRun();
		sensor = new UltrasonicSensor(SensorPort.S1); 

		Delay.msDelay(500);
		while(light.readNormalizedValue()>black)
		{
			motor.forward();
			if(sensor.getDistance()<20)
			{
				motor.AdjLeft(150);
			}
		}
		
		
		
		while(true){
			
			if(light.readNormalizedValue()<=black){
				motor.forward();
				Thread.yield();
				degree=2;
				
			}
			if(light.readNormalizedValue()>black){
					
					
					motor.AdjLeft(degree);
					Thread.yield();
					degree=degree+2;
					
			}
			if(light.readNormalizedValue()>black){
					
					motor.AdjRight(degree);
					Thread.yield();
					degree=degree+2;;
										
				}
			
					
		}
	}
}


