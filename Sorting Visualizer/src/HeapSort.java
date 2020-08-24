import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
		return (ArrayList)res;
	}
}