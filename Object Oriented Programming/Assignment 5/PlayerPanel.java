import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{
    private  JLabel name;
    private JLabel Avatar;
    private JLabel weapon;
    private Editing.StatTracker STR,DEX,CON;

    private boolean playerLoaded = false;
    public PlayerPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        name = new JLabel("No Character Loaded: Please Create or Load a Character!");
        Avatar = new JLabel();
        weapon = new JLabel("");
        add(name);
        add(weapon);
        add(Avatar);

    }
    public void setPlayer(Player player){
        name.setText(player.getName());
        weapon.setText(player.getWeapons());
        Avatar.setIcon(new ImageIcon(player.getAvatarFile()));
    }

    public boolean getPlayerLoaded() {
        return playerLoaded;
    }

    public void setPlayerLoaded() {
        playerLoaded = true;
    }

}
