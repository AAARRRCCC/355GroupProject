package UI.Parts;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class Button extends JButton{
    String ID;

    public Button(String text, String ID){
        super(text);
        this.ID = ID;
    }

    public String getID(){
        return this.ID;
    }
}
