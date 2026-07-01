import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    private JRadioButton bird, cat, dog, rabbit, pig;
    private JLabel imageLabel;

    public RadioButtonDemo() {

        setTitle("Radio Button Demo");
        setSize(520, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5, 1));

        bird = new JRadioButton("Bird");
        cat = new JRadioButton("Cat");
        dog = new JRadioButton("Dog");
        rabbit = new JRadioButton("Rabbit");
        pig = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(bird);
        group.add(cat);
        group.add(dog);
        group.add(rabbit);
        group.add(pig);

        bird.addActionListener(this);
        cat.addActionListener(this);
        dog.addActionListener(this);
        rabbit.addActionListener(this);
        pig.addActionListener(this);

        leftPanel.add(bird);
        leftPanel.add(cat);
        leftPanel.add(dog);
        leftPanel.add(rabbit);
        leftPanel.add(pig);

        // Right Panel
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (bird.isSelected()) {
            displayPet("Bird", "bird.png");
        }

        if (cat.isSelected()) {
            displayPet("Cat", "cat.png");
        }

        if (dog.isSelected()) {
            displayPet("Dog", "dog.png");
        }

        if (rabbit.isSelected()) {
            displayPet("Rabbit", "rabbit.png");
        }

        if (pig.isSelected()) {
            displayPet("Pig", "pig.png");
        }
    }

    private void displayPet(String petName, String imageFile) {

        ImageIcon icon = new ImageIcon(imageFile);

        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(250, 200, Image.SCALE_SMOOTH);

        imageLabel.setIcon(new ImageIcon(resizedImage));

        JOptionPane.showMessageDialog(
                this,
                "You selected: " + petName,
                "Selected Pet",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new RadioButtonDemo();
        });

    }
}