package aMAZEme;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Maze {
	int sizeX;
	int sizeY;
	Cell[][] cells;

	public Maze() {
		this(25,25);
	}

	public Maze(int x, int y) {
		sizeX = x;
		sizeY = y;
		cells = new Cell[sizeX][sizeY];
		initializeCells();
		generateMaze();
	}
	public void printAllCells(){
		for(int i=0;i<sizeX;i++){
			for(int j=0;j<sizeY;j++){
				System.out.println(i + " " + j);
				cells[i][j].printCell();
				System.out.println("\n");
				
			}
		}
	}

	//N=0, E=1, S=2, W=3
	//Aranjeaza frontierele labirintului
	//Initializeaza toate celulele din multime
	private void initializeCells(){
		for(int i=0 ; i < sizeX ; i++){
			for(int j = 0 ; j < sizeY ; j++){
				cells[i][j]=new Cell();
				cells[i][j].setX(i);
				cells[i][j].setY(j);
				/*if(i==0){
					cells[i][j].borders[0]=1;
				}
				if (j==0){
					cells[i][j].borders[3]=1;
				}
				if(i == sizeX - 1 ){
					cells[i][j].borders[2]=1;
				}
				if(j == sizeY - 1 ){
					cells[i][j].borders[1]=1;
				}*/
				
				
				}
			}
		}

	//N=0, E=1, S=2, W=3
	//Generarea labirintului propriu-zis
	//Am folosit DFS
	private void generateMaze(){
		/*
		 Documentatie:
		 http://www.algosome.com/articles/maze-generation-depth-first.html
		 http://www.migapro.com/depth-first-search/
		 https://www.youtube.com/watch?v=SqqOB2HgGsM&t=62s
		 https://en.wikipedia.org/wiki/Maze_generation_algorithm
		 */
		Random rand=new Random();
		int x=rand.nextInt(sizeX);//locul de start, ales random
		int y=rand.nextInt(sizeY);
		
		Stack<Cell> cellStack=new Stack<Cell>();
		int totalCells=sizeX*sizeY;//nr total de celule
		int visitedCells=1;//contor pentru asigurarea trecerii prin fiecare celula
		Cell curentCell=cells[x][y];//celula curenta
		
		ArrayList<Vertex> neighborCellList=new ArrayList<Vertex>();
		
		Vertex tmpV=new Vertex();
		
		while(visitedCells<totalCells){
			neighborCellList.clear();
			
			tmpV= new Vertex();
			if(y-1 >=0 && cells[x][y-1].checkWalls()==true){
				tmpV.cell1=curentCell;
				
				tmpV.cell2=cells[x][y-1];
				neighborCellList.add(tmpV);
				
			}
			tmpV=new Vertex();
			if(y+1<sizeY&&cells[x][y+1].checkWalls()==true){

				tmpV.cell1=curentCell;
				
				tmpV.cell2=cells[x][y+1];


				neighborCellList.add(tmpV);
				
			}
			tmpV=new Vertex();
			if(x-1>=0 &&cells[x-1][y].checkWalls()==true){

				tmpV.cell1=curentCell;
				
				tmpV.cell2=cells[x-1][y];

				neighborCellList.add(tmpV);
				
			}
			tmpV=new Vertex();
			if(x+1<sizeX&&cells[x+1][y].checkWalls()==true){
				tmpV.cell1=curentCell;
				
				tmpV.cell2=cells[x+1][y];

				neighborCellList.add(tmpV);
				
			}
		
			//daca gaseste o celula vecina nevizitata
			if(neighborCellList.size()>=1){
				//alege aleatoriu un vecin de pe lista
				int r1=rand.nextInt(neighborCellList.size());
				tmpV=neighborCellList.get(r1);
				
				tmpV.breakWalls();
				
				//push the current cell to the stack so it can be revisited 
				cellStack.push(curentCell);
				//Make the new cell the current cell
				curentCell=tmpV.cell2;
				//update x,y
				x=curentCell.getX();
				y=curentCell.getY();
				//Increment the visited cells counter
				visitedCells++;
				//Else get the last cell from the stack and use that as the current cell
			}
			else{
				curentCell=cellStack.pop();
				x=curentCell.getX();
				y=curentCell.getY();
			}
		}
		
		
		//Setam intrarea si iesirea din labirint
		//Setat Start: Coltul din dreapta sus;Finish:Coltul din stanga jos
		cells[0][0].setWallLeft(false);
		cells[x][y].setWallRight(false);

	
	}
}


