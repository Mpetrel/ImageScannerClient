package io.lovs.imgscan.client.panel.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: ImageScannerClient
 * @description: 进度条
 * @author: Larry
 * @create: 2018-06-08 17:23
 **/
public class JProgressBarDemo {
    private Timer timer;
    private JProgressBar jpbFileLoading;

    private JProgressBarDemo() {
        JFrame jf = new JFrame("进度条测试");

        //创建一个常规模式的进度条，其默认为水平方向，最小值为0，最大值为100，初始值为0
        jpbFileLoading = new JProgressBar();
        //设置进度条呈现进度字符串，默认为false
        jpbFileLoading.setStringPainted(true);
        //不绘制边框，默认为true
        jpbFileLoading.setBorderPainted(false);
        //设置首选大小
        jpbFileLoading.setPreferredSize(new Dimension(100, 40));
        timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int loadingValue = jpbFileLoading.getValue();
                if (loadingValue < 100){
                    jpbFileLoading.setValue(++loadingValue);
                }else {
                    timer.stop();
                }
            }
        });
        timer.start();

        //创建一个不确定模式的进度条
        JProgressBar jpbFileLoadingIndeterminate = new JProgressBar();
        //设置进度条为不确定模式，默认为确定模式
        jpbFileLoadingIndeterminate.setIndeterminate(true);
        jpbFileLoadingIndeterminate.setStringPainted(true);
        jpbFileLoadingIndeterminate.setString("文件加载中......");

        //将两种进度条放到主面板里
        jf.add(jpbFileLoading, BorderLayout.NORTH);
        jf.add(new JLabel("上面为常规进度条，下面为不确定模式进度条", SwingConstants.CENTER), BorderLayout.CENTER);
        jf.add(jpbFileLoadingIndeterminate, BorderLayout.SOUTH);
        jf.setSize(300, 150);
        //居中显示
        jf.setLocationRelativeTo(null);
        //禁用此窗体的装饰
        jf.setUndecorated(true);
        //采用指定的窗体装饰风格
        jf.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        jf.setVisible(true);

        //不确定模式的进度条处理
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //设置进度条为确定模式，即常规模式，否则那个条还会走来走去
        jpbFileLoadingIndeterminate.setIndeterminate(false);
        jpbFileLoadingIndeterminate.setString("文件加载完毕...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //隐藏窗体
        //jf.setVisible(false);
        //释放资源，关闭窗体
        //jf.dispose();
    }

    public static void main(String[] args) {
        new JProgressBarDemo();
    }
}
