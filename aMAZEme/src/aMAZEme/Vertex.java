package aMAZEme;

public class Vertex {
/*int x1;
int y1;
int x2;
int y2;
int wall1;
int wall2;
*/
Cell cell1;
Cell cell2;
public void breakWalls() {
	int dx = cell2.getX() - cell1.getX();
	int dy = cell2.getY() - cell1.getY();
	if (dx == 1){ //cell1 is left to cell2
		cell1.setWallRight(false);
		cell2.setWallLeft(false);
	}
	else if(dx==-1){//cell1 is right to cell2
		cell2.setWallRight(false);
		cell1.setWallLeft(false);
		
	}
	else if(dy==1){//cell1 is above to cell2
		cell2.setWallUp(false);
		cell1.setWallDown(false);
		
	}
	else if(dy==-1){//cell1 is below to cell2
		cell1.setWallUp(false);
		cell2.setWallDown(false);
		
	}
	else {
		throw new Error("No more neighbours");
	}
	// TODO Auto-generated method stub
	
}

}
