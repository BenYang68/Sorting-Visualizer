import java.util.ArrayList;

public class InsertionSort {
	
	int size;
	ArrayList<Bars> list1;
	int index=0;
	
	public InsertionSort(ArrayList<Bars> rec, int size) {
		this.size=size;
		list1 = rec;
	}
	
	public int nextStep() {
		 

		//System.out.println(index);
		if(index <size) {

			Bars b = list1.get(index);
			
			for( int i =index-1; i>=0 ; i--) {
				if(i==0 && list1.get(index).getHeight()<list1.get(i).getHeight()) {
					list1.remove(index);
					list1.add(0,b);
				}					
				if(list1.get(i).getHeight() <= list1.get(index).getHeight()) {
					list1.remove(index);
					list1.add(i+1,b);
					break;
				}
			}
			
			
			index++;
			return 1;
		}
		
		
		return -1;
	}
	
	
	public ArrayList<Bars> getlist(){
		
		return list1;
	}
	

}
