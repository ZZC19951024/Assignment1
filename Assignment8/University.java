package Assignment8;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

class StudentsModel implements TableModel {

	private StudentManager manager;

	public StudentsModel(StudentManager manager) {
		this.manager = manager;
	}

	@Override
	public int getRowCount() {
		return manager.getStudentCount();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "Roll Number";
		} 
		else if (columnIndex == 1){
			return "Name";
		}
		else {
			return "Gender";
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Student s = manager.getStudents().get(rowIndex);
		if (columnIndex == 0) {
			return s.getId();
		} 
		else if(columnIndex == 1){
			return s.getName();
		}
		else {
			return s.getGender();
		}

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}

public class University extends BaseFrame{
	private JLabel rollLabel, nameLabel, genderLabel;
	private JTextField rollText, nameText;
	private JButton add, modify, delete, find;
	private JComboBox gender;

	private JTable studentsTable;

	private StudentsModel model;

	@Override
	public void create() {
		rollLabel = new JLabel("Enter Roll Number : ");
		nameLabel = new JLabel("Enter Student Name : ");
		genderLabel = new JLabel("Gender");
		
		rollText = new JTextField(10);
		nameText = new JTextField(10);
		gender = new JComboBox(new String[] { "Male", "Female"});

		add = new JButton("Add");
		try {
			model = new StudentsModel(new StudentsManagerFileImpl());
		} catch (Exception e) {
		}

		studentsTable = new JTable(model);
	}

	@Override
	public void add(Container con) {
		GridLayout gl = new GridLayout(4, 1);
		con.setLayout(gl);
		addComponents(con,rollLabel,rollText);
		addComponents(con,nameLabel,nameText);
		addComponents(con,genderLabel,gender);
		con.add(add);
		con.add(new JScrollPane(studentsTable), "South");

	}
	
	private void addComponents(Container con, Component a, Component b) {
		JPanel panel = new JPanel();
		panel.add(a);
		panel.add(b);
		con.add(panel);

	}
	

	private void addStudent() throws Exception{
		StudentsManagerFileImpl s = new StudentsManagerFileImpl();
		Student student = new Student(rollText.getText(), nameText.getText(), gender.getSelectedItem().toString());
		s.addStudent(student);
		
	}
	@Override
	public void addListeners() {
		add.addActionListener((e) -> {
			try {
				addStudent();
			} catch (Exception e1) {
			}
		});

	}

	public static void main(String[] args) {
		new University();

	}
	
}
