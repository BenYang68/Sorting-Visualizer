import java.awt.Color;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet implements ActionListener, MouseListener {

	public static final int DRAWING_WIDTH = 1500;
	public static final int DRAWING_HEIGHT = 1200;

	int QuickSortX = DRAWING_WIDTH / 6;
	int MergeSortX = DRAWING_WIDTH / 6;
	int SelectionSortX = DRAWING_WIDTH / 2;
	int InsertionSortX = DRAWING_WIDTH / 2;
	int HeapSortX = 5 * DRAWING_WIDTH / 6;
	int BubbleSortX = 5 * DRAWING_WIDTH / 6;

	int QuickSortY = DRAWING_HEIGHT / 4;
	int MergeSortY = 3 * DRAWING_HEIGHT / 5;
	int SelectionSortY = DRAWING_HEIGHT / 4;
	int InsertionSortY = 3 * DRAWING_HEIGHT / 5;
	int HeapSortY = DRAWING_HEIGHT / 4;
	int BubbleSortY = 3 * DRAWING_HEIGHT / 5;
	int size = 300;
	int stage = 1;
	int SortingMethod;
	int NumRects = 100;
	boolean started = true, end = true;
	long startTime = 0;
	long EndTime = 0;

	ArrayList<Bars> BarList = new ArrayList<Bars>();
	InsertionSort insertion;
	HeapSort heapSort;
	MergeSort MergeSort;
	SelectionSort SelectionSort;

	/**
	 * Constructor to add obstacles and initialize bullets
	 */
	public DrawingSurface() {
		super();
		newBars();
	}

	public void newBars() {
		BarList = new ArrayList<Bars>();
		for (int i = 0; i < NumRects; i++) {
			BarList.add(new Bars(250 + i * 10, 300, (int) (Math.random() * 600), 10));
		}
	}

	public void setup() {
		textSize(64);
		textAlign(CENTER);

		fill(0, 0, 0);
		text("Sorting Visualizer", width / 2, 90);

		fill(200, 200, 200);
		ellipse(QuickSortX, QuickSortY, size, size);
		ellipse(MergeSortX, MergeSortY, size, size);
		ellipse(SelectionSortX, SelectionSortY, size, size);
		ellipse(InsertionSortX, InsertionSortY, size, size);
		ellipse(HeapSortX, HeapSortY, size, size);
		ellipse(BubbleSortX, BubbleSortY, size, size);

		textSize(40);
		fill(0, 0, 0);
		text("Quick Sort", QuickSortX, QuickSortY);
		text("Merge Sort", MergeSortX, MergeSortY);
		text("Selection Sort", SelectionSortX, SelectionSortY);
		text("Insertion Sort", InsertionSortX, InsertionSortY);
		text("Heap Sort", HeapSortX, HeapSortY);
		text("Bubble Sort", BubbleSortX, BubbleSortY);
		ellipseMode(CENTER);
	}

	/**
	 * Prompts player to choose character, then starts running the game
	 */
	public void draw() {

		try {
			Thread.sleep(50);
		} catch (InterruptedException ex) {
		}

		if (stage == 1) {

			background(250);
			setup();

			if (overCircle1(QuickSortX, QuickSortY, size)) {
				fill(0, 250, 0);
				text("Quick Sort", QuickSortX, QuickSortY);
				if (mousePressed) {
					stage = 2;
					SortingMethod = 1;
				}
			} else if (overCircle1(MergeSortX, MergeSortY, size)) {
				fill(0, 250, 0);
				text("Merge Sort", MergeSortX, MergeSortY);
				if (mousePressed) {
					stage = 2;
					SortingMethod = 2;
				}
			} else if (overCircle1(SelectionSortX, SelectionSortY, size)) {
				fill(0, 250, 0);
				text("Selection Sort", SelectionSortX, SelectionSortY);
				if (mousePressed) {
					stage = 2;
					SortingMethod = 3;
				}
			} else if (overCircle1(InsertionSortX, InsertionSortY, size)) {
				fill(0, 250, 0);
				text("Insertion Sort", InsertionSortX, InsertionSortY);
				if (mousePressed) {
					stage = 2;
					SortingMethod = 4;
				}
			} else if (overCircle1(HeapSortX, HeapSortY, size)) {
				fill(0, 250, 0);
				text("Heap Sort", HeapSortX, HeapSortY);
				if (mousePressed) {
					stage = 2;
					SortingMethod = 5;
				}
			} else if (overCircle1(BubbleSortX, BubbleSortY, size)) {
				fill(0, 250, 0);
				text("Bubble Sort", BubbleSortX, BubbleSortY);
				if (mousePressed) {
					stage = 2;
					SortingMethod = 6;
				}
			}

		}
		if (stage == 2) {
			background(250, 250, 250);

			ellipse(DRAWING_WIDTH / 2, 200, 150, 150);
			fill(250, 0, 0);
			text("START", DRAWING_WIDTH / 2, 210);
			setBackButton();

			if (overCircle1(DRAWING_WIDTH / 2, 200, 150)) {
				fill(0, 250, 0);
				text("START", DRAWING_WIDTH / 2, 210);
				if (mousePressed) {
					stage = 3;
				}
			}

			fill(0, 0, 0);

			switch (SortingMethod) {
			case 1: {
				text("Quick Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			case 2: {
				text("Merge Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			case 3: {
				text("Selection Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			case 4: {
				text("Insertion Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			case 5: {
				text("Heap Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			case 6: {
				text("Bubble Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			}

			fill(0, 0, 0);
			displayBars();
		}
		if (stage == 3) {

			background(250, 250, 250);
			setBackButton();

			switch (SortingMethod) {
			case 1: {
				text("Quick Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			case 2: {
				runMerge();
				break;
			}
			case 3: {
				runSelection();
				break;
			}
			case 4: {
				runInsertion();
				break;
			}
			case 5: {
				runHeap();
				break;
			}
			case 6: {
				text("Bubble Sort", DRAWING_WIDTH / 2, 100);
				break;
			}
			}
		}

	}
	
	public void runMerge() {
		if (started) {
			startTime = System.currentTimeMillis();
			MergeSort = new MergeSort(BarList, BarList.size());
			started = false;
		}

		if (heapSort.nextStep() > 0) {
			text("Merge Sort", DRAWING_WIDTH / 2, 100);
			BarList = MergeSort.getlist();
		} else {
			if (end) {
				EndTime = System.currentTimeMillis();
				end = false;
			}
			text("Time completixy: O(NLOG(N))", DRAWING_WIDTH / 2, 100);
			text("That Took: " + (EndTime - startTime) + " Miliseconds", DRAWING_WIDTH / 2, 200);
		}
		displayBars();
	}


	public void runHeap() {
		// background(250,250,250);
		if (started) {
			startTime = System.currentTimeMillis();
			heapSort = new HeapSort(BarList, BarList.size());
			started = false;
		}

		if (heapSort.nextStep() > 0) {
			text("Heap Sort", DRAWING_WIDTH / 2, 100);
			BarList = heapSort.getList();
		} else {
			if (end) {
				EndTime = System.currentTimeMillis();
				end = false;
			}
			text("Time completixy: O(NLOG(N))", DRAWING_WIDTH / 2, 100);
			text("That Took: " + (EndTime - startTime) + " Miliseconds", DRAWING_WIDTH / 2, 200);
		}
		displayBars();
	}

	public void runInsertion() {
		if (started) {
			startTime = System.currentTimeMillis();
			insertion = new InsertionSort(BarList, BarList.size());
			started = false;
		}

		if (insertion.nextStep() > 0) {

			text("Insertion Sort", DRAWING_WIDTH / 2, 100);
			BarList = insertion.getlist();
		} else {
			if (end) {
				EndTime = System.currentTimeMillis();
				end = false;
			}
			text("Time completixy: O(N^2)", DRAWING_WIDTH / 2, 100);
			text("That Took: " + (EndTime - startTime) + " Miliseconds", DRAWING_WIDTH / 2, 200);
		}
		displayBars();
	}

	public void runSelection() {
		if (started) {
			startTime = System.currentTimeMillis();
			SelectionSort = new SelectionSort(BarList, BarList.size());
			started = false;
		}

		if (SelectionSort.nextStep() > 0) {

			text("Selection Sort", DRAWING_WIDTH / 2, 100);
			BarList = SelectionSort.getList();
		} else {
			if (end) {
				EndTime = System.currentTimeMillis();
				end = false;
			}
			text("Time completixy: O(N^2)", DRAWING_WIDTH / 2, 100);
			text("That Took: " + (EndTime - startTime) + " Miliseconds", DRAWING_WIDTH / 2, 200);
		}
		displayBars();
	}

	public void displayBars() {

		for (int i = 0; i < BarList.size(); i++) {
			if (i % 2 == 0)
				fill(0, 0, 0);
			else
				fill(0, 0, 200);

			rect(250 + i * 10, 300, 10, BarList.get(i).getHeight());
		}

		fill(0, 0, 0);

	}

	public void setBackButton() {
		text("Back", 90, 90);
		if (overCircle1(90, 90, 100)) {
			fill(0, 250, 0);
			text("Back", 90, 90);
			if (mousePressed) {
				stage -= 1;
				newBars();
				started = true;
				end = true;
			}
		}
		fill(0, 0, 0);

	}

	/**
	 * draws the the start screen
	 */
	public void startScreen() {

	}

	boolean overCircle1(int x, int y, int diameter) {
		float disX = x - mouseX;
		float disY = y - mouseY;
		if (sqrt(sq(disX) + sq(disY)) < diameter / 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * represents all the keys that get pressed
	 */
	public void keyPressed() {
	}

	/**
	 * Determines wether or not to fire bullet based on which keys are pressed
	 */
	public void keyReleased() {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
