
public class linker {
	
		private node head;
		private int listcount;
		 
		public linker(){
			 head = new node(0);
			 listcount=0;
		 }
		 
		 public void add(int adder){
			 node temp = new node(adder);
			 node current = head;
			 while(current.getnext()!=null){
				 current = current.getnext();
			 }
			 current.setnext(temp);
			 listcount++;
		 }
		 
		 public void add(int adder,int index){
			 node temp = new node(adder);
			 node current = head;
			 
			 for(int i=0;i<index && current.getnext()!=null;i++){
				 current = current.getnext();
			 }
			 temp.setnext(current.getnext());
			 current.setnext(temp);
			 listcount++;
		 }
		 
		 public int get (int index){
			 if(index<=0)
				 return 0;
			 node current = head.getnext();
			 for(int i=0;i<index;i++){
				 if(current.getnext()==null)
					 return 0;
				 current = current.getnext();
			 }
			 return current.getdata();
		 }
		 
		 public boolean remove(int index){
			 if(index<1 || index>size())
				 return false;
			 node current = head;
			 for(int i=0;i<index;i++){
				 if(current.getnext()==null)
					 return false;
				 current = current.getnext();
			 }
			 current.setnext(current.getnext().getnext());
			 listcount--;
			 return true;
					 
		 }
		 
		 public int size(){
			 return listcount;
		 }
		 
		 private class node{
			 
			 node next;
			 int data ;
			 
			 public node(int data){
				 next = null;
				 this.data = data;
			 }
			 
			 public int getdata(){
				 return data;
			 }
			 
			 public void setdata(int data){
				 this.data=data;
			 }
			 
			 public node getnext(){
				 return next;
			 }
			 
			 public void setnext(node next){
				 this.next = next;
			 }
			 
			 
		 }
		 
		 public void printer(){
			 node current = head;
			 for(int i=0;i<size()+1;i++){
				 System.out.println(current.getdata());
				 current=current.getnext();
			 }
			 
		 }

		 public static void main(String[] args){
			 linker l1 = new linker();
			 l1.add(1);
			 l1.add(25);
			 l1.printer();
			 
		 }
	
}
