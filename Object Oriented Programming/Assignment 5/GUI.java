
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class GUI implements ActionListener {
    private final JFrame frame;
    private JPanel panel;
    private final Editing editPanel;
    private final PlayerPanel playerPanel;
    JMenuBar menuBar;
    JMenu fileMenu;
    JButton[] Buttons = new JButton[4];
    JButton NewCharacter, SaveCharacter, LoadCharacter, EditCharacter;
    JMenuItem New, Load, Save, Exit;

    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    String line = "";
    public GUI() { // basic JFrame
        frame = new JFrame("CSE 1325 RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        editPanel = new Editing(new EditingListener());
        playerPanel = new PlayerPanel();

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");

        New = new JMenuItem("New Character");
        Load = new JMenuItem("Load Character");
        Save = new JMenuItem("Save Character");
        Exit = new JMenuItem("Exit");

        New.addActionListener(this);
        Load.addActionListener(this);
        Save.addActionListener(this);
        Exit.addActionListener(this);

        fileMenu.add(New);
        fileMenu.add(Save);
        fileMenu.add(Load);
        fileMenu.add(Exit);

        menuBar.add(fileMenu);
        frame.add(menuBar, BorderLayout.NORTH);

        mainButtons();

        frame.setVisible(true);
    }

    private void mainButtons() {

        NewCharacter = new JButton("New Character");
        EditCharacter = new JButton("Edit Character");
        SaveCharacter = new JButton("Save Character");
        LoadCharacter = new JButton("Load Character");
        NewCharacter.setAlignmentX(Component.CENTER_ALIGNMENT);
        EditCharacter.setAlignmentX(Component.CENTER_ALIGNMENT);
        SaveCharacter.setAlignmentX(Component.CENTER_ALIGNMENT);
        LoadCharacter.setAlignmentX(Component.CENTER_ALIGNMENT);

        Buttons[0] = NewCharacter;
        Buttons[1] = EditCharacter;
        Buttons[2] = SaveCharacter;
        Buttons[3] = LoadCharacter;

//        Buttons[0].addActionListener(this);
//        Buttons[0].setFont(myFont);
//        Buttons[0].setFocusable(false);
//        Buttons[3].addActionListener(this);
//        Buttons[3].setFont(myFont);
//        Buttons[3].setFocusable(false);

        for (JButton button : Buttons) {
            button.addActionListener(this);
            button.setFont(myFont);
            button.setFocusable(false);
        }

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));


        panel.add(Box.createVerticalGlue());
        panel.add(playerPanel);
        panel.add(Box.createVerticalGlue());
        panel.add(Buttons[0]);
        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(Buttons[3]);
        panel.add(Box.createVerticalGlue());

        frame.add(panel,BorderLayout.CENTER);
    }
    private void editPanel() {
        if (editPanel.isShowing()) {return;}
        frame.remove(panel);
        frame.add(editPanel);
        frame.revalidate();
        frame.repaint();
    }
    private void savePanel(){
        JFileChooser saveFile = new JFileChooser();
        saveFile.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");
        saveFile.setFileFilter(filter);
        int input = saveFile.showSaveDialog(playerPanel);
        saveFile(saveFile,input);
    }
    private void loadMethod() throws IOException {

        JFileChooser chooseFile = new JFileChooser();
        chooseFile.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");
        chooseFile.setFileFilter(filter);
        int respondant = chooseFile.showOpenDialog(null);
        if(respondant == JFileChooser.APPROVE_OPTION){
            File file = new File(chooseFile.getSelectedFile().getPath());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null){
                String[] CSV = line.split(",");
                Player player = new Player(CSV[0]);
                player.setAvatarFile(CSV[5]);
                player.setWeapons(CSV[4]);
                Editing.setSTR(new SpinnerNumberModel(Integer.parseInt(CSV[1]),0,15,1));
                Editing.setDEX(new SpinnerNumberModel(Integer.parseInt(CSV[2]),0,15,1));
                Editing.setCON(new SpinnerNumberModel(Integer.parseInt(CSV[3]),0,15,1));
                playerPanel.setPlayer(player);
            }
            playerPanel.setPlayerLoaded();
        }

    }
    private void exitMethod() {
        
        int answer = JOptionPane.showConfirmDialog(null, "Would you like to save your current character?", "Exiting...", JOptionPane.YES_NO_OPTION);
        if(answer == 0){
            JFileChooser saveFile = new JFileChooser();
            saveFile.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files","csv");
            saveFile.setFileFilter(filter);
            int respondant = saveFile.showSaveDialog(null);
            saveFile(saveFile, respondant);
            frame.dispose();
        }
        else if(answer == 1){
            frame.dispose();
        }
    }
    private void saveFile(JFileChooser saveFile, int respondant) {
        if(respondant == JFileChooser.APPROVE_OPTION){
            File file;
            PrintWriter out = null;
            file = new File(saveFile.getSelectedFile().getAbsolutePath());
            try {
                out = new PrintWriter(file);
                out.println(editPanel.getPlayerName() + "," +  Editing.getSTR() + "," + Editing.getDEX() + "," + Editing.getCON()  + "," + editPanel.getWeapon() + "," + editPanel.getAvatarPath());
            } catch (FileNotFoundException ex) { ex.printStackTrace(); }
            finally {
                assert out != null;
                out.close();}
        }
    }

    private void loadButtons() {
        panel.add(Buttons[1]);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(Buttons[2]);
        panel.add(Box.createVerticalGlue());
    }
    private void mainPanel() {
        if (panel.isShowing()) {return;}
        frame.remove(editPanel);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "New Character" -> editPanel();
            case "Edit Character" -> {
                if(playerPanel.getPlayerLoaded()) {
                    editPanel();}
            }
            case "Save Character" -> {
                if(playerPanel.getPlayerLoaded()) { savePanel(); }
            }
            case "Load Character" -> {
                try {
                    loadMethod();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if(playerPanel.getPlayerLoaded()) {

                    loadButtons();
                }
            }
            case "Exit" -> {
                if(playerPanel.getPlayerLoaded()){
                    exitMethod();
                }else {
                    frame.dispose();
                }

            }
        }
    }
    private class EditingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String action = actionEvent.getActionCommand();
            switch (action) {
                case "Editing.Submit" -> {
                    Player player = new Player(editPanel.getPlayerName());
                    player.setAvatarFile(editPanel.getAvatarPath());
                    player.setWeapons(editPanel.getWeapon());
                    System.out.printf("Player %s is created.\n",player);
                    playerPanel.setPlayer(player);
                    playerPanel.setPlayerLoaded();
                    loadButtons();
                    mainPanel();
                }
                case "Editing.Cancel" -> {
                    editPanel.textFieldEmpty();
                    mainPanel();
                }
            }
        }

    }
}