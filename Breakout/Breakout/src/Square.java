import java.awt.Image;
import java.awt.Rectangle;

public class Square {

	private int squareX, squareY, type, left, right, top, bottom;
	private Image squareImage;
	public final int height = 22, width = 56;
	public Rectangle rect;

	public Square(int squareX, int squareY, int type) {
		this.squareX = squareX * width + StartingClass.startX;
		this.squareY = squareY * height + StartingClass.startY;
		this.type = type;

		switch (type) {

		case 1:
			squareImage = StartingClass.blueblock;
			break;
		case 2:
			squareImage = StartingClass.greenblock;
			break;
		case 3:
			squareImage = StartingClass.purpleblock;
			break;
		case 4:
			squareImage = StartingClass.redblock;
			break;

		}

		left = squareX;
		right = left + width;

		top = squareY;
		bottom = top + height;
		
		rect = new Rectangle(this.squareX, this.squareY, width, height);
		


	}

	public Rectangle getRect() {
		return rect;
	}


	public void setRect(Rectangle rect) {
		this.rect = rect;
	}


	public int getSquareX() {
		return squareX;
	}

	public int getSquareY() {
		return squareY;
	}

	public int getType() {
		return type;
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

	public Image getSquareImage() {
		return squareImage;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setSquareX(int squareX) {
		this.squareX = squareX;
	}

	public void setSquareY(int squareY) {
		this.squareY = squareY;
	}

	public void setType(int type) {
		this.type = type;
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

	public void setSquareImage(Image squareImage) {
		this.squareImage = squareImage;
	}

}
