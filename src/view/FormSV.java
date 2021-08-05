package view;


import emtity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormSV extends JFrame {
    private JLabel label_name;
    private JLabel label_ID;
    private JLabel label_date;
    private JLabel label_email;
    private JLabel label_phone;
    private JLabel label_address;
    private JTextField textField_name;
    private JTextField textField_idStudent;
    private JTextField textField_date;
    private JTextField textField_email;
    private JTextField textField_phone;
    private JTextField textField_address;
    private JButton button_submit;
    private JButton button_remove;
    private JPanel main_panel;
    private JTable table_data;

    private ArrayList<Student> list_data = new ArrayList<>();
    private DefaultTableModel model;


    {
        model = (DefaultTableModel) table_data.getModel();
    }


    private void tittle_Col_Table() {
        table_data.setModel(new DefaultTableModel(null,new Object[]{"Name", "Id Student", "Date", "Email", "Phone Number", "Address"}));
    }

    public void show_result() {

        Student g = list_data.get(list_data.size() - 1);
        model.addRow(new Object[]{
                g.getName(), g.getId(), g.getDate(), g.getEmail(), g.getPhoneNumber(), g.getAddress()}
        );
    }

    public FormSV(String tittle) {
        super(tittle);
        tittle_Col_Table();
        setContentPane(main_panel);
        setSize(1280, 1024);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                s.setName(textField_name.getText());
                s.setId(textField_idStudent.getText());
                s.setDate(textField_date.getText());
                s.setEmail(textField_email.getText());
                s.setPhoneNumber(textField_phone.getText());
                s.setAddress(textField_address.getText());
                list_data.add(s);
                show_result();
            }
        });
    }


    public static void main(String[] args) {
        JFrame form = new FormSV("Form beta");

    }


}

