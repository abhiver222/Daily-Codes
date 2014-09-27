//parking lot question from amazon interview
//tried to improvise using linked lists
//have to make improvements
// combined with my linker class

import java.util.*;



public class parkinglot extends linker{
	
	static Scanner sc = new Scanner(System.in);
	linker lot1 = new linker();
	linker lot2 = new linker();
	linker lot3 = new linker();
	
	
	public static void main(String[] args){
		
		
		System.out.println("Welcome to the parking lot");
		System.out.println("There are 3 lanes here");
		@SuppressWarnings("unused")
		parkinglot[] loter = new parkinglot[3];
		loter[0] = new parkinglot();
		loter[1] = new parkinglot();
		loter[2] = new parkinglot();
		
		boolean val=true;
		while(val){
		
		int lotno=0;
		System.out.println("Which lot do you want to access (press 0 for exiting)");
		lotno=sc.nextInt();
		switch(lotno){
		case 1:
			
			loter[0].newlotcreatorforl1(lotno);
			break;
		case 2:
			parkinglot l2 = new parkinglot();
			loter[1].newlotcreatorforl2(lotno);
			break;
		case 3:
			parkinglot l3 = new parkinglot();
			loter[2].newlotcreatorforl3(lotno);
			break;
		case 0:
			val=false;
			break;
		}
		}
	}
	
	public void newlotcreatorforl1(int lotno){
		boolean val = true;
		while (val){
		int what=0;
		System.out.println("what do you want to do?");
		System.out.println("1)Add new car");
		System.out.println("2)add new car at some specific position");
		System.out.println("3)remove car");
		System.out.println("4)get number of cars");
		System.out.println("5)get car number at position");
		System.out.println("6)exit the lot");
		System.out.println("7)print current lot");
		what = sc.nextInt();
		switch(what){
			case 1:
				int no=0;
				System.out.println("enter car number");
				no=sc.nextInt();
				lot1.add(no);
				break;
			case 2:
				int no2=0;
				int pos=0;
				System.out.println("enter car number");
				no2=sc.nextInt();
				System.out.println("enter car position");
				pos=sc.nextInt();
				lot1.add(no2,pos);
				break;
			case 3:
				int no3=0;
				System.out.println("enter car position");
				no3=sc.nextInt();
				lot1.remove(no3);
				break;
			case 4:
				int no4=0;
				no4=lot1.size();
				System.out.println(no4);
				break;
			case 5:
				int no5=0;
				int index=0;
				System.out.println("enter car index");
				index=sc.nextInt();
				no5=lot1.get(index);
				System.out.println("Car number at "+index+" is " +no5);
				break;
			case 6:
				val=false;
				return;
			case 7:
				lot1.printer();
				break;
		}
		
		}
	}
	
	public void newlotcreatorforl2(int lotno){
		boolean val = true;
		while(val){
		int what=0;
		System.out.println("what do you want to do?");
		System.out.println("1)Add new car");
		System.out.println("2)add new car at some specific position");
		System.out.println("3)remove car");
		System.out.println("4)get number of cars");
		System.out.println("5)get car number at position");
		System.out.println("6)exit the lot");
		System.out.println("7)print current lot");

		what = sc.nextInt();
		switch(what){
			case 1:
				int no=0;
				System.out.println("enter car number");
				no=sc.nextInt();
				lot2.add(no);
				break;
			case 2:
				int no2=0;
				int pos=0;
				System.out.println("enter car number");
				no2=sc.nextInt();
				System.out.println("enter car position");
				pos=sc.nextInt();
				lot2.add(no2,pos);
				break;
			case 3:
				int no3=0;
				System.out.println("enter car position");
				no3=sc.nextInt();
				lot2.remove(no3);
				break;
			case 4:
				int no4=0;
				no4=lot2.size();
				System.out.println(no4);
				break;
			case 5:
				int no5=0;
				int index=0;
				System.out.println("enter car index");
				index=sc.nextInt();
				no5=lot2.get(index);
				System.out.println("Car number at "+index+" is " +no5);
				break;
			case 6:
				val=false;
				return;
			case 7:
				lot1.printer();
				break;	
		}
		
		}
	}
	
	public void newlotcreatorforl3(int lotno){
		boolean val = true;
		while(val){
		int what=0;
		System.out.println("what do you want to do?");
		System.out.println("1)Add new car");
		System.out.println("2)add new car at some specific position");
		System.out.println("3)remove car");
		System.out.println("4)get number of cars");
		System.out.println("5)get car number at position");
		System.out.println("6)exit the lot");
		System.out.println("7)print current lot");

		what = sc.nextInt();
		switch(what){
			case 1:
				int no=0;
				System.out.println("enter car number");
				no=sc.nextInt();
				lot3.add(no);
				break;
			case 2:
				int no2=0;
				int pos=0;
				System.out.println("enter car number");
				no2=sc.nextInt();
				System.out.println("enter car position");
				pos=sc.nextInt();
				lot3.add(no2,pos);
				break;
			case 3:
				int no3=0;
				System.out.println("enter car position");
				no3=sc.nextInt();
				lot3.remove(no3);
				break;
			case 4:
				int no4=0;
				no4=lot3.size();
				System.out.println(no4);
				break;
			case 5:
				int no5=0;
				int index=0;
				System.out.println("enter car index");
				index=sc.nextInt();
				no5=lot3.get(index);
				System.out.println("Car number at "+index+" is " +no5);
				break;
			case 6:
				val=false;
				return;
			case 7:
				lot1.printer();
				break;	
		}
		}
		
	}
}
