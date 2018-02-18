package aMAZEme;

public class Cell {
	private boolean[] walls={true,true,true,true};
	//byte[] borders={0,0,0,0};
	byte[] solutions={0,0,0,0};
	byte[] backtrack={0,0,0,0};
	private int x;
	private int y;
	public void printCell(){
		System.out.println(""+walls[0]+"");
		System.out.println(walls[3]+""+walls[1]);
		System.out.println(""+walls[2]+"");
			
	}
	public boolean checkWalls(){
		if(checkWallLeft()&&checkWallRight()&&checkWallUp()&&checkWallDown()){
			return true;
		}else{
			return false;
		}
	}
	public boolean checkWallLeft(){
		return walls[3]==true;
	}	
	public boolean checkWallRight(){
		return walls[1]==true;
	}	
	public boolean checkWallUp(){
		return walls[0]==true;
	}
	public boolean checkWallDown(){
		return walls[2]==true;
	}
	public void setWallLeft(boolean exist) {
		walls[3]=exist;
	}
	public void setWallRight(boolean exist) {
		walls[1]=exist;
	}
	public void setWallUp(boolean exist) {
		walls[0]=exist;
	}
	public void setWallDown(boolean exist) {
		walls[2]=exist;
	}
	public void setX(int x) {
	    this.x = x;
	}
	public void setY(int y) {
	    this.y = y;
	}
	public int getX(){
		return this.x;
		
	}
	public int getY(){
		return this.y;
		
	}
	
	
}

