import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class Fileread2 {
	public JFrame mainframe;
	public JPanel output;
    public JButton readB;
    public JButton avgB;
    public JButton writeB;
    public JButton least;
    public JButton most;
    public JButton longest;
    public JButton shortest;
    public JButton mostv;
    public JButton leastv;
    public JButton avgsntc;
    public JButton unique;

	public static JTextField toRead;
	public static JTextArea resultT;
	public static ArrayList<String> textTokens;
    public static ArrayList<String> allwords;
    public static Map<String, Integer> wordcounts = new HashMap<>();

	public Fileread2() {

		textTokens = new ArrayList<String>();
        allwords = new ArrayList<String>();

		mainframe = new JFrame("Literature Analysis");
		mainframe.setSize(1200, 800);

		mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

		toRead = new JTextField("thelurkingfear.txt");
		toRead.setBounds(300, 50, 200, 40);
        mainframe.setLayout(null);
        mainframe.add(toRead);

        output = new JPanel();
        output.setBounds(200, 250, 100, 40);
        mainframe.add(output);

        readB = new JButton("Read File");
        readB.setActionCommand("READ");
        readB.addActionListener(new ButtonClickListener());
        readB.setBounds(200, 150, 100, 100);
        mainframe.add(readB);

        avgB = new JButton("Average Word");
        avgB.setActionCommand("AVG");
        avgB.addActionListener(new ButtonClickListener());
        avgB.setBounds(340, 150, 100, 100);
        mainframe.add(avgB);

        writeB = new JButton("Write File");
        writeB.setActionCommand("WRITE");
        writeB.addActionListener(new ButtonClickListener());
        writeB.setBounds(480, 150, 100, 100);
        mainframe.add(writeB);

        least = new JButton("Least common word");
        least.setActionCommand("LEAST");
        least.addActionListener(new ButtonClickListener());
        least.setBounds(620, 150, 100, 100);
        mainframe.add(least);

        most = new JButton("Most Common word");
        most.setActionCommand("MOST");
        most.addActionListener(new ButtonClickListener());
        most.setBounds(760, 150, 100, 100);
        mainframe.add(most);

        longest = new JButton("Longest word");
        longest.setActionCommand("LONG");
        longest.addActionListener(new ButtonClickListener());
        longest.setBounds(900, 150, 100, 100);
        mainframe.add(longest);

        shortest = new JButton("Shortest Word");
        shortest.setActionCommand("SHORT");
        shortest.addActionListener(new ButtonClickListener());
        shortest.setBounds(1040, 150, 100, 100);
        mainframe.add(shortest);

        mostv = new JButton("Most Vowels");
        mostv.setActionCommand("MOSTV");
        mostv.addActionListener(new ButtonClickListener());
        mostv.setBounds(1180, 150, 100, 100);
        mainframe.add(mostv);

        leastv = new JButton("Least Vowels");
        leastv.setActionCommand("LEASTV");
        leastv.addActionListener(new ButtonClickListener());
        leastv.setBounds(200, 350, 100, 100);
        mainframe.add(least);

        avgsntc = new JButton("Average Sentence");
        avgsntc.setActionCommand("AVGSNT");
        avgsntc.addActionListener(new ButtonClickListener());
        avgsntc.setBounds(620, 250, 100, 100);
        mainframe.add(avgsntc);

        unique = new JButton("Unique Sentence");
        unique.setActionCommand("UNIQUE");
        unique.addActionListener(new ButtonClickListener());
        unique.setBounds(480, 250, 100, 100);
        mainframe.add(unique);


        resultT = new JTextArea("");
        resultT.setBounds(200, 400, 400, 240);
        mainframe.add(resultT);

        mainframe.setVisible(true);
	}

	public static void main(String[] args) {
		Fileread2 fo = new Fileread2();
	}

    public static double round(double x, int places) {
        int mult = (int)Math.pow(10, places);
        int y = (int)(x*mult);
        double rounded = y / (double) mult;
        return rounded;
    }

    public static void readFile() {
        String fname = toRead.getText();
        textTokens.clear();

        try {
            File f = new File(fname);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String data = s.next();
                textTokens.add(data);
            }
            s.close();
        }
        catch (FileNotFoundException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }

        resultT.setText("File Read\nFile has " + textTokens.size() + " tokens");
    }

    public static void parseWords() {
        allwords.clear();
        int text = 0;
        for (int i = 0; i < textTokens.size(); i++) {
            String[] tempWords = textTokens.get(i).split("\\s+|--");
            for (String s : tempWords) {
                if (!s.isEmpty()) {
                    if (s.equals("***")){
                        text++;
                        continue;
                    }
                }
                    if (text == 0 | text > 2) {
                        String data = s;
                        continue;
                    }
                s = s.replaceAll("[\\p{P}_]", "");
                s = s.toLowerCase();
                allwords.add(s);
            }
        }
     }
    public static void showAvg() {
        double totLen = 0;
        for (String w : allwords) {
            totLen = totLen + w.length();
        }
        double avgLen = totLen / allwords.size();
        avgLen = round(avgLen, 2);
        String res = "The average word length is:\n";
        res = res + avgLen + " characters";
        resultT.setText(res);
    }
    
    public static void writeFile() {
        // NEED TO CHECK WITH USER FIRST!
        String fname = toRead.getText();
        String toWrite = resultT.getText();

        try {
            FileWriter w = new FileWriter(fname);
            w.write(toWrite);
            w.close();
        }
        catch (IOException er) {
            System.out.println("Error message:");
            er.printStackTrace();
        }
    }

    public static void findfreq() {
        for (String word : allwords) {
            if (wordcounts.containsKey(word)) {
                wordcounts.put(word, wordcounts.get(word) + 1);
            } else {
                wordcounts.put(word, 1);
            }
        }
    }


    public static void leastcommon() {
        String leastcommonword = "";
        int mincount = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            if (entry.getValue() < mincount) {
                mincount = entry.getValue();
            }
        }
        String result = "Least common words (Count: " + mincount + "):\n";
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            if (entry.getValue() == mincount) {
                result += "- " + entry.getKey() + "\n";
            }
        }
        resultT.setText(result);
    }

    public static void mostcommon() {
        String mostcommonword = "";
        int maxcount = 0;
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            if (entry.getValue() > maxcount) {
                maxcount = entry.getValue();
            }
        }
        String result = "Most common words (Count: " + maxcount + "):\n";
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            if (entry.getValue() == maxcount) {
                result += "- " + entry.getKey() + "\n";
            }
        }
        resultT.setText(result);
    }

    public static void longest() {
        int maxlength = 0;
        String longestw = ""; 
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            if (entry.getKey().length() > maxlength) {
                maxlength = entry.getKey().length();
                longestw = entry.getKey(); 
            } else if (entry.getKey().length() == maxlength) {
                longestw += ", " + entry.getKey(); 
            }
        }

        String result = "The longest word(s):\n";
        if (!longestw.isEmpty()) { 
            result += "- " + longestw + "\n"; 
        }

        resultT.setText(result);
    }

    public static void shortest() {
        String shortest = "";
        int minlength = 2147483647;
        String shortestw = ""; 
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            if (entry.getKey().length() < minlength && entry.getKey().length() > 0) {
                minlength = entry.getKey().length();
                shortestw = entry.getKey(); 
            } else if (entry.getKey().length() == minlength) {
                shortestw += ", " + entry.getKey(); 
            }
        }

        String result = "The shortest word(s):\n";
        if (!shortestw.isEmpty()) { 
            result += "- " + shortestw + "\n"; 
        }
        resultT.setText(result);
    }
    
    public static void mostv() {
        String mostv = "";
        int maxv = 0;
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            int vs = 0;
            for (int i = 0; i < entry.getKey().length(); i++) {
                if (entry.getKey().charAt(i) == 'a' || entry.getKey().charAt(i) == 'e' || entry.getKey().charAt(i) == 'i' || 
                    entry.getKey().charAt(i) == 'o' || entry.getKey().charAt(i) == 'u') {
                    vs++;
                }
            }
            if (vs > maxv) {
                maxv = vs;
                mostv = entry.getKey();
            } else if (vs == maxv) {
                mostv += ", " + entry.getKey(); 
            }
        }

        String result = "The word with most vowels(s):\n";
        if (!mostv.isEmpty()) { 
            result += "- " + mostv + "\n"; 
        }
        resultT.setText(result);
    }

    public static void leastv() {
        String leastv = "";
        int minv = 2147483647;
        for (Map.Entry<String, Integer> entry : wordcounts.entrySet()) {
            int vs = 0;
            for (int i = 0; i < entry.getKey().length(); i++) {
                if (entry.getKey().charAt(i) == 'a' || entry.getKey().charAt(i) == 'e' || entry.getKey().charAt(i) == 'i' || 
                    entry.getKey().charAt(i) == 'o' || entry.getKey().charAt(i) == 'u') {
                    vs++;
                }
            }
            if (vs < minv) {
                minv = vs;
                leastv = entry.getKey();
            } else if (vs == minv) {
                leastv += ", " + entry.getKey(); 
            }
        }

        String result = "The word with least vowels(s):\n";
        if (!leastv.isEmpty()) { 
            result += "- " + leastv + "\n"; 
        }
        resultT.setText(result);
    }


    public static void avgsntc() {

        parseWords();

        int sentences = 0;
        int totalw = 0;

        for (String sentence : textTokens) {
            String[] words = sentence.split("\\s+|--|[-–—]");
            if (words.length > 0) { 
                sentences++;
                totalw += words.length;
            }
        }

        double avgsntclength = 0.0;
        if (sentences > 0) {
            avgsntclength = (double) totalw / sentences;
        }

        String result = "The average sentence length is: " + String.valueOf(avgsntclength);
        resultT.setText(result);
    }

    public static void unique() {
        double minuniind = Double.MAX_VALUE;
        ArrayList<String> mostunisntc = new ArrayList<>();
        ArrayList<String> currentsntc = new ArrayList<>();

        for (String sentence : textTokens) {
            String[] words = sentence.split("\\s+|--|[-–—]");
            if (words.length > 0) { 
                currentsntc.clear();
                double uniqueind = 0.0;

                for (String word : words) {
                    word = word.replaceAll("[\\p{P}_]", "").toLowerCase(); // Normalize the word
                    currentsntc.add(word);
                    uniqueind += wordcounts.getOrDefault(word, 0);
                }
                if (currentsntc.size() >= 8) {
                    uniqueind /= currentsntc.size(); 
                    if (uniqueind < minuniind) {
                        minuniind = uniqueind;
                        mostunisntc = new ArrayList<>(currentsntc);
                    }
                }
            }
        }

        String result = "The most unique sentence is: ";
        for (int i = 0; i < mostunisntc.size(); i++) {
            result += mostunisntc.get(i) + " ";
        }
        resultT.setText(result);
    }

	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("WRITE")) {
                writeFile();
            }

            if (command.equals("READ")) {
                readFile();
            }

            if (command.equals("AVG")) {
                parseWords();
                
                showAvg();
            }
            if (command.equals("LEAST")){
                parseWords();
                findfreq();
                leastcommon();
            }
            if (command.equals("MOST")){
                parseWords();
                findfreq();
                mostcommon();
            }
            if (command.equals("LONG")){
                parseWords();
                findfreq();
                longest();
            }
            if (command.equals("SHORT")){
                parseWords();
                findfreq();
                shortest();
            }
            if (command.equals("MOSTV")){
                parseWords();
                findfreq();
                mostv();
            }
            if (command.equals("AVGSNT")){
                parseWords();
                findfreq();
                avgsntc();
            }
            if (command.equals("UNIQUE")){
                parseWords();
                findfreq();
                unique();
            }
        }
    }
}