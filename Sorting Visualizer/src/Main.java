import javax.swing.*;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Main {

	private JFrame window;

	private JPanel cardPanel;

	private DrawingSurface panel2;

	private PSurfaceAWT.SmoothCanvas processingCanvas;

	public Main() {
		panel2 = new DrawingSurface();
		PApplet.runSketch(new String[] { "" }, panel2);

		PSurfaceAWT surf = (PSurfaceAWT) panel2.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame) processingCanvas.getFrame();

		window.setBounds(0, 0, 1500, 1000);
		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);

		window.getContentPane().removeAll();

		cardPanel.add(processingCanvas, "2");

		window.setLayout(new BorderLayout());

		window.add(cardPanel);
		window.revalidate();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}

	public void changePanel() {
		((CardLayout) cardPanel.getLayout()).next(cardPanel);
		processingCanvas.requestFocus();
	}

}