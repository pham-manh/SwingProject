package view;


import emtity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private JScrollPane scrollPane;

    private ArrayList<Student> list_data = new ArrayList<>();
    private DefaultTableModel model;




    private void tittle_Col_Table() {
        table_data = new JTable();
        model = new DefaultTableModel();
        Object[] collums = {"Name", "ID Student", "Date of Birth", "Email", "Phone Number", "Address"};
        Object[] row = new Object[0];
        model.setColumnIdentifiers(collums);
        table_data.setModel(model);
        scrollPane.setViewportView(table_data);

    }

    public void show_result() {

        Student g = list_data.get(list_data.size() - 1);
        model.addRow(new Object[]{
                g.getName(), g.getId(), g.getDate(), g.getEmail(), g.getPhoneNumber(), g.getAddress()}
        );
    }

    public void reset_field(){
        textField_name.setText("");
        textField_idStudent.setText("");
        textField_date.setText("");
        textField_phone.setText("");
        textField_email.setText("");
        textField_address.setText("");
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

                try {
                    s.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(textField_date.getText()));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                s.setEmail(textField_email.getText());
                s.setPhoneNumber(textField_phone.getText());
                s.setAddress(textField_address.getText());
                if(s== null){
                    list_data.add(s);
                    show_result();
                    reset_field();
                }else {
                    JOptionPane.showMessageDialog(rootPane,"No data in.");
                    reset_field();
                }

            }
        });
        button_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table_data.getSelectedRowCount()==1){
                    model.removeRow(table_data.getSelectedRow());
                    JOptionPane.showMessageDialog(rootPane,"Successfully");
                }
                else{
                    if(table_data.getSelectedRowCount()==0){
                        JOptionPane.showMessageDialog(rootPane,"Table is Empty");
                    }else {
                        JOptionPane.showMessageDialog(rootPane,"Please select Singer row for Delete");
                    }
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame form = new FormSV("Form beta");

    }


}


