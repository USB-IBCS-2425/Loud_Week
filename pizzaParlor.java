
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonDemo {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public ButtonDemo() {
        mainFrame = new JFrame("Pizza Parlor");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("",JLabel.CENTER );
        //adding seperate labels for each elems
        statusLabel = new JLabel("",JLabel.CENTER);        
        statusLabel.setSize(350,100);

        statusLabel = new JLabel("",JLabel.CENTER);        
        statusLabel.setSize(350,100);

        statusLabel = new JLabel("",JLabel.CENTER);        
        statusLabel.setSize(350,100);

        statusLabel = new JLabel("",JLabel.CENTER);        
        statusLabel.setSize(350,100);

      
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });    
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        ButtonDemo b = new ButtonDemo();
        b.showEvent();
    }

    private void showEvent() {
        headerLabel.setText("Control in action: Button"); 

        JButton sizeButton = new JButton("Size");
        JButton sauceButton = new JButton("Sauce");
        JButton toppingsButton = new JButton("Toppings");
        JButton drinkButton = new JButton("Drink");
        JButton addOrder = new JButton("Adding a pizza to the order");
        JButton subOrder = new JButton("Submitting the order");

        sizeButton.setActionCommand("Size");
        sauceButton.setActionCommand("Sauce");
        toppingsButton.setActionCommand("Toppings");
        drinkButton.setActionCommand("Drink");
        addOrder.setActionCommand("Adding a pizza to the order");
        subOrder.setActionCommand("Submitting the order");


        sizeButton.addActionListener(new ButtonClickListener()); 
        sauceButton.addActionListener(new ButtonClickListener()); 
        toppingsButton.addActionListener(new ButtonClickListener()); 
        drinkButton.addActionListener(new ButtonClickListener()); 
        addOrder.addActionListener(new ButtonClickListener()); 
        subOrder.addActionListener(new ButtonClickListener()); 


        controlPanel.add(sizeButton);
        controlPanel.add(sauceButton);
        controlPanel.add(toppingsButton); 
        controlPanel.add(drinkButton);
        controlPanel.add(addOrder);
        controlPanel.add(subOrder);       
      

        mainFrame.setVisible(true);
    }
 int sizeCounter = 0;
 int sauceCounter = 0;
 int toppingsCounter = 0;
 int drinkCounter = 0;

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  

            if(command.equals("Size") && sizeCounter == 0)  {
                sizeCounter = sizeCounter + 1;
                statusLabel.setText("S");
            } else if(command.equals("Size") && sizeCounter == 1)  {
                statusLabel.setText("M");     
                sizeCounter = sizeCounter + 1;
            } else if(command.equals("Size") && sizeCounter == 2)  {
                statusLabel.setText("L");
                sizeCounter = sizeCounter - 2;
            }
            if(command.equals("Sauce") && sauceCounter == 0)  {
                sauceCounter = sauceCounter + 1;
                statusLabel.setText("Black Tomato");
            } else if(command.equals("Sauce") && sauceCounter == 1)  {
                statusLabel.setText("Garlic Vinegar");     
                sauceCounter = sauceCounter + 1;
            } else if(command.equals("Sauce") && sauceCounter == 2)  {
                statusLabel.setText("Plain");
                sauceCounter = sauceCounter - 2;

            // } else if(command.equals("Sauce"))  {

            //     statusLabel.setText(""); 

            // } else if(command.equals("Toppings"))  {

            //     statusLabel.setText(""); 

            // } else if(command.equals("Drink"))  {

            //     statusLabel.setText(""); 

            // } else if(command.equals("Adding a pizza to the order"))  {

            //     statusLabel.setText(""); 

            // } else {

            //     statusLabel.setText("");
         }      
      }     
   }
}