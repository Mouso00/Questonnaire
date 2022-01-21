import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

	String[] questions = { "Respects and promotes individual and cultural differences; encourages diversity and inclusion wherever possible.",
						   "Maintains high ethical standards and acts in a manner consistent with organizational principles/rules and standards of conduct.",
						   "Demonstrates ability to work in a composed, competent and committed manner and exercises careful judgment in meeting day-to-day challenges.",
						   "Develops and promotes effective collaboration within and across units to achieve shared goals and optimize results."
						   };
	
	String[][] options = { { "Excelent", "Fully satisfactory", "Need Improvment", "Not applicable" },
						   { "Excelent", "Fully satisfactory", "Need Improvment", "Not applicable" },
						   { "Excelent", "Fully satisfactory", "Need Improvment", "Not applicable" },
						   { "Excelent", "Fully satisfactory", "Need Improvment", "Not applicable" } };
		
	char[] answers = { 'A', 'B', 'C', 'D'};
	
	

	char guess;
	char answer;
	int index = 0;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 10;

	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();

//	Timer timer = new Timer(1000, new ActionListener() {  // CountDown for the Timer
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			seconds--;
//			seconds_left.setText(String.valueOf(seconds));
//			if(seconds<=0) {
//				
//			}
//			displayAnswer();
//		}
//		
//	});

	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.getContentPane().setBackground(new Color(51, 153, 255 ));
		frame.setLayout(null);
		frame.setResizable(false);
		
		//Question Category Table 
		textfield.setBounds(0, 0, 800, 50);
		textfield.setBackground(new Color(204,204, 204));
		textfield.setForeground(new Color(0, 0, 0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textfield.setText("Inclusion and respect for diversity");

		//Question Table
		textarea.setBounds(0, 50, 800, 80);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(204,204, 204));
		textarea.setForeground(new Color( 0, 0, 0));
		textarea.setFont(new Font("MV Boli", Font.BOLD, 20));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
	

		//BUTTONS
		buttonA.setBounds(205, 175, 50, 50);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 20));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");

		buttonB.setBounds(205, 275, 50, 50);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 20));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		buttonC.setBounds(205, 375, 50, 50);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 20));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		buttonD.setBounds(205, 475, 50, 50);
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 20));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");

		//Answers
		answer_labelA.setBounds(260, 150, 500, 100);
		answer_labelA.setBackground(new Color(0, 0, 0));
		answer_labelA.setForeground(new Color(0, 0, 0));
		answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelB.setBounds(260, 250, 500, 100);
		answer_labelB.setBackground(new Color(0, 0, 0));
		answer_labelB.setForeground(new Color(0, 0, 0));
		answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelC.setBounds(260, 350, 500, 100);
		answer_labelC.setBackground(new Color(0, 0, 0));
		answer_labelC.setForeground(new Color(0, 0, 0));
		answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelD.setBounds(260, 450, 500, 100);
		answer_labelD.setBackground(new Color(0, 0, 0));
		answer_labelD.setForeground(new Color(0, 0, 0));
		answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

//		seconds_left.setBounds(535,510,100,100);
//		seconds_left.setBackground(new Color(25,25,25));
//		seconds_left.setForeground(new Color(255,0,0));
//		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
//		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
//		seconds_left.setOpaque(true);
//		seconds_left.setHorizontalAlignment(JTextField.CENTER);
//		seconds_left.setText(String.valueOf(seconds));

//		time_label.setBounds(535,475,100,25);
//		time_label.setBackground(new Color(50,50,50));
//		time_label.setForeground(new Color(255,0,0));
//		time_label.setFont(new Font("MV Boli",Font.PLAIN,17));
//		time_label.setHorizontalAlignment(JTextField.CENTER);
//		time_label.setText("Timer");

//		number_right.setBounds(225, 225, 200, 100);
//		number_right.setBackground(new Color(25, 25, 25));
//		number_right.setBounds(225, 225, 200, 100);
//		number_right.setBackground(new Color(25, 25, 25));
//		number_right.setForeground(new Color(25, 255, 0));
//		number_right.setFont(new Font("Ink Free", Font.BOLD, 20));
//		number_right.setBorder(BorderFactory.createBevelBorder(1));
//		number_right.setHorizontalAlignment(JTextField.CENTER);
//		number_right.setEditable(false);

		percentage.setBounds(0, 0, 800, 600);
		percentage.setBackground(new Color(51, 153, 255));
		percentage.setForeground(new Color(0, 0, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 20));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);

		nextQuestion();
	}


	//Changing next Question
	public void nextQuestion() {

		if (index >= total_questions) {
			results();
		}
		else {
			
			if(index == 0 ) {
				textfield.setText("Inclusion and respect for diversity ");
			}
			else if(index == 1 ) {
				textfield.setText("Integrity and transparency");
			}
			else if(index == 2 ) {
				textfield.setText("Professionalism");
			}
			else if(index == 3 ) {
				textfield.setText("Teamwork");
			}
			textarea.setText(questions[index]);
			switch(index) 
			{

			case 0:
				answer_labelA.setText(options[index][0]);
				answer_labelB.setText(options[index][1]);
				answer_labelC.setText(options[index][2]);
				answer_labelD.setText(options[index][3]);
			case 1:
				answer_labelA.setText(options[index][0]);
				answer_labelB.setText(options[index][1]);
				answer_labelC.setText(options[index][2]);
				answer_labelD.setText(options[index][3]);
			case 2:
				answer_labelA.setText(options[index][0]);
				answer_labelB.setText(options[index][1]);
				answer_labelC.setText(options[index][2]);
				answer_labelD.setText(options[index][3]);
			case 3:
				answer_labelA.setText(options[index][0]);
				answer_labelB.setText(options[index][1]);
				answer_labelC.setText(options[index][2]);
				answer_labelD.setText(options[index][3]);
			
			}
			
			
//			
//			textarea.setText(questions[index]);
//			answer_labelA.setText(options[index][0]);
//			answer_labelB.setText(options[index][1]);
//			answer_labelC.setText(options[index][2]);
//			answer_labelD.setText(options[index][3]);
//			timer.start();   // TimerStarts
		}
	}

	//The program calculate the answer with the results 
	@Override
	public void actionPerformed(ActionEvent e) {

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		if (e.getSource() == buttonA) {
			answer = 'A';
			if (answer == answers[index]) {
				correct_guesses++;
			}
		}
		if (e.getSource() == buttonB) {
			answer = 'B';
			if (answer == answers[index]) {
				correct_guesses++;
			}
		}
		if (e.getSource() == buttonC) {
			answer = 'C';
			if (answer == answers[index]) {
				correct_guesses++;
			}
		}
		if (e.getSource() == buttonD) {
			answer = 'D';
			if (answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();

	}

	public void displayAnswer() {

//		timer.stop(); // timer stops
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

//		if (answers[index] != 'A')
//			answer_labelA.setForeground(new Color(255, 0, 0));
//		if (answers[index] != 'B')
//			answer_labelB.setForeground(new Color(255, 0, 0));
//		if (answers[index] != 'C')
//			answer_labelC.setForeground(new Color(255, 0, 0));
//		if (answers[index] != 'D')
//			answer_labelD.setForeground(new Color(255, 0, 0));

		Timer pause = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				answer_labelA.setForeground(new Color(0, 0, 0));
				answer_labelB.setForeground(new Color(0, 0, 0));
				answer_labelC.setForeground(new Color(0, 0, 0));
				answer_labelD.setForeground(new Color(0, 0, 0));

//				answer = ' ';
//				seconds=10;
//				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
				
//				if (index >= questions.length) {
//					results();
//				}else {
//				nextQuestion();
//				}
			
			}

		});
		pause.setRepeats(false);

		pause.start();

	}

	public void results() {
//		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
//		result = (int)((correct_guesses/(double)total_questions)*100);
//		Results results = new Results(frame);

		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
//		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"% Satisfied");
		
		frame.add(percentage);
//		frame.add(number_right);

	}

}
