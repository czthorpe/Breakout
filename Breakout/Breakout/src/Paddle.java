import java.awt.Rectangle;

public class Paddle {

	private int paddleX, paddleY, speed, left, right, top, bottom;
	public final int width = 94, height = 14;
	public Rectangle rect;

	public Paddle() {
		paddleX = 444;
		paddleY = 440;
		speed = 0;

		left = paddleX;
		right = paddleX + width;

		top = paddleY;
		bottom = paddleY + height;
		
		rect = new Rectangle(paddleX, paddleY, width, height);

	}

	public void update() {

		paddleX += speed;

		if (paddleX < 0)
			paddleX = 0;
		else if (paddleX > 906)
			paddleX = 906;

		left = paddleX;
		right = left + width;
		
		rect.setRect(paddleX, paddleY, width, height);
	}

	public void moveLeft() {
		speed = -10;

	}

	public void moveRight() {
		speed = 10;
	}

	public void stop() {
		speed = 0;
	}

	public int getPaddleX() {
		return paddleX;
	}

	public int getPaddleY() {
		return paddleY;
	}
	

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public int getSpeed() {
		return speed;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public int getTop() {
		return top;
	}

	public int getBottom() {
		return bottom;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	

	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}

	public void setPaddleY(int paddleY) {
		this.paddleY = paddleY;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

}
