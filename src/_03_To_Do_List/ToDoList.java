package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addButton = new JButton();
	JButton viewButton = new JButton();
	JButton removeButton = new JButton();
	JButton saveButton = new JButton();
	JButton loadButton = new JButton();
	ArrayList<String> toDo = new ArrayList<String>();
	
	public ToDoList() {
		frame.add(panel);
		panel.add(addButton);
		panel.add(viewButton);
		panel.add(removeButton);
		panel.add(saveButton);
		panel.add(loadButton);
		addButton.setText("Add");
		viewButton.setText("View");
		removeButton.setText("Remove");
		saveButton.setText("Save");
		loadButton.setText("Load");
		addButton.addActionListener(this);
		viewButton.addActionListener((ActionListener) this);
		removeButton.addActionListener((ActionListener) this);
		saveButton.addActionListener((ActionListener) this);
		loadButton.addActionListener((ActionListener) this);
		frame.setVisible(true);
		frame.pack();

	}
	
	public static void main (String[] args) {
		ToDoList list = new ToDoList();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addButton)) {
			toDo.add(JOptionPane.showInputDialog("Add a task"));
		}
		else if (e.getSource().equals(viewButton)) {
			JOptionPane.showMessageDialog(panel, toDo);
		}
		else if (e.getSource().equals(removeButton)) {
			String task = JOptionPane.showInputDialog("What task do you want to remove?");
			toDo.remove(toDo.indexOf(task));
			//toDo.remove(JOptionPane.showInputDialog("What is the index of the task you want to remove starting a 0"));
		}
		else if (e.getSource().equals(saveButton)) {
			String fileName = JOptionPane.showInputDialog("What file do you want to add the tasks to?");
			try {
				FileWriter fw = new FileWriter(new File(fileName + ".txt"), true);
				for (int i=0; i<toDo.size(); i++) {
					fw.write(toDo.get(i));
					fw.write("\n");
				}
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource().equals(loadButton)) {
			String fileLoad = JOptionPane.showInputDialog("What file would you like to open?");
			//String list = "";
			try {
				BufferedReader fr = new BufferedReader(new FileReader(fileLoad + ".txt"));
				try {
					String line = fr.readLine();
					while (line != null) {
						toDo.add(line);
						line = fr.readLine();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
}
