package aMAZEme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Path2D;


import javax.swing.JPanel;



@SuppressWarnings("serial")


public class MazeDisplay extends JPanel implements   ActionListener, KeyListener{
	Maze m1;
	int offsetX=10;
	int offsetY=10;
	int cellSize=20;
	
	Integer moveCounter=0;
	
	int pointX,pointY,oldX,oldY;
	boolean erase;
	
	public MazeDisplay(){
		m1=new Maze();
		pointX=offsetX+cellSize/2;
		pointY=offsetY+cellSize/2;
		oldX=pointX;
		oldY=pointY;
		addKeyListener(this);
	
	}
	public MazeDisplay(Maze m2){
		m1=m2;
		pointX=offsetX+cellSize/2;
		pointY=offsetY+cellSize/2;
		oldX=pointX;
		oldY=pointY;
		addKeyListener(this);
	
	}
	public MazeDisplay(Maze m2, int cellSize2){
		m1=m2;
		cellSize=cellSize2;
		pointX=offsetX+cellSize/2;
		pointY=offsetY+cellSize/2;
		oldX=pointX;
		oldY=pointY;
		addKeyListener(this);
	
	}
	public void actionPerformed(ActionEvent e){
		myPrint();
	}
	
	private void myPrint() {
		// TODO Auto-generated method stub
		
	}
	private void doDrawing(Graphics g){
		Graphics2D g2d=(Graphics2D) g;
		
		g2d.setColor(Color.blue);
		
		Dimension size=getSize();
		Insets insets=getInsets();
		

		int w=size.width - insets.left - insets.right;
		int h=size.height -insets.top -insets.bottom;
		
		g2d.setBackground(Color.white);
		g2d.clearRect(0,0,w,h);
		
		Path2D mazeShape=new Path2D.Double();
		
		int x,y;
		
		for(Integer i=0;i<m1.sizeX;i++){
			x=i*cellSize+offsetX;
			for(Integer j=0;j<m1.sizeY;j++){
				y=j*cellSize+offsetY;
				Cell curentCell = m1.cells[i][j];
			if(curentCell.checkWallUp()){
				//mazeShape.moveTo(x, y);
				//mazeShape.lineTo(x+cellSize, y);
				g2d.drawLine(x, y, x+cellSize, y);	
			}
			if(curentCell.checkWallRight()){
				//mazeShape.moveTo(x+cellSize,y);
				//mazeShape.lineTo(x+cellSize, y+cellSize);
				g2d.drawLine(x+cellSize-1, y, x+cellSize-1, y+cellSize);	
			}		
			if(curentCell.checkWallLeft()){
				//mazeShape.moveTo(x,y+cellSize);
				//mazeShape.lineTo(x+cellSize, y+cellSize);
				g2d.drawLine(x, y, x, y+cellSize);	
			}	
			if(curentCell.checkWallDown()){
				//mazeShape.moveTo(x,y);
				//mazeShape.lineTo(x, y+cellSize);
				g2d.drawLine(x, y+cellSize-1, x+cellSize, y+cellSize-1);	
			}	
				

			}
			}
		
	x =(oldX-offsetX-cellSize/2)/cellSize;
	y =(oldY-offsetY-cellSize/2)/cellSize;
	
	if(x>0 && x<m1.sizeX && oldX>pointX && m1.cells[x][y].checkWallLeft()){
		pointX=oldX;
		pointY=oldY;
		
	
	}else if(x>0&&x<m1.sizeX&&oldX<pointX&&m1.cells[x][y].checkWallRight()){
		pointX=oldX;
		pointY=oldY;
	
	}else if(y>0&&y<m1.sizeY&&oldY>pointY&&m1.cells[x][y].checkWallUp()){
			pointX=oldX;
			pointY=oldY;
		}
	else if(y>0 && y<m1.sizeY && oldY<pointY && m1.cells[x][y].checkWallDown()){
			pointX=oldX;
			pointY=oldY;
			}
	if(pointX!=oldX||pointY!=oldY){
		moveCounter++;
		
	}
	g2d.drawString("Moves: "+moveCounter.toString(),m1.sizeX*cellSize+offsetX+20,20);
	g2d.drawString("Move:Arrow Keys", m1.sizeX*cellSize+offsetX+20,40);
	
	if(y==m1.sizeY-1&&x==m1.sizeX-1){
		System.out.println("Gj, you won!!");
		g2d.drawString("Gj, you won!!", m1.sizeX*cellSize+offsetX+20,100);
		
	}
	g.setColor(Color.gray);
	g.fillRect(pointX-2,pointY-2,4,4);
	g.setColor(Color.black);
	g.fillRect(pointX-2,pointY-2,4,4);}
	
	
	
@Override
public void paintComponent(Graphics g){
	super.paintComponent(g);
	doDrawing(g);
	
}
@SuppressWarnings("static-access")
@Override
public void keyPressed(KeyEvent key){
	oldX=pointX;
	oldY=pointY;
	
	if(key.getKeyCode()==key.VK_DOWN){
		pointY=pointY+cellSize;
		if(pointY>getBounds().height){
			pointY=getBounds().height;
		}
	}

	
	if(key.getKeyCode()==key.VK_UP){
		pointY=pointY-cellSize;
		if(pointY<0){
			pointY=0;
		}
	}
	
	if(key.getKeyCode()==key.VK_LEFT){
		pointX=pointX-cellSize;
		if(pointX<0){
			pointX=0;
		}
	}
	
	if(key.getKeyCode()==key.VK_RIGHT){
		pointX=pointX+cellSize;
		if(pointX>getBounds().width){
			pointX=getBounds().width;
		}
	}
	repaint();
	
}
@Override
public void keyReleased(KeyEvent arg0){
	
}
@Override
public void keyTyped(KeyEvent arg0){
	
}

}


	






