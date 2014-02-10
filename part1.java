import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Motor;
import lejos.nxt.Button;




public class part1 {

	final static int distance = 40;
	final static int speed = 500;
	private static UltrasonicSensor sensor;
	
	
	
	public static void main(String[] args){
		sensor = new UltrasonicSensor(SensorPort.S1);
		System.out.println("feedback control");
		Motor.A.setSpeed(speed);
		Motor.B.setSpeed(speed);
		Button.waitForAnyPress();
		while(true){
			Motor.A.forward();
			Motor.B.forward();
			float reading=sensor.getDistance();
			float adjSpeed = (reading-distance)*0.02f*speed;
			Motor.A.setSpeed((int)adjSpeed);
			Motor.B.setSpeed((int)adjSpeed);
			if(reading>=distance-2 && reading<=distance+2)
			{
				Motor.A.stop();
				Motor.B.stop();
			}
			if(reading<distance-10)
			{
				while(reading<40){
					Motor.A.setSpeed(speed);
					Motor.B.setSpeed(speed);
						Motor.A.backward();
						Motor.B.backward();
						
						reading=sensor.getDistance();
				}
			}
			
			
			
			
		}
		
		
		
	}
}

