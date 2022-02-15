package gui;

import java.util.Random;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.graphics.Point;

public class GUIMainView {
	public static void main(String[] args) {

		// Main Display
		Display display = new Display();

		// Background Color
		Color colorBackground = new Color(display, 242, 242, 242);
		Color colorTitle = new Color(display, 102, 153, 255);

		// System Font Data
		FontData systemFontData = display.getSystemFont().getFontData()[0];

		// Font Bold
		Font fontTitle = new Font(display, systemFontData.getName(), 22, SWT.BOLD);

		// Icon Random Image
		Random rand = new Random();
		int randNum = rand.nextInt(2) + 1;
		Image imageIcon = resize(new Image(display, "./src/img/icon." + randNum + ".png"), 128, 128);

		// Title Height
		int titleHeight = 100;

		// Main Shell
		Shell mainShell = new Shell(display);
		mainShell.setText("잊혀질 단어장");
		mainShell.setMinimumSize(new Point(600, 800));
		mainShell.setImage(imageIcon);
		mainShell.setBackground(colorBackground);

		int x = (display.getBounds().width - mainShell.getSize().x) / 2;
		int y = (display.getBounds().height - mainShell.getSize().y) / 2;
		mainShell.setLocation(x, y);

		// set Title Height
		titleHeight = (mainShell.getSize().y + mainShell.getSize().y / 2) - display.getBounds().height;

//		GridLayout gridLayout = new GridLayout(2, false);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		rowLayout.wrap = false;
		rowLayout.fill = true;
		rowLayout.justify = false;
		rowLayout.center = true;
		mainShell.setLayout(rowLayout);

//		GridData gridData = new GridData(SWT.CENTER, SWT.TOP, true, false);
		// Set Title Location
//		gridData.verticalIndent = (mainShell.getSize().y+mainShell.getSize().y/2) - display.getBounds().height;

		final Label labelTitleImage = new Label(mainShell, SWT.CENTER);
		labelTitleImage.setLayoutData(new RowData(600, titleHeight));
		labelTitleImage.setImage(imageIcon);

		final Label labelTitleText = new Label(mainShell, SWT.CENTER);
		labelTitleText.setLayoutData(new RowData(600, titleHeight));
		labelTitleText.setFont(fontTitle);
		labelTitleText.setForeground(colorTitle);
		labelTitleText.setImage(imageIcon);
		labelTitleText.setText("Welcome back :)");
//		labelTitleText.setLayoutData(gridData);

		// Open Shell
		mainShell.pack();
		mainShell.open();
		while (!mainShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	static Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose(); // don't forget about me!
		return scaled;
	}
}