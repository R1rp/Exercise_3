import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;


	public class Part2 extends MotorRun{

		private static LightSensor light,light2;
		private static MotorRun motor;
		private final static int black = 400;
		private static UltrasonicSensor sensor;
		final static int distance = 20;
		
		
	public static void main(String[] args) {
		System.out.println("Part2");
		Button.waitForAnyPress();
		int degree = 1;
		light = new LightSensor(SensorPort.S2);
		light2 = new LightSensor(SensorPort.S3);
		sensor = new UltrasonicSensor(SensorPort.S1); 
		motor = new MotorRun();
		boolean cross = false;
		int path = 0;

		Delay.msDelay(500);
		
		
		while(true){
			if(sensor.getDistance()>distance){
				if(light.readNormalizedValue()<=black){
					motor.forward();
					Thread.yield();
					degree=1;
					
				}
				if(light.readNormalizedValue()>black){
						
						
						motor.AdjLeft(degree);
						Thread.yield();
						degree++;
						
				}
				if(light.readNormalizedValue()>black){
						
						motor.AdjRight(degree);
						Thread.yield();
						degree++;
											
				}
				
				if(light2.getNormalizedLightValue()<=black)
				{
					cross = true;
					motor.stop();
					if(cross)
					{
						if(path==1|path==3|path==4)
						{
							motor.AdjLeft(90);
							motor.forward();
							Delay.msDelay(200);
							cross=false;
						}
						if(path==2|path==5|path==6)
						{
							motor.AdjRight(90);
							motor.forward();
							Delay.msDelay(200);
							cross=false;
						}
						path++;
						if(path==6)
						{
							path=0;
						}
					}
					
				}
			}
			else
			{
				while(light2.getNormalizedLightValue()>black)
				{
					motor.backward();
				}
			}
		}
			
	}			

}

