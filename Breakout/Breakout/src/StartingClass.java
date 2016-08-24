import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class StartingClass extends Applet implements Runnable, KeyListener {

	private Paddle paddle;
	private Ball ball;
	private Image image, player;
	public static Image ball_1, blueblock, greenblock, purpleblock, redblock;
	private URL base;
	private Graphics second;
	public static int startX, startY, leftBound, rightBound, topBound, bottomBound;
	private int arrayLeft, arrayRight, arrayBottom;

	private ArrayList<Square> squareArray = new ArrayList<Square>();

	@Override
	public void init() {
		setSize(1000, 480);
		setBackground(Color.WHITE);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("breakout");
		addKeyListener(this);

		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// do nothing
		}

		player = getImage(base, "data/player.png");
		ball_1 = getImage(base, "data/ball1.png");
		blueblock = getImage(base, "data/blueblock.png");
		greenblock = getImage(base, "data/greenblock.png");
		purpleblock = getImage(base, "data/purpleblock.png");
		redblock = getImage(base, "data/redblock.png");

	}

	@Override
	public void start() {
		paddle = new Paddle();
		ball = new Ball();
		try {
			loadMap("data/bo_map1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread thread = new Thread(this);
		thread.start();
	}

	private void loadMap(String filename) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		int counter = 1, totalColumns = 0;

		while (true) {

			String line = reader.readLine();

			if (line == null) {
				reader.close();
				break;
			}

			if (!line.startsWith("!")) {

				if (line.startsWith("$")) {

					Scanner scanner = new Scanner(line);

					while (scanner.hasNext()) {

						scanner.next();
						startX = scanner.nextInt();
						startY = scanner.nextInt();
					}

					scanner.close();

				}

				if (line.startsWith("~")) {

					int type = 0;
					int rows = 0;
					int columns = 0;

					Scanner scanner = new Scanner(line);

					while (scanner.hasNext()) {
						scanner.next();
						type = scanner.nextInt();
						rows = scanner.nextInt();
						columns = scanner.nextInt();
					}

					for (int y = 0; y < rows; y++) {
						for (int x = 0; x < columns; x++) {

							Square square = new Square(x, counter, type);
							squareArray.add(square);
						}
						counter++;
					}

					scanner.close();
					totalColumns += columns;
				}

			}

		}
		Square square = new Square(0, 0, 0);
		arrayBottom = startY + (square.height * counter);
		arrayLeft = startX;
		arrayRight = startX + (square.width * totalColumns);

	}

	@Override
	public void run() {

		while (true) {
			

			detectCollisions();
			ball.update();
			paddle.update();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void update(Graphics g) {

		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	public void detectCollisions() {

		if (paddle.rect.intersects(ball.gettRect()) || paddle.rect.intersects(ball.getbRect())) {

			ball.setSpeedY(ball.speedY * -1);
			return;

		}

		else if (paddle.rect.intersects(ball.getlRect()) || paddle.rect.intersects(ball.getrRect())) {

			ball.setSpeedX(ball.speedX * -1);
			return;

		}

		for (int i = 0; i < squareArray.size(); i++) {

			Rectangle rect = squareArray.get(i).rect;
			
			if (ball.gettRect().intersects(rect) || ball.getbRect().intersects(rect)) {
				ball.setSpeedY(ball.speedY * -1);
				squareArray.remove(i);
				break;
			}
			
			if (ball.getlRect().intersects(rect) || ball.getrRect().intersects(rect)) {
				ball.setSpeedX(ball.speedX * -1);
				squareArray.remove(i);
				break;
			} 


		}

	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(player, paddle.getPaddleX(), paddle.getPaddleY(), this);
		g.drawImage(ball_1, ball.getBallX(), ball.getBallY(), this);
		
		
		
		paintBlocks(g);
	}

	public void paintBlocks(Graphics g) {

		for (int i = 0; i < squareArray.size(); i++) {
			Square s = (Square) squareArray.get(i);
			g.drawImage(s.getSquareImage(), s.getSquareX(), s.getSquareY(), this);
			g.drawRect((int) s.rect.getX(), (int) s.rect.getY(), (int) s.rect.getWidth(), (int) s.rect.getHeight());

		}

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {

		case KeyEvent.VK_LEFT:
			paddle.moveLeft();
			break;

		case KeyEvent.VK_RIGHT:
			paddle.moveRight();
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			paddle.stop();
			break;
		case KeyEvent.VK_RIGHT:
			paddle.stop();
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
