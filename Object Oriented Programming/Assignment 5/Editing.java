import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Editing extends JPanel implements ActionListener,DocumentListener {
    private final JTextField TextField;
    private final JButton Submit;
    private static JLabel AvatarPNG;
    private static SpinnerNumberModel STR,DEX,CON;
    private final JComboBox<File> Avatars;
    private final JComboBox Weapons;
    String[] weapons;
    public Editing(ActionListener ActionEvent) {

        GridBagConstraints grid = new GridBagConstraints();
        setLayout(new GridBagLayout());

        JLabel panel = new JLabel("Name:");
        TextField = new JTextField("");
        Submit = new JButton("Create");
        JButton cancelButton = new JButton("Cancel");

        weapons = new String[]{"Greataxe 1d12 0", "Mace 1d12 0", "Longsword 1d10 1", "Warhammer 1d8 2", "Shortsword 1d6 3", "Dagger 1d4 4", "Sword 1d6 4", "Bow 1d4 6"};
        Weapons = new JComboBox(weapons);
        Weapons.addActionListener(this);

        File[] file = new File("img/").listFiles();
        Avatars = new JComboBox<>(file);
        AvatarPNG = new JLabel();
        Avatars.addActionListener(this);

        statsSpinner();

        grid.gridx = 1;
        grid.gridy = -5;
        grid.fill = GridBagConstraints.NONE;
        add(Weapons, grid);

        grid.gridx = 2;
        grid.gridy = -5;
        grid.fill = GridBagConstraints.NONE;
        add(Avatars, grid);

        grid.gridx = 2;
        grid.gridy = 0;
        grid.fill = GridBagConstraints.NONE;
        add(AvatarPNG, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        grid.fill = GridBagConstraints.NONE;
        add(panel, grid);

        grid.gridx = 2;
        grid.gridy = 1;
        grid.fill = GridBagConstraints.HORIZONTAL;
        TextField.getDocument().addDocumentListener(this);
        TextField.setPreferredSize(new Dimension(200, 25));
        add(TextField, grid);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridBagLayout());

        grid.gridx = 0;
        grid.gridy = 1;
        Submit.addActionListener(ActionEvent);
        Submit.setActionCommand("Editing.Submit");
        Submit.setEnabled(false);
        buttons.add(Submit, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        cancelButton.addActionListener(ActionEvent);
        cancelButton.setActionCommand("Editing.Cancel");
        buttons.add(cancelButton, grid);

        grid.gridx = 1;
        grid.gridy = 2;
        grid.gridwidth = 4;
        add(buttons, grid);

    }

    private void statsSpinner() {

        GridBagConstraints grid = new GridBagConstraints();
        setLayout(new GridBagLayout());
        STR = new SpinnerNumberModel(0,0,15,1);
        JSpinner Strength = new JSpinner(STR);
        Strength.setPreferredSize(new Dimension(80,25));
        Strength.addChangeListener(new StatTracker(STR));
        grid.gridx = 3;
        grid.gridy = 20;
        grid.fill = GridBagConstraints.NONE;
        Strength.add(new JLabel("STR: "));
        add(Strength,grid);

        DEX = new SpinnerNumberModel(0,0,15,1);
        JSpinner Dexterity = new JSpinner(DEX);
        Dexterity.setPreferredSize(new Dimension(80,25));
        Dexterity.addChangeListener(new StatTracker(DEX));
        grid.gridx = 4;
        grid.gridy = 20;
        grid.fill = GridBagConstraints.NONE;
        Dexterity.add(new JLabel("DEX: "));
        add(Dexterity,grid);

        CON = new SpinnerNumberModel(0,0,15,1);
        JSpinner Con = new JSpinner(CON);
        Con.setPreferredSize(new Dimension(80,25));
        Con.addChangeListener(new StatTracker(CON));
        grid.gridx = 5;
        grid.gridy = 20;
        grid.fill = GridBagConstraints.NONE;
        Con.add(new JLabel("CON: "));
        add(Con,grid);
    }
    static class StatTracker implements ChangeListener {

        private static ArrayList<SpinnerNumberModel> listOfModel = new ArrayList<SpinnerNumberModel>();
        private int previousValue;

        public StatTracker(SpinnerNumberModel model) {
            listOfModel.add(model);
            previousValue = (int)model.getValue();
        }

        @Override
        public void stateChanged(ChangeEvent e) {


            if(statTotals() > 15) {
                ((JSpinner)e.getSource()).getModel().setValue(previousValue);
            } else {
                previousValue = (int)((JSpinner)e.getSource()).getModel().getValue();
            }
        }

        private int statTotals() {
            int sum = 0;
            for(SpinnerNumberModel m : listOfModel) {
                sum += (int)m.getValue();
            }
            return sum;
        }
    }
    public static void setSTR(SpinnerNumberModel STR) { Editing.STR = STR;}
    public static void setDEX(SpinnerNumberModel DEX) { Editing.DEX = DEX;}
    public static void setCON(SpinnerNumberModel CON) { Editing.CON = CON;}
    public static int getSTR(){
        return  (int)STR.getValue();
    }
    public static int getDEX(){
        return  (int)DEX.getValue();
    }
    public static int getCON(){
        return  (int)CON.getValue();
    }
    public String getPlayerName() {
        return TextField.getText();
    }

    public String getWeapon(){
        return (String) Weapons.getSelectedItem();
    }
    public String getAvatarPath() {
        int index = Avatars.getSelectedIndex();
        File file = Avatars.getItemAt(index);
        return file.getAbsolutePath();
    }
    public void textFieldEmpty() { TextField.setText("");}
    public void clearOtherFields() {
        STR.setValue(getSTR());
        DEX.setValue(getDEX());
        CON.setValue(getCON());
        AvatarPNG.setIcon(null);
        TextField.setText("");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = Avatars.getSelectedIndex();
        File file = Avatars.getItemAt(index);
//        AvatarPNG.setIcon(new ImageIcon(file.getAbsolutePath()));
        try{
            Image image = ImageIO.read(file.getAbsoluteFile());
            image = image.getScaledInstance(100,100,Image.SCALE_DEFAULT);
            AvatarPNG.setIcon(new ImageIcon(image));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        Submit.setEnabled(TextField.getDocument().getLength() != 0);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        Submit.setEnabled(TextField.getDocument().getLength() != 0);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
