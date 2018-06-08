package io.lovs.imgscan.client.panel.component;

import javax.swing.*;

/**
 * @program: ImageScannerClient
 * @description: 启动进度
 * @author: Larry
 * @create: 2018-06-08 17:26
 **/
public class StartProgressBar {
    private Timer timer;
    private JProgressBar progressBar;
    private JFrame frame;

    public StartProgressBar() {
        frame = new JFrame();
        progressBar = new JProgressBar();
    }

    public void startProgressBar() {
        //设置进度条为不确定模式，默认为确定模式
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("启动中......");
        frame.add(progressBar);
        frame.setSize(300, 50);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        frame.setVisible(true);
    }

    public void stopProgressBar() {
        progressBar.setIndeterminate(false);
        frame.setVisible(false);
        frame.dispose();
    }

}
