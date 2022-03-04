package DesktopClient;

import java.awt.*;
import java.awt.event.*;

import edu.wpi.first.networktables.*;

import static DesktopClient.Constants.Window.*;
import static DesktopClient.Constants.Keyboard.*;
import static DesktopClient.Constants.Mouse.*;
import static DesktopClient.Keyboard.Keys.*;
import static DesktopClient.Mouse.Buttons.*;

public class DesktopClient {

    public static NetworkTableInstance inst;
    public static NetworkTable keyTable;
    public static NetworkTable mouseTable;
    public static NetworkTableEntry keysEntries[];
    public static NetworkTableEntry mouseEntries[];

    private static Frame mainFrame;
    private static Window clientWindow;

    private static final Keyboard board = new Keyboard();
    private static final Mouse mouse = new Mouse();

    public static void main(String args[]) {
        configurateNetworkTable();
        configClientWindow();

    };

    private static void configClientWindow() {

        mainFrame = new Frame("Input");
        clientWindow = new Window(mainFrame);

        mainFrame.setUndecorated(false);
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setVisible(true);
        mainFrame.setPreferredSize(FRAME_DIMENSION);
        
        mainFrame.pack();
        clientWindow.pack();

        mainFrame.addKeyListener(board);
        mainFrame.addMouseListener(mouse);
        mainFrame.addMouseMotionListener(mouse);
        mainFrame.addMouseWheelListener(mouse);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);

            }
            
        });  

    }

    private static void configurateNetworkTable() {
        inst = NetworkTableInstance.getDefault();
        keyTable = inst.getTable("keyboard");
        mouseTable = inst.getTable("mouse");

        keysEntries = new NetworkTableEntry[KEY_AMOUNT + 1];
        mouseEntries = new NetworkTableEntry[ENTRY_AMOUNT];
        
        // Alphanumerics
        keysEntries[A_] = keyTable.getEntry("a");
        keysEntries[B_] = keyTable.getEntry("b");
        keysEntries[C_] = keyTable.getEntry("c");
        keysEntries[D_] = keyTable.getEntry("d");
        keysEntries[E_] = keyTable.getEntry("e");
        keysEntries[F_] = keyTable.getEntry("f");
        keysEntries[G_] = keyTable.getEntry("g");
        keysEntries[H_] = keyTable.getEntry("h");
        keysEntries[I_] = keyTable.getEntry("i");
        keysEntries[J_] = keyTable.getEntry("j");
        keysEntries[K_] = keyTable.getEntry("k");
        keysEntries[L_] = keyTable.getEntry("l");
        keysEntries[M_] = keyTable.getEntry("m");
        keysEntries[N_] = keyTable.getEntry("n");
        keysEntries[O_] = keyTable.getEntry("o");
        keysEntries[P_] = keyTable.getEntry("p");
        keysEntries[Q_] = keyTable.getEntry("q");
        keysEntries[R_] = keyTable.getEntry("r");
        keysEntries[S_] = keyTable.getEntry("s");
        keysEntries[T_] = keyTable.getEntry("t");
        keysEntries[U_] = keyTable.getEntry("u");
        keysEntries[V_] = keyTable.getEntry("v");
        keysEntries[W_] = keyTable.getEntry("w");
        keysEntries[X_] = keyTable.getEntry("x");
        keysEntries[Y_] = keyTable.getEntry("y");
        keysEntries[Z_] = keyTable.getEntry("z");

        keysEntries[N0_] = keyTable.getEntry("0");
        keysEntries[N1_] = keyTable.getEntry("1");
        keysEntries[N2_] = keyTable.getEntry("2");
        keysEntries[N3_] = keyTable.getEntry("3");
        keysEntries[N4_] = keyTable.getEntry("4");
        keysEntries[N5_] = keyTable.getEntry("5");
        keysEntries[N6_] = keyTable.getEntry("6");
        keysEntries[N7_] = keyTable.getEntry("7");
        keysEntries[N8_] = keyTable.getEntry("8");
        keysEntries[N9_] = keyTable.getEntry("9");

        // Symbols
        keysEntries[MN_] = keyTable.getEntry("-");
        keysEntries[EQ_] = keyTable.getEntry("=");
        keysEntries[LB_] = keyTable.getEntry("{");
        keysEntries[RB_] = keyTable.getEntry("}");
        keysEntries[BS_] = keyTable.getEntry("\\");
        keysEntries[SC_] = keyTable.getEntry(";");
        keysEntries[QU_] = keyTable.getEntry("'");
        keysEntries[CM_] = keyTable.getEntry(",");
        keysEntries[PR_] = keyTable.getEntry(".");
        keysEntries[SL_] = keyTable.getEntry("/");
        keysEntries[SP_] = keyTable.getEntry(" ");

        // Mods
        keysEntries[DL_] = keyTable.getEntry("del");
        keysEntries[BP_] = keyTable.getEntry("backspace");
        keysEntries[TB_] = keyTable.getEntry("tab");
        keysEntries[EN_] = keyTable.getEntry("enter");
        keysEntries[SH_] = keyTable.getEntry("shift");
        keysEntries[CT_] = keyTable.getEntry("ctrl");
        keysEntries[AT_] = keyTable.getEntry("alt");
       
        // Function 
        keysEntries[F1_] = keyTable.getEntry("f1");
        keysEntries[F2_] = keyTable.getEntry("f2");
        keysEntries[F3_] = keyTable.getEntry("f3");
        keysEntries[F4_] = keyTable.getEntry("f4");
        keysEntries[F5_] = keyTable.getEntry("f5");
        keysEntries[F6_] = keyTable.getEntry("f6");
        keysEntries[F7_] = keyTable.getEntry("f7");
        keysEntries[F8_] = keyTable.getEntry("f8");
        keysEntries[F9_] = keyTable.getEntry("f9");
        keysEntries[F10_] = keyTable.getEntry("f10");
        keysEntries[F11_] = keyTable.getEntry("f11");
        keysEntries[F12_] = keyTable.getEntry("f12");
        // keysEntries[F13_] = keyTable.getEntry("f13"); note makes keysEntries[] too long
        // keysEntries[F14_] = keyTable.getEntry("f14");
        // keysEntries[F15_] = keyTable.getEntry("f15");
        // keysEntries[F16_] = keyTable.getEntry("f16");
        // keysEntries[F17_] = keyTable.getEntry("f17");
        // keysEntries[F18_] = keyTable.getEntry("f18");
        // keysEntries[F19_] = keyTable.getEntry("f19");
        // keysEntries[F20_] = keyTable.getEntry("f20");
        // keysEntries[F21_] = keyTable.getEntry("f21");
        // keysEntries[F22_] = keyTable.getEntry("f22");
        // keysEntries[F23_] = keyTable.getEntry("f23");
        // keysEntries[F24_] = keyTable.getEntry("f24");

        mouseEntries[M1_] = mouseTable.getEntry("mouse 1");
        mouseEntries[M2_] = mouseTable.getEntry("mouse 2");
        mouseEntries[M3_] = mouseTable.getEntry("mouse 3");
        mouseEntries[MX_] = mouseTable.getEntry("mouse x");
        mouseEntries[MY_] = mouseTable.getEntry("mouse y");
        mouseEntries[MS_] = mouseTable.getEntry("mouse scroll");

        inst.startClientTeam(2557);
        inst.startDSClient();

    }


    
}
