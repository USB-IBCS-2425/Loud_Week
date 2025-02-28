import java.awt.*;
import java.awt.image.*;
import java.awt.Color;
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
    public JButton bnw;
    public JButton gsc;

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

        bnw = new JButton("Black & White");
        bnw.setActionCommand("B&W");
        bnw.addActionListener(new ButtonClickListener());
        bnw.setBounds(600, 450, 100, 40);

        gsc = new JButton("Grayscale");
        gsc.setActionCommand("GSC");
        gsc.addActionListener(new ButtonClickListener());
        gsc.setBounds(800, 150, 100, 40);

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

        icon = new ImageIcon("sigma.png");
        try {
            im = ImageIO.read(new File("sigma.png"));
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
                startFrame.add(bnw);
                startFrame.add(gsc);
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
                    icon = new ImageIcon("sigma.png");
                    try {
                        im = ImageIO.read(new File("sigma.png"));
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
                startFrame.repaint();
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
                //highkey copied from zoom cuz buffered image but it works now
             if (command.equals("ROT")) {
                int width = im.getWidth();
                int height = im.getHeight();
            
                int newwidth = width;
                int newheight = height;
            
                BufferedImage rotated = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);
            
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
            
                        //map new image coords to original image
                        int newi = width - 1 - i;
                        int newj = height - 1 - j;
            
                        //get rgb from original image
                        int rgb = im.getRGB(i, j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
            
                        // Set RGB values in the zoomed image
                        rotated.setRGB(newi, newj, (0xFF << 24) | (r << 16) | (g << 8) | b);
                    }
                }
            
                im = rotated; // Update the image
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }

                //this is here to be shamed

                //rotate breaks the entire programme, it aint zoom's faults
                //buffered image time
          /*  if (command.equals("ROT")) {                     
                int width = im.getWidth();
                int height = im.getHeight();
                int xwidth = width;
                int yheight = height;
                for (int i = 0; i < width; i = i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;

                        BufferedImage rotated = new BufferedImage(xwidth, yheight, BufferedImage.TYPE_INT_RGB);



                        zoomed.setRGB(i, j, (0xFF << 24) | (r << 16) | (g << 8) | b);

                        //this only rotates half the image cuz of the pixels replaced before it was saved
                        //fix through running it both ways at the same time?
                    }
                }
            icon = new ImageIcon(im);
            lab.setIcon(icon);
            lab.repaint();
            } */
            //end of rotate
            
            //start of edge detector
                //nvm this works now cuz im silly and forgot to change rgb names of the other rgb values
            if (command.equals("EDG")) {
                int width = im.getWidth();
                int height = im.getHeight();
                int newwidth = width;
                int newheight = height;
                BufferedImage edged = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);

                for (int i = 1; i < width - 1; i++) {
                    for (int j = 1; j < height - 1; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;

                        int xyz = im.getRGB(i - 1, j);
                        int x = (xyz & 0x00ff0000) >> 16;
                        int y = (xyz & 0x0000ff00) >> 8;
                        int z = xyz & 0x000000ff;

                        int acd = im.getRGB(i + 1, j);
                        int a = (acd & 0x00ff0000) >> 16;
                        int c = (acd & 0x0000ff00) >> 8;
                        int d = acd & 0x000000ff;


                        int pou = im.getRGB(i, j - 1);
                        int p = (pou & 0x00ff0000) >> 16;
                        int o = (pou & 0x0000ff00) >> 8;
                        int u = pou & 0x000000ff;


                        int lkh = im.getRGB(i, j + 1);
                        int l = (lkh & 0x00ff0000) >> 16;
                        int k = (lkh & 0x0000ff00) >> 8;
                        int h = lkh & 0x000000ff;

                        int avgr = (r + x + a + p + l)/5;
                        int avgg = (g + y + c + o + k)/5;
                        int avgb = (b + z + d + u + h)/5;

                        int difr = Math.abs(r - avgr);
                        int difg = Math.abs(g - avgg);
                        int difb = Math.abs(b - avgb);

                        if (difr + difg + difb > 30) {
                            edged.setRGB(i, j, 0);
                        } else {
                            edged.setRGB(i, j, 0xFFFFFFFF);
                        }
                    }
                }
                im = edged;
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }
            //end of edge detector

            //start of zoom
                //USE WITH CARE
                //shit becomes laggy after a few consecutive clicks
                //seems to be lasting even after program closure
                    //nvm its fixed now, rotate was the problem n when reworked everythin now works smoothly
            if (command.equals("ZOOM")) {
                int width = im.getWidth();
                int height = im.getHeight();
            
                // Calculate new dimensions (50% zoom)
                int newwidth = (int) (width * 1.5);
                int newheight = (int) (height * 1.5);
            
                BufferedImage zoomed = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);
            
                for (int newi = 0; newi < newwidth; newi++) {
                    for (int newj = 0; newj < newheight; newj++) {
            
                        //map new image coords to original image
                        int origi = (int) (newi / 1.5);
                        int origj = (int) (newj / 1.5);
            
                        //get rgb from original image
                        int rgb = im.getRGB(origi, origj);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
            
                        // Set RGB values in the zoomed image
                        zoomed.setRGB(newi, newj, (0xFF << 24) | (r << 16) | (g << 8) | b);
                    }
                }
            
                im = zoomed; // Update the image
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }
            //end of zoom

            //start of saturation
                        //FIXED IT, FINALLY, BLESS java.awt.Color;
                        //aight this aint gonna become edge detection
            if (command.equals("SAT")) {
                int width = im.getWidth();
                int height = im.getHeight();
            //this section is credited to https://stackoverflow.com/questions/2399150/convert-rgb-value-to-hsv
                //this chagnes how much saturated it gets (1.5 <=> 50%)
                //saturate%
                double saturation = 1.5;
            
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i, j);
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = rgb & 0xFF;
            
                        //convert rgb to hsv
                        float[] hsv = new float[3];
                        Color.RGBtoHSB(r, g, b, hsv);
            
                        //adjust sat
                        hsv[1] *= saturation;
            
                        //lock sat value (between 0 n 1)
                        hsv[1] = Math.max(0, Math.min(hsv[1], 1));

                        //credits to https://stackoverflow.com/questions/7896280/converting-from-hsv-hsb-in-java-to-rgb-without-using-java-awt-color-disallowe
                        //convdert back
                        int xyz = Color.HSBtoRGB(hsv[0], hsv[1], hsv[2]);
                        im.setRGB(i, j, xyz); ;
                    }
                }
            
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }
            //end of saturation

            //start of blur (i hate this one, doin it out of spite)
                //ground work using assets from edge detector (surrounding pixels)
            if (command.equals("BLUR")) {
                int width = im.getWidth();
                int height = im.getHeight();
                int newwidth = width;
                int newheight = height;
                BufferedImage edged = new BufferedImage(newwidth, newheight, BufferedImage.TYPE_INT_RGB);

                for (int i = 1; i < width - 1; i++) {
                    for (int j = 1; j < height - 1; j++) {
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;

                        int xyz = im.getRGB(i - 1, j);
                        int x = (xyz & 0x00ff0000) >> 16;
                        int y = (xyz & 0x0000ff00) >> 8;
                        int z = xyz & 0x000000ff;

                        int acd = im.getRGB(i + 1, j);
                        int a = (acd & 0x00ff0000) >> 16;
                        int c = (acd & 0x0000ff00) >> 8;
                        int d = acd & 0x000000ff;


                        int pou = im.getRGB(i, j - 1);
                        int p = (pou & 0x00ff0000) >> 16;
                        int o = (pou & 0x0000ff00) >> 8;
                        int u = pou & 0x000000ff;


                        int lkh = im.getRGB(i, j + 1);
                        int l = (lkh & 0x00ff0000) >> 16;
                        int k = (lkh & 0x0000ff00) >> 8;
                        int h = lkh & 0x000000ff;

                        int avgr = (r + x + a + p + l)/5;
                        int avgg = (g + y + c + o + k)/5;
                        int avgb = (b + z + d + u + h)/5;
                        
                        edged.setRGB(i, j, (0xFF << 24) | (avgr << 16) | (avgg << 8) | avgb);
                    }
                }
                im = edged;
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }
            //end of blur (suprisingly easy after edge detection)

            //start of black and white
            if (command.equals("B&W")) {
                int width = im.getWidth();
                int height = im.getHeight();
            //this section is credited to https://stackoverflow.com/questions/2399150/convert-rgb-value-to-hsv
                //this chagnes how much saturated it gets (1.5 <=> 50%)
                //saturate%
                double saturation = 1.5;
            
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i, j);
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = rgb & 0xFF;
            
                        //convert rgb to hsv
                        float[] hsv = new float[3];
                        Color.RGBtoHSB(r, g, b, hsv);
            
                        //adjust sat
                        hsv[1] *= saturation;
            
                        //lock sat value (between 0 n 1)
                        hsv[1] = Math.max(0, Math.min(hsv[1], 1));

                        //credits to https://stackoverflow.com/questions/7896280/converting-from-hsv-hsb-in-java-to-rgb-without-using-java-awt-color-disallowe
                        //convdert back
                        int x = (int) (hsv[1] * 255);
                        int y = (int) (hsv[1] * 255);
                        int z = (int) (hsv[1] * 255);
                        im.setRGB(i, j, (0xFF << 24) | (x << 16) | (y << 8) | z);
                    }
                }
            
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }
            //end of black n white

            //start of grayscale

            if (command.equals("GSC")) {
                int width = im.getWidth();
                int height = im.getHeight();
            //this section is credited to https://stackoverflow.com/questions/2399150/convert-rgb-value-to-hsv
                //this chagnes how much saturated it gets (1.5 <=> 50%)
                //saturate%
                double saturation = 1.5;
            
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i, j);
                        int r = (rgb >> 16) & 0xFF;
                        int g = (rgb >> 8) & 0xFF;
                        int b = rgb & 0xFF;
            
                        //convert rgb to hsv
                        float[] hsv = new float[3];
                        Color.RGBtoHSB(r, g, b, hsv);
            
                        //adjust sat
                        hsv[1] *= saturation;
            
                        //lock sat value (between 0 n 1)
                        hsv[1] = Math.max(0, Math.min(hsv[1], 1));

                        //credits to https://stackoverflow.com/questions/7896280/converting-from-hsv-hsb-in-java-to-rgb-without-using-java-awt-color-disallowe
                        //convdert back
                        int x = (int) (hsv[2] * 255);
                        int y = (int) (hsv[2] * 255);
                        int z = (int) (hsv[2] * 255);
                        im.setRGB(i, j, (0xFF << 24) | (x << 16) | (y << 8) | z);
                    }
                }
            
                icon = new ImageIcon(im);
                lab.setIcon(icon);
                lab.repaint();
            }
        }
    }
}