package io.lovs.imgscan.client.listener;

import io.lovs.imgscan.client.panel.MainFrame;
import io.lovs.imgscan.client.panel.component.StartProgressBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @program: ImageScannerClient
 * @description: SpringBoot startup listener
 * @author: Larry
 * @create: 2018-06-08 16:59
 **/
@Slf4j
public class ApplicationStartListener implements ApplicationListener {
    private static StartProgressBar startProgressBar = new StartProgressBar();
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // 系统启动监听
        if (applicationEvent instanceof ApplicationPreparedEvent) {
            log.info("ApplicationPreparedEvent listened");
            // 启动系统界面进程
            new MainFrame().startApplication();
            startProgressBar.stopProgressBar();
        }
        // 监听ApplicationEnvironmentPreparedEvent
        else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
            startProgressBar.startProgressBar();
        }
    }
}
