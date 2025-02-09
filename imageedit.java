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
    //highligh buttons
    public JButton highred;
    public JButton highgreen;
    public JButton highblue;
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
		startFrame.setSize(1000, 1000);
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
        contrast.setBounds(200, 150, 100, 40);

        //highlight button
        highlight = new JButton("highlight");
        highlight.setActionCommand("HIGH");
        highlight.addActionListener(new ButtonClickListener());
        highlight.setBounds(200, 250, 100, 40);

        //reset button
        reset = new JButton("reset");
        reset.setActionCommand("RES");
        reset.addActionListener(new ButtonClickListener());
        reset.setBounds(200, 350, 100, 40);

        //blur button
        blur = new JButton("blur");
        blur.setActionCommand("BLUR");
        blur.addActionListener(new ButtonClickListener());
        blur.setBounds(200, 450, 100, 40);

        //rotate button
        rotate = new JButton("rotate");
        rotate.setActionCommand("ROT");
        rotate.addActionListener(new ButtonClickListener());
        rotate.setBounds(400, 150, 100, 40);

        //zoom buotton
        zoom = new JButton("zoom");
        zoom.setActionCommand("ZOOM");
        zoom.addActionListener(new ButtonClickListener());
        zoom.setBounds(400, 250, 100, 40);

        //saturate 
        saturate = new JButton("saturate");
        saturate.setActionCommand("SAT");
        saturate.addActionListener(new ButtonClickListener());
        saturate.setBounds(400, 350, 100, 40);

        //edger
        edgedec = new JButton("edge detection");
        edgedec.setActionCommand("EDG");
        edgedec.addActionListener(new ButtonClickListener());
        edgedec.setBounds(400, 450, 100, 40);


        highred = new JButton("highlight red");
        highred.setActionCommand("HIGHRED");
        highred.addActionListener(new ButtonClickListener());
        highred.setBounds(600, 150, 100, 40);


        highgreen = new JButton("highlight green");
        highgreen.setActionCommand("HIGHGREEN");
        highgreen.addActionListener(new ButtonClickListener());
        highgreen.setBounds(600, 250, 100, 40);


        highblue = new JButton("highlight blue");
        highblue.setActionCommand("HIGHBLUE");
        highblue.addActionListener(new ButtonClickListener());
        highblue.setBounds(600, 350, 100, 40);

        pixelCol = new JLabel("");
        pixelCol.setBounds(100, 20, 250, 40);
        xCoord = new JTextField("x");
        yCoord = new JTextField("y");
        xCoord.setBounds(220,270,40,30);
        yCoord.setBounds(260,270,40,30);
        /*startFrame.add(pixelCol);
        startFrame.add(xCoord);
        startFrame.add(yCoord); */

        change = new JButton("go RED");
        change.setActionCommand("CHANGE");
        change.addActionListener(new ButtonClickListener());
        change.setBounds(100, 270, 60, 30);

        icon = new ImageIcon("samplewith2e.png");
        try {
        	im = ImageIO.read(new File("samplewith2e.png"));
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
            //start of contrast
         	}
         	if (command.equals("CON")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;
                        if (r >= 123 || g >=123 || b >= 123) {
             				r = r + 20;
             				g = g + 20;
             				b = b + 20;
             				if (r > 255) {
             					r = 255;
                                if (g >= 10) {
                                    g = g - 10;
                                } else {
                                    g = 0;
                                }
                                if (b >= 10) {
                                    b = b - 10;
                                } else {
                                    b = 0;
                                }
             				}

             				if (g > 255) {
             					g = 255;
                                if (r >= 10) {
                                    r = r - 10;
                                } else {
                                    r = 0;
                                }
                                if (b >= 10) {
                                    b = b - 10;
                                } else {
                                    b = 0;
                                }
             				}
             				if (b > 255) {
             					b = 255;
                                if (r >= 10) {
                                    r = r - 10;
                                } else {
                                    r = 0;
                                }
                                if (g >= 10) {
                                    g = g - 10;
                                } else {
                                    g = 0;
                                }
                            }
             			} else {
                            r = r - 20;
                            g = g - 20;
                            b = b - 20;
                            if (r < 0) {
                                r = 0;
                            }

                            if (g < 0) {
                                g = 0;
                            }
                            if (b < 0) {
                                b = 0;
                            }
                        }

         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);
         			}
                    //for (int i = 0; i < width; i = i + 1) {
                    //    for (int j = 0; j < height; j = j + 1) {
                    //        int col = col.remove(0);
                    //        im.getRGB(i,j, col);
         		}
         		
         		icon = new ImageIcon(im);
         		lab.setIcon(icon);
         		lab.repaint();
         	}
            //end of contrast

            //start of reset
            if (command.equals("RES")) {
                //for loop cuz it only works before if pressed twice, so looped 2 times for automatic presses, which works...
                for (int i = 0; i < 2; i++) {                    
                    f.dispose();
                    f = new JFrame();
                    p = new JPanel();
                    lab = new JLabel(icon);
                    icon = new ImageIcon("samplewith2e.png");
                    try {
                        im = ImageIO.read(new File("samplewith2e.png"));
                    }
                    catch(IOException j) {
                        System.out.println("Error reading image: " + j.getMessage());
                    }
                    f.add(p);
                    p.add(lab);
                    f.pack();
                }
                f.setVisible(true);
            }
            //end of reset

            //start of highlight
            if (command.equals("HIGH")) {
                startFrame.add(highred);
                startFrame.add(highgreen);
                startFrame.add(highblue);

            }
            if (command.equals("HIGHRED")) {              
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
                        if (r < b || r < g) {
                            if (g > b){
                                r = g;
                                b = g;
                            }
                            if (b > g){
                                r = b;
                                g = b;
                            }
                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

                        im.setRGB(i, j, col);
                        }
                    }
                }
            icon = new ImageIcon(im);
            lab.setIcon(icon);
            lab.repaint();
            }
            if (command.equals("HIGHGREEN")) {              
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
                        if (g < r || g < b) {
                            if (r > b){
                                b = r;
                                g = r;
                            }
                            if (b > r){
                                r = b;
                                g = b;
                            }
                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

                        im.setRGB(i, j, col);
                        }
                    }
                }
            icon = new ImageIcon(im);
            lab.setIcon(icon);
            lab.repaint();
            }
            if (command.equals("HIGHBLUE")) {              
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
                        if (b < g || b < r) {
                            if (g > r){
                                r = g;
                                b = g;
                            }
                            if (r > g){
                                b = r;
                                g = r;
                            }
                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

                        im.setRGB(i, j, col);
                        }
                    }
                }
            icon = new ImageIcon(im);
            lab.setIcon(icon);
            lab.repaint();
            }
            //end of highlight

            //start of rotate
            if (command.equals("ROT")) {                     
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;

                        int newi = width - 1 - i;
                        int newj = height - 1 - j;
                        int xyz     
                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;


                    }
                }
            icon = new ImageIcon(im);
            lab.setIcon(icon);
            lab.repaint();
            }
      	}
    }
}
