package BlockBreaker;

public class Ball {
	private int ballX, ballY;
	Thread t= new Thread();
	public Ball()
	{
		ballX=210;
		ballY=275;
	}
	public void move(int x, int y)
	{
		ballX+= x;
		ballY+= y;
		
	}
	public void setBallX(int x)
	{
		ballX=x;
	}
	public void setBallY(int y)
	{
		ballY=y;
	}
	public int getBallX()
	{
		return ballX;
	}
	public int getBallY()
	{
		return ballY;
	}
	
}
