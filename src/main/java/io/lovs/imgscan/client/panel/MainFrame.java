package io.lovs.imgscan.client.panel;

import javax.swing.*;

/**
 * @program: ImageScannerClient
 * @description: Application main frame
 * @author: Larry
 * @create: 2018-06-08 16:45
 **/
public class MainFrame {
    /**系统主窗口*/
    private JFrame mainFrame;
    private static int DEFAULT_WIDTH = 900;
    private static int DEFAULT_HEIGHT = 700;

    public MainFrame() {
        this.mainFrame = new JFrame();
    }

    public void startApplication() {
        mainFrame.setTitle("Mamba");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        mainFrame.setVisible(true);
    }



}
