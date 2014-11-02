
public class mazechecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mazesolver maze1 = new mazesolver();
		maze1.printmaze();
		
		if(maze1.findpath(0, 0)){
			System.out.println("The maze has been solved");
			System.out.println();
			maze1.printmaze();
		}
		else{
			
			System.out.println("Maze couldnt be solved");
			System.out.println();
			maze1.printmaze();
		}
	}

}
