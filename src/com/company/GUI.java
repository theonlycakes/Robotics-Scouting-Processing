package com.company;
import java.awt.*;

public class GUI extends Frame{
GUI() {
    Frame f = new Frame();
    f.setSize(300,300);
    Button b=new Button("click me");
    f.add(b);
    f.setVisible(true);
}


}
