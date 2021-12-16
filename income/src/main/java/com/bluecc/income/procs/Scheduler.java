package com.bluecc.income.procs;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.helper.TenantId;
import org.redisson.api.CronSchedule;
import org.redisson.api.RScheduledExecutorService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.TimeUnit;

@Singleton
public class Scheduler {
    LiveObjects liveObjects;
    String tenantId;
    RScheduledExecutorService executorService;

    @Inject
    public Scheduler(LiveObjects liveObjects, @TenantId String tenantId) {
        this.liveObjects = liveObjects;
        this.tenantId = tenantId;

        executorService = liveObjects.redisson().getExecutorService(tenantId);
    }

    public String schedule(Runnable command, long delay, TimeUnit unit){
        return executorService.schedule(command, delay, unit).getTaskId();
    }

    public String schedule(Runnable task, CronSchedule cronSchedule){
        return executorService.schedule(task, cronSchedule).getTaskId();
    }
}
