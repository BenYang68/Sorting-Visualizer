import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HeapSort {
	Queue<Bars> pq = new PriorityQueue<>(
			(a,b) -> b.getHeight()-a.getHeight());
	
	
	List<Bars> res = new ArrayList<>();
	int size;
	int index = 0;
	public HeapSort(List<Bars> list, int size) {
		pq.addAll(list);
		this.size = size;
	}
	public int nextStep() {
		if (pq.isEmpty()) {
			return -1;
		}
		res.add(pq.poll());
		return 1;
	}
	public ArrayList<Bars> getList() {
		ArrayList<Bars> wanted = new ArrayList<Bars>();

		for(Bars b : res)
			wanted.add(0,b);
        java.util.Iterator<Bars> value = pq.iterator(); 
        while (value.hasNext()) { 
            wanted.add(0,value.next());
        } 


		return (ArrayList)wanted;
	}
}