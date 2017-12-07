package Components;

import Main.Input;
import Main.KeyCode;
import Systems.ComponentSystem;

public class BoatControllerComponent extends ComponentSystem {

	private float speedX = 1;
	private float speedY = 1;
	
	public BoatControllerComponent(float speedX,float speedY){
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	@Override
	protected void function() {
		float x = 0,y = 0;
		if(Input.GetKey(KeyCode.A)) {
			x-=1;
		}
		if(Input.GetKey(KeyCode.D)) {
			x+=1;
		}
		if(Input.GetKey(KeyCode.W)) {
			y-=1;
		}
		if(Input.GetKey(KeyCode.S)) {
			y+=1;
		}

		gameObject.x += x * speedX;
		gameObject.y += y * speedY;
	}

	@Override
	protected void start() {
		// TODO Auto-generated method stub

	}

}
