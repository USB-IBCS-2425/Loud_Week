import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

class ImageEditing {
	private JFrame startFrame;
	private JLabel welcomeText;
	public ImageIcon icon;
	public JLabel pixelCol;
	public BufferedImage im;
	public JButton daisyButton;
	public JButton getPixel;
	public JTextField xCoord;
	public JTextField yCoord;
    public JButton change;

    //required filters
    public JButton contrast;
	public JButton highlight;
	public JButton reset;
    
    //optional filters
    public JButton blur;
    public JButton rotate;
    public JButton zoom;
    public JButton saturate;
    public JButton edgedec;

	public JFrame f;
	public JPanel p;
	public JLabel lab;

	public ImageEditing() {
		startFrame = new JFrame("Image Example");
		startFrame.setSize(2000, 2000);
		welcomeText = new JLabel("Welcome to the Image Example", JLabel.CENTER);
		welcomeText.setBounds(100, 50, 200, 40);

		startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

        startFrame.add(welcomeText);
        startFrame.setLayout(null);
       

        daisyButton = new JButton("daisy!");
        daisyButton.setActionCommand("DAISY");
        daisyButton.addActionListener(new ButtonClickListener());
        daisyButton.setBounds(50, 150, 100, 40);
        startFrame.add(daisyButton);

        getPixel = new JButton("Get Pixel");
        getPixel.setActionCommand("PIX");
        getPixel.addActionListener(new ButtonClickListener());
        getPixel.setBounds(200, 150, 100, 40);
        //startFrame.add(getPixel);

        //contrast button
        contrast = new JButton("Contrast");
        contrast.setActionCommand("CON");
        contrast.addActionListener(new ButtonClickListener());
        contrast.setBounds(350, 150, 100, 40);

        //highlight button
        highlight = new JButton("highlight");
        highlight.setActionCommand("HIGH");
        highlight.addActionListener(new ButtonClickListener());
        highlight.setBounds(500, 150, 100, 40);

        //reset button
        reset = new JButton("reset");
        reset.setActionCommand("RES");
        reset.addActionListener(new ButtonClickListener());
        reset.setBounds(650, 150, 100, 40);

        //blur button
        blur = new JButton("blur");
        blur.setActionCommand("BLUR");
        blur.addActionListener(new ButtonClickListener());
        blur.setBounds(800, 150, 100, 40);

        //rotate button
        rotate = new JButton("rotate");
        rotate.setActionCommand("ROT");
        rotate.addActionListener(new ButtonClickListener());
        rotate.setBounds(950, 150, 100, 40);

        //zoom buotton
        zoom = new JButton("zoom");
        zoom.setActionCommand("ZOOM");
        zoom.addActionListener(new ButtonClickListener());
        zoom.setBounds(1100, 150, 100, 40);

        //saturate 
        saturate = new JButton("saturate");
        saturate.setActionCommand("SAT");
        saturate.addActionListener(new ButtonClickListener());
        saturate.setBounds(1350, 150, 100, 40);

        //edger
        edgedec = new JButton("edge detection");
        edgedec.setActionCommand("EDG");
        edgedec.addActionListener(new ButtonClickListener());
        edgedec.setBounds(1500, 150, 100, 40);

        pixelCol = new JLabel("");
        pixelCol.setBounds(100, 20, 250, 40);
        xCoord = new JTextField("x");
        yCoord = new JTextField("y");
        xCoord.setBounds(220,270,40,30);
        yCoord.setBounds(260,270,40,30);
        startFrame.add(pixelCol);
        startFrame.add(xCoord);
        startFrame.add(yCoord);

        change = new JButton("go RED");
        change.setActionCommand("CHANGE");
        change.addActionListener(new ButtonClickListener());
        change.setBounds(100, 270, 60, 30);
        startFrame.add(change);

        icon = new ImageIcon("daisy.png");
        try {
        	im = ImageIO.read(new File("daisy.png"));
        }
        catch(IOException e) {
        	System.out.println("Error reading image: " + e.getMessage());
        }

        f = new JFrame();
		p = new JPanel();
		lab = new JLabel(icon);

        startFrame.setVisible(true);
	}

	public static void main(String[] args) {
		ImageEditing mWin = new ImageEditing();
	}

	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("DAISY"))  {
				f.add(p);
				p.add(lab);
				f.pack();
				startFrame.add(getPixel);
                startFrame.add(contrast);
                startFrame.add(highlight);
                startFrame.add(reset);
                startFrame.add(blur);
                startFrame.add(rotate);
                startFrame.add(zoom);
                startFrame.add(saturate);
                startFrame.add(edgedec);
				f.setVisible(true);
         	}    
         	if (command.equals("PIX")) {
         		// get coordinate
         		int x = Integer.parseInt(xCoord.getText());
         		int y = Integer.parseInt(yCoord.getText());

         		int rgb = im.getRGB(x,y);
         		int r = (rgb & 0x00ff0000) >> 16;
         		int g = (rgb & 0x0000ff00) >> 8;
         		int b = rgb & 0x000000ff;
   				String myColor = "[" + r + ", " + g +", " + b + "]";
         		pixelCol.setText("Color: " + myColor);
         	}
         	if (command.equals("CHANGE")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;
         				r = r + 20;
         				g = g + 20;
         				b = b + 20;
         				if (r > 255) {
         					r = 255;
         				}
         				if (g > 255) {
         					g = 255;
         				}
         				if (b > 255) {
         					b = 255;
         				}
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);
         			}
         		}
         		
         		icon = new ImageIcon(im);
         		lab.setIcon(icon);
         		lab.repaint();
         	}
      	}     
   	}
}
