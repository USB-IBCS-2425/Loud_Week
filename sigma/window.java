import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Museaum {
	private JFrame startFrame;
	private JLabel welcomeText;

	public Museaum() {
		startFrame = new JFrame("Exhibition sample");
		startFrame.setSize(400, 200);
		welcomeText = new JLabel("Welcome to the Image Example", JLabel.CENTER);

		startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });
 		startFrame.add(welcomeText, BorderLayout.CENTER);
        startFrame.setLayout(new BorderLayout());

        JLabel instructionText = new JLabel("Sample for a museum showcase", JLabel.CENTER);
        startFrame.add(instructionText, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton sample1 = new JButton("Sample art 1");
        sample1.setActionCommand("S1");
        sample1.addActionListener(new ButtonClickListener());

        JButton sample2 = new JButton("Sample art 2");
        sample2.setActionCommand("S2");
        sample2.addActionListener(new ButtonClickListener());

        JButton sample3 = new JButton("Sample art 3");
        sample3.setActionCommand("S3");
        sample3.addActionListener(new ButtonClickListener());

        JButton sample4 = new JButton("Sample art 4");
        sample4.setActionCommand("S4");
        sample4.addActionListener(new ButtonClickListener());

        JButton sample5 = new JButton("Sample art 5");
        sample5.setActionCommand("S5");
        sample5.addActionListener(new ButtonClickListener());

        buttonPanel.add(sample1);
        buttonPanel.add(sample2);
        buttonPanel.add(sample3);
        buttonPanel.add(sample4);
        buttonPanel.add(sample5);

       	startFrame.add(buttonPanel, BorderLayout.SOUTH);

        startFrame.setVisible(true);

    }
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

            if (command.equals("S1")) {
                JFrame s1Frame = new JFrame("Sample art 1");
                JPanel s1Panel = new JPanel();
                ImageIcon icon = new ImageIcon("Sample1.jpeg");
                JLabel s1Image = new JLabel(icon);

                JLabel s1SourceText = new JLabel("Source: https://www.facebook.com/photo.php?fbid=2971835782902112&id=2102308739854825&set=a.2113709492048083", JLabel.CENTER);
                s1Panel.add(s1Image);
                s1Panel.add(s1SourceText);

                s1Frame.add(s1Panel);
                s1Frame.pack();
                s1Frame.setVisible(true);
            }
            if (command.equals("S2")) {
                JFrame s2Frame = new JFrame("Sample art 2");
                JPanel s2Panel = new JPanel();
                ImageIcon icon = new ImageIcon("Sample2.gif");
                JLabel s2Image = new JLabel(icon);

                JLabel s2SourceText = new JLabel("Source: https://mx.pinterest.com/pin/702631979400168810/", JLabel.CENTER);
                s2Panel.add(s2Image);
                s2Panel.add(s2SourceText);

                s2Frame.add(s2Panel);
                s2Frame.pack();
                s2Frame.setVisible(true);
            }
            if (command.equals("S3")) {
                JFrame s3Frame = new JFrame("Sample art 3");
                JPanel s3Panel = new JPanel();
                ImageIcon icon = new ImageIcon("Sample3.jpg");
                JLabel s3Image = new JLabel(icon);

                JLabel s3SourceText = new JLabel("Source: https://www.pinterest.com/pin/800514902499416849/", JLabel.CENTER);
                s3Panel.add(s3Image);
                s3Panel.add(s3SourceText);

                s3Frame.add(s3Panel);
                s3Frame.pack();
                s3Frame.setVisible(true);
            }
            if (command.equals("S4")) {
                JFrame s4Frame = new JFrame("Sample art 4");
                JPanel s4Panel = new JPanel();
                ImageIcon icon = new ImageIcon("Sample4.webp");
                JLabel s4Image = new JLabel(icon);

                JLabel s4SourceText = new JLabel("Source: https://www.fiverr.com/mavericmaric/create-pixel-art-portrait-in-gb-style", JLabel.CENTER);
                s4Panel.add(s4Image);
                s4Panel.add(s4SourceText);

                s4Frame.add(s4Panel);
                s4Frame.pack();
                s4Frame.setVisible(true);
            }
            if (command.equals("S5")) {
                JFrame s5Frame = new JFrame("Sample art 5");
                JPanel s5Panel = new JPanel();
                ImageIcon icon = new ImageIcon("Sample5.jpg");
                JLabel s5Image = new JLabel(icon);

                JLabel s5SourceText = new JLabel("Source: https://pinnguaq.com/learn/pixel-art/pixel-art-3c-tile-permutations-in-graphicsgale/", JLabel.CENTER);
                s5Panel.add(s5Image);
                s5Panel.add(s5SourceText);

                s5Frame.add(s5Panel);
                s5Frame.pack();
                s5Frame.setVisible(true);
            }
		}
	}
	public static void main(String[] args) {
		Museaum sigma = new Museaum();
	}
}