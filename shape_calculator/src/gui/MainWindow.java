package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Classes.Circle;
import Classes.Rectangle;



public class MainWindow extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -8972845754063080764L;
    JPanel panel;
    public MainWindow(){
        initUI();
    }
    private void initUI() {

        panel = new JPanel();

        //Changes the flow layout to nothing. Allows absolute positioning.
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Panel for the shape selection.
        JPanel shapePanel = new JPanel();
        shapePanel.setLayout(new BoxLayout(shapePanel, BoxLayout.X_AXIS));
        final JLabel shapeLabel = new JLabel("Select a Shape: ");
        final String shapeOptions[] = {"Circle", "Rectangle"};
        final JComboBox<String> shapeList = new JComboBox<String>(shapeOptions);
        shapePanel.add(shapeLabel);
        shapePanel.add(shapeList);
        panel.add(shapePanel);

        final JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.X_AXIS));
        //final JLabel areaLabel = new JLabel("Calculate Area: ");
        final JPanel areaParametersPanel = new JPanel();
        areaParametersPanel.setLayout(new BoxLayout(areaParametersPanel, BoxLayout.Y_AXIS));
        //areaPanel.add(areaLabel);
        areaPanel.add(areaParametersPanel);
        panel.add(areaPanel);

        JPanel perimeterPanel = new JPanel();
//        JLabel perimeterLabel = new JLabel("Calculate Perimeter: ");
        final JPanel perimeterParametersPanel = new JPanel();
        perimeterParametersPanel.setLayout(new BoxLayout(perimeterParametersPanel, BoxLayout.Y_AXIS));
//        perimeterPanel.add(perimeterLabel);
        perimeterPanel.add(perimeterParametersPanel);
        panel.add(perimeterPanel);

        setupCircle(areaParametersPanel, perimeterParametersPanel);


        shapeList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    areaParametersPanel.removeAll();
                    perimeterParametersPanel.removeAll();
                    String shapeName = (String) shapeList.getSelectedItem();
                    if(shapeName.equals("Circle")){
                        setupCircle(areaParametersPanel, perimeterParametersPanel);
                    }else if(shapeName.equals("Rectangle")){
                        setupRectangle(areaParametersPanel, perimeterParametersPanel);
                    }
                }
            }
        });

        add(panel);
        pack();
        setTitle("PLOT AREA");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }






    private void setupRectangle(JPanel areaParametersPanel, JPanel perimeterParametersPanel){
        JPanel RectangleLength = new JPanel();
        RectangleLength.setLayout(new BoxLayout(RectangleLength, BoxLayout.X_AXIS));
        JLabel LengthLabel = new JLabel("Enter length here: ");
        final JTextField areaLengthBox = new JTextField(24);
        RectangleLength.add(LengthLabel);
        RectangleLength.add(areaLengthBox);

        JPanel RectangleWidth = new JPanel();
        RectangleWidth.setLayout(new BoxLayout(RectangleWidth, BoxLayout.X_AXIS));
        JLabel areaWidthLabel = new JLabel("Enter width here: ");
        final JTextField areaWidthBox = new JTextField(24);
        RectangleWidth.add(areaWidthLabel);
        RectangleWidth.add(areaWidthBox);

        JPanel SolutionPanel = new JPanel();
        SolutionPanel.setLayout(new BoxLayout(SolutionPanel, BoxLayout.X_AXIS));
        JButton solveButton = new JButton("Solve");
        final JTextField areaTextField = new JTextField(24);
        final JTextField PerimeterTextField = new JTextField(24);
        areaTextField.setBackground(Color.WHITE);
        areaTextField.setEditable(false);
        PerimeterTextField.setBackground(Color.WHITE);
        PerimeterTextField.setEditable(false);

        SolutionPanel.add(areaTextField);
        SolutionPanel.add(PerimeterTextField);

        areaParametersPanel.add(RectangleLength);
        areaParametersPanel.add(RectangleWidth);
        areaParametersPanel.add(SolutionPanel);

        SolutionPanel.add(solveButton);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Rectangle rectangle = new Rectangle(Double.parseDouble(areaLengthBox.getText()), Double.parseDouble(areaWidthBox.getText()));
                areaTextField.setText(rectangle.area()+"");
                PerimeterTextField.setText(rectangle.perimeter()+"");
            }
        });

        areaParametersPanel.revalidate();
        areaParametersPanel.repaint();


    }

    private void setupCircle(JPanel areaParametersPanel, JPanel perimeterParametersPanel){
        JPanel areaRadiusPanel = new JPanel();
        areaRadiusPanel.setLayout(new BoxLayout(areaRadiusPanel, BoxLayout.X_AXIS));
        JLabel areaRadiusLabel = new JLabel("Enter radius here: ");
        final JTextField areaRadiusBox = new JTextField(24);
        areaRadiusPanel.add(areaRadiusLabel);
        areaRadiusPanel.add(areaRadiusBox);

        JPanel SolutionPanel = new JPanel();
        SolutionPanel.setLayout(new BoxLayout(SolutionPanel, BoxLayout.X_AXIS));
        JButton solveButton = new JButton("Solve");
        final JTextField areaTextField = new JTextField(24);
        final JTextField perimeterTextField=new JTextField(24);
        areaTextField.setBackground(Color.WHITE);
        areaTextField.setEditable(false);
        perimeterTextField.setBackground(Color.white);
        perimeterTextField.setEditable(false);
        SolutionPanel.add(solveButton);
        SolutionPanel.add(areaTextField);
        SolutionPanel.add(perimeterTextField);

        areaParametersPanel.add(areaRadiusPanel);
        areaParametersPanel.add(SolutionPanel);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Circle circle = new Circle(Double.parseDouble(areaRadiusBox.getText()));
                areaTextField.setText(circle.area()+"");
                perimeterTextField.setText(circle.perimeter()+"");
            }
        });



        areaParametersPanel.revalidate();
        areaParametersPanel.repaint();

        pack();
    }


}



