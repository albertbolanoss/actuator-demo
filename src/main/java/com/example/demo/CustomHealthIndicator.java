package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
@Slf4j
public class CustomHealthIndicator implements HealthIndicator {

    private boolean isHealthy = true;

    private Timer mTimer = new Timer();


    private TimerTask mTask = new TimerTask() {
        @Override
        public void run() {
            isHealthy = !isHealthy;
            log.info("Change status : {}", isHealthy);
        }
    };

    public CustomHealthIndicator() {
        mTimer.scheduleAtFixedRate(mTask, 30000, 30000);
    }

    @Override
    public Health health() {
         return isHealthy ? Health.up().build() : Health.down().build();
    }
}
