package view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
//labels
    private final JLabel labelP1 = new JLabel("Introduce first polynomial");
    private final JLabel labelP2 = new JLabel("Introduce second polynomial");
    String iText = "* The data must contain one space after each monomial and only characters like {x,+,-,=,^,digits}.\t\t(eg. : 5x^2 -2x +6 )";
    String iText2 = "*For Integration and Derivative, only the first polynomial will be computed";
    private final JLabel instructions = new JLabel("<html>" + iText.replaceAll("\n", "<br>"));
    private final JLabel instructions2 = new JLabel("<html>" + iText2.replaceAll("\n", "<br>"));
    private final JLabel chooseOp = new JLabel("Choose operation");
//text fields
    private final JTextField poly1 = new JTextField();
    private final JTextField poly2 = new JTextField();
    private final JTextArea result = new JTextArea();
//combo box
    String[] operations = {"Add", "Subtract", "Multiply","Divide","Integrate", "Derivate"};
    private final JComboBox opBox = new JComboBox(operations);
//buttons
    private final JButton compute = new JButton("COMPUTE");
    private final JButton exit = new JButton("EXIT");
    private final JButton ok = new JButton("OK");

    public View(){
        initView();
        addComponents();
    }

    private void initView(){
        this.setSize(515, 500);
        this.setTitle("Polynomial calculator");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground( new Color(230, 230, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addComponents(){
        addPolyLabels();
        addPolynomialFields();
        addInstructions();
        addOperation();
        addButtons();
    }

    private void addPolyLabels(){
     //polynomial 1
        labelP1.setBounds(15,30,180,30);
        labelP1.setVisible(true);
        this.add(labelP1);
     //polynomial 2
        labelP2.setBounds(15,70,180,30);
        labelP2.setVisible(true);
        this.add(labelP2);
    }

    private void addPolynomialFields(){
     // polynomial 1 field
        poly1.setBounds(190,30,230,30);
        poly1.setBackground(new Color(191, 191, 191));
        poly1.setForeground(new Color(64, 64, 64));
        poly1.setVisible(true);

        this.add(poly1);
     // polynomial 2 field
        poly2.setBounds(190,70,230,30);
        poly2.setBackground(new Color(191, 191, 191));
        poly2.setForeground(new Color(64, 64, 64));
        poly2.setVisible(true);
        this.add(poly2);
     //result
        result.setBounds(30, 300, 445, 80);
        result.setVisible(true);
        result.setBackground(new Color(191, 191, 191));
        result.setForeground(new Color(64, 64, 64));
        result.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Result"), result.getBorder()));
        this.add(result);
    }

    private void addInstructions() {
        instructions.setBounds(40, 80, 400, 80);
        instructions.setVisible(true);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setFont(new Font("Serif", Font.ITALIC, 11));
        this.add(instructions);

        instructions2.setBounds(40, 110, 400, 70);
        instructions2.setVisible(true);
        instructions2.setHorizontalAlignment(SwingConstants.CENTER);
        instructions2.setFont(new Font("Serif", Font.ITALIC, 11));
        this.add(instructions2);
    }

    private void addOperation(){
     //label
        chooseOp.setBounds(20, 200, 180, 30);
        chooseOp.setVisible(true);
        this.add(chooseOp);
     //combo box
        opBox.setBounds(190, 200, 230, 30);
        opBox.setVisible(true);
        opBox.setBackground(new Color(191, 191, 191));
        opBox.setForeground(new Color(64, 64, 64));
        this.add(opBox);
    }

    private void addButtons(){
     //ok for polynomials
        ok.setBounds(431, 50, 52, 30);
        ok.setVisible(true);
        ok.setBackground(new Color(77, 77, 77));
        ok.setForeground(new Color(255, 255, 255));
        this.add(ok);
     //compute
        compute.setBounds(190,260,100,30);
        compute.setVisible(true);
        compute.setBackground(new Color(77, 77, 77));
        compute.setForeground(new Color(255, 255, 255));
        this.add(compute);
     //exit
        exit.setBounds(190, 400, 100, 30);
        exit.setVisible(true);
        exit.setBackground(new Color(77, 77, 77));
        exit.setForeground(new Color(255, 255, 255));
        this.add(exit);
    }

    public void addSelectOperationListener(ActionListener listener) {
        opBox.addActionListener(listener);
    }
    public void addExitListener( ActionListener listener) { exit.addActionListener(listener);}

    public void addOkListener(ActionListener listener) {
        ok.addActionListener(listener);
    }
    public void addComputeListener(ActionListener listener) {
        compute.addActionListener(listener);
    }

    public String getPolynomial1(){
        return poly1.getText();
    }

    public String getPolynomial2(){
        return poly2.getText();
    }

    public JComboBox getOperation(){
       // String selected = String.valueOf(this.opBox.getSelectedItem());
        return opBox;
    }

    public JButton getOk(){ return ok;}
    public JButton getCompute(){ return compute;}
    public JButton getExit(){ return exit;}

    public void setResult(String result) {
        this.result.setText(result);
    }
}
