import java.util.ArrayList;

public class SelectionSort {
	
	int size;
	ArrayList<Bars> list1;
	int index=0;
	
	
	public SelectionSort(ArrayList<Bars> rec, int size) {
		list1 = rec;
		this.size = size;
	}

	
	public int nextStep() {
		
		if(index<size) {
			Bars min = list1.get(index);
			int minIndex = index;
			for(int i = index; i<list1.size(); i++) {
				if(list1.get(i).getHeight() <= min.getHeight()) {
					min = list1.get(i);
					minIndex = i;
				}
			}
			
			list1.remove(minIndex);
			list1.add(index, min);
			index++;
			
			return 1;

		}
		
		return -1;
	}
	
	public ArrayList<Bars> getList(){
		
		return list1;
	}
}
