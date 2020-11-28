package ir.bpj.testspringboot.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTimeUsingFixedRate() {
        log.info("Using Fixed Rate {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 10000, initialDelay = 1000)
    public void reportCurrentTimeUsingFixedDelay() {
        log.info("Using Fixed Delay {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron="15 44 13 28 * ?")
    public void reportCurrentTimeUsingCron() {
        log.info("Using cron {}", dateFormat.format(new Date()));
    }

}