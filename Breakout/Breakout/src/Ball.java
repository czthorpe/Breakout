import java.awt.Rectangle;

public class Ball {

	public int ballX, ballY, speedX, speedY;
	public final int width = 20, height = 20;
	public Rectangle lRect, rRect, tRect, bRect;

	public Ball() {

		ballX = 480;
		ballY = 240;
		speedX = random();
		speedY = 2;

		lRect = new Rectangle(ballX-(speedX*5), ballY, speedX*5, height);
		rRect = new Rectangle(ballX + width, ballY, speedX*5, height);
		tRect = new Rectangle(ballX, ballY-(speedY*10), width, speedY*10);
		bRect = new Rectangle(ballX, ballY+height, width, speedY*10);
	

	}

	public void update() {

		if (ballX + speedX < 0 || ballX + speedX >= 980)
			speedX = speedX * -1;
		
		if (ballY + speedY < 0 || ballY + speedY > 460){
			speedY = speedY * -1;
		}
		
		if (speedY > 10)
			speedY = 10;


		ballX += speedX;
		ballY += speedY;

		lRect.setRect(ballX-(speedX*5), ballY, speedX*5, height);
		rRect.setRect(ballX + width, ballY, speedX*5, height);
		tRect.setRect(ballX, ballY-(speedY*10), width, speedY*10);
		bRect.setRect(ballX, ballY+height, width, speedY*10);


	}

	public int random() {
		double random = Math.random() * 10;
		int speed = 0;

		if (random < 1) {
			speed = -5;
		} else if (random < 2) {
			speed = -4;
		} else if (random < 3) {
			speed = -3;
		} else if (random < 4) {
			speed = -2;
		} else if (random < 5) {
			speed = -1;
		} else if (random < 6) {
			speed = 1;
		} else if (random < 7) {
			speed = 2;
		} else if (random < 8) {
			speed = 3;
		} else if (random < 9) {
			speed = 4;
		} else if (random < 10) {
			speed = 5;
		}
		return speed;

	}

	public Rectangle getlRect() {
		return lRect;
	}

	public Rectangle getrRect() {
		return rRect;
	}

	public Rectangle gettRect() {
		return tRect;
	}

	public Rectangle getbRect() {
		return bRect;
	}

	public void setlRect(Rectangle lRect) {
		this.lRect = lRect;
	}

	public void setrRect(Rectangle rRect) {
		this.rRect = rRect;
	}

	public void settRect(Rectangle tRect) {
		this.tRect = tRect;
	}

	public void setbRect(Rectangle bRect) {
		this.bRect = bRect;
	}

	public int getBallX() {
		return ballX;
	}

	public int getBallY() {
		return ballY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setBallX(int ballX) {
		this.ballX = ballX;
	}

	public void setBallY(int ballY) {
		this.ballY = ballY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
