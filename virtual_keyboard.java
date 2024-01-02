import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * virtual_keyboard
 */
public class virtual_keyboard extends JFrame implements ActionListener {

    String txt = "";
    JTextArea tf = new JTextArea();
    // String letters =
    // "`1234567890-=~!@#$%^&*()_+qwertyuiop{}[]asdfghjkl;';zxcvbnm,./<>?";
    String row1 = "~1234567890-=";
    String row2 = "qwertyuiop[]|{}\\";
    String row3 = "asdfghjkl;'";
    String row4 = "zxcvbnm,./<>?";

    String shift_char_1 = "!@#$%^&*()_+";

    String rowc1 = "~1234567890-=";
    String rowc2 = "QWERTYUIOP[]|{}\\";
    String rowc3 = "ASDFGHJKL;'";
    String rowc4 = "ZXCVBNM,./<>?";

    CardLayout crd_shift = new CardLayout();

    Panel shift_r1_crd = new Panel(crd_shift);
    Panel shift_rc1_crd = new Panel(crd_shift);

    Panel r1 = new Panel(new GridLayout(1, row1.length()));
    Panel shift_r1 = new Panel(new GridLayout(1, row1.length()));
    Panel r2 = new Panel(new GridLayout(1, row2.length()));
    Panel r3 = new Panel(new GridLayout(1, row3.length()));
    Panel r4 = new Panel(new GridLayout(1, row4.length()));
    Panel r5 = new Panel(new GridLayout(1, 1));

    Panel rc1 = new Panel(new GridLayout(1, row1.length()));
    Panel shiftc_r1 = new Panel(new GridLayout(1, row1.length()));
    Panel rc2 = new Panel(new GridLayout(1, row2.length()));
    Panel rc3 = new Panel(new GridLayout(1, row3.length()));
    Panel rc4 = new Panel(new GridLayout(1, row4.length()));
    Panel rc5 = new Panel(new GridLayout(1, 1));

    Panel keys = new Panel(new GridLayout(5, 1));
    Panel keys_cap = new Panel(new GridLayout(5, 1));

    CardLayout crd = new CardLayout();
    Panel ctr = new Panel(crd);

    JButton b = new JButton("SpaceBar");
    JButton b1 = new JButton("BackSpace");
    JButton tab = new JButton("Tab");
    JButton cap = new JButton("CapsLock (OFF)");
    JButton enter = new JButton("Enter");

    JToggleButton shift = new JToggleButton("Shift");
    JToggleButton shiftc = new JToggleButton("Shift");

    JButton bc = new JButton("SpaceBar");
    JButton bc1 = new JButton("BackSpace");
    JButton tabc = new JButton("Tab");
    JButton capc = new JButton("CapsLock (ON)");
    JButton enterc = new JButton("Enter");

    virtual_keyboard() {
        setTitle("Virtual keyboard ");
        setVisible(true);
        add(tf, "North");
        tf.setFont(new Font("Arial", Font.BOLD, 16));
        tf.setPreferredSize(new Dimension(getWidth(), 60));

        init_key_cap(rowc1, rowc2, rowc3, rowc4);
        init_key(row1, row2, row3, row4);

        add(ctr, "Center");

        setSize(1800, 500);

    }

    void init_key(String row1, String row2, String row3, String row4) {
        for (int i = 0; i < row1.length(); i++) {
            JButton b = new JButton("" + row1.charAt(i));
            b.addActionListener(this);
            r1.add(b);
        }

        shift_r1_crd.add(r1); // adding r1 to shift_crd_1 panel

        // adding shift r1

        for (int i = 0; i < shift_char_1.length(); i++) {
            JButton b = new JButton("" + shift_char_1.charAt(i));
            b.addActionListener(this);
            shift_r1.add(b);
        }
        shift_r1_crd.add(shift_r1); // adding shift_r1 to shift_crd_1 panel

        // adding the shift_r1_crd to keys

        keys.add(shift_r1_crd);

        // adding row2 to panel r2

        r2.add(tab);
        for (int i = 0; i < row2.length(); i++) {
            JButton b = new JButton("" + row2.charAt(i));
            b.addActionListener(this);
            r2.add(b);
        }
        tab.addActionListener(this);
        r2.add(b1);
        b1.addActionListener(this);
        keys.add(r2);

        // adding row3 to panel r3
        r3.add(cap);
        for (int i = 0; i < row3.length(); i++) {
            JButton b = new JButton("" + row3.charAt(i));
            b.addActionListener(this);
            r3.add(b);
        }
        r3.add(enter);
        enter.addActionListener(this);
        cap.addActionListener(this);
        keys.add(r3);

        // adding row4 to panle r4

        r4.add(shift);
        for (int i = 0; i < row4.length(); i++) {
            JButton b = new JButton("" + row4.charAt(i));
            b.addActionListener(this);
            r4.add(b);
        }
        shift.addActionListener(this);
        keys.add(r4);

        // adding row5 to panel r5
        b.addActionListener(this);
        r5.add(b);

        keys.add(r5);

        ctr.add(keys);

    }

    void init_key_cap(String row1, String row2, String row3, String row4) {
        for (int i = 0; i < row1.length(); i++) {
            JButton b = new JButton("" + row1.charAt(i));
            b.addActionListener(this);
            rc1.add(b);
        }

        shift_rc1_crd.add(rc1); // adding rc1 to shift_rc1_crd

        // adding shift r1

        for (int i = 0; i < shift_char_1.length(); i++) {
            JButton b = new JButton("" + shift_char_1.charAt(i));
            b.addActionListener(this);
            shiftc_r1.add(b);
        }
        shift_rc1_crd.add(shiftc_r1);

        // adding shiftt_rc1_crd to main keys_cap panel
        keys_cap.add(shift_rc1_crd);

        // adding row2 to panel r2
        rc2.add(tabc);

        for (int i = 0; i < row2.length(); i++) {
            JButton b = new JButton("" + row2.charAt(i));
            b.addActionListener(this);
            rc2.add(b);
        }
        tabc.addActionListener(this);
        rc2.add(bc1);
        bc1.addActionListener(this);
        keys_cap.add(rc2);

        // adding row3 to panel r3
        rc3.add(capc);
        for (int i = 0; i < row3.length(); i++) {
            JButton b = new JButton("" + row3.charAt(i));
            b.addActionListener(this);
            rc3.add(b);
        }
        rc3.add(enterc);
        enterc.addActionListener(this);
        capc.addActionListener(this);
        keys_cap.add(rc3);

        // adding row4 to panle r4

        rc4.add(shiftc);
        for (int i = 0; i < row4.length(); i++) {
            JButton b = new JButton("" + row4.charAt(i));
            b.addActionListener(this);
            rc4.add(b);
        }
        shiftc.addActionListener(this);
        keys_cap.add(rc4);

        // adding row5 to panel r5
        bc.addActionListener(this);
        rc5.add(bc);

        keys_cap.add(rc5);

        ctr.add(keys_cap);

    }

    public void actionPerformed(ActionEvent e) {
        String b = e.getActionCommand();
        if (b.equals("SpaceBar")) {
            txt = txt + " ";

        } else if (b.equals("BackSpace")) {
            if (txt.length() >= 1) {
                txt = txt.substring(0, txt.length() - 1);
            }
        } else if (b.equals("Shift")) {
            if (shiftc.isSelected()) {
                crd_shift.next(shift_r1_crd);
                crd_shift.next(shift_rc1_crd);
            } else {
                crd_shift.next(shift_r1_crd);
                crd_shift.next(shift_rc1_crd);
            }
        } else if (b.equals("Tab")) {
            txt = txt + "\t";
        } else if (b.equals("Enter")) {
            txt = txt + "\n";
        } else if (b.equals("CapsLock (OFF)")) {
            cap.setText("CapsLock (ON)");
            crd.next(ctr);
            System.out.println("here in capslock off listener");
            // a function taht will change the small letters to capital lettes
        } else if (b.equals("CapsLock (ON)")) {
            cap.setText("CapsLock (OFF)");
            crd.next(ctr);
            System.out.println("here in capslock on listener");
        } else {
            txt = txt + b;
        }
        tf.setText(txt + "|");
    }

    public static void main(String[] args) {
        new virtual_keyboard();
    }
}
