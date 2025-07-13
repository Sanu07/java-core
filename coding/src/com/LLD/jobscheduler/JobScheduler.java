package com.LLD.jobscheduler;

import java.util.Map;
import java.util.concurrent.*;

public class JobScheduler {

    private ScheduledExecutorService scheduledExecutorService;
    private Map<String, JobMetadata> jobMetadataMap;
    private Map<String, ScheduledFuture<?>> futureMap;

    public JobScheduler(int threadCount) {
        scheduledExecutorService = Executors.newScheduledThreadPool(threadCount);
        this.futureMap = new ConcurrentHashMap<>();
        this.jobMetadataMap = new ConcurrentHashMap<>();
    }

    public void schedule(int jobId, String name, Job job, long startTimeInMillis, long intervalInMillis, String content) {
        JobMetadata jobMetadata = new JobMetadata(jobId, name, job, startTimeInMillis, intervalInMillis);
        jobMetadataMap.put(name, jobMetadata);

        ScheduledFuture<?> future;
        if (intervalInMillis == 0) {
            // one-time
            future = scheduledExecutorService.schedule(() -> {
                if (!jobMetadata.isCancelled()) {
                    job.execute(content);
                }
            }, 0, TimeUnit.MILLISECONDS);
        } else {
            // recurring
            future = scheduledExecutorService.scheduleAtFixedRate(() -> {
                if (!jobMetadata.isCancelled()) {
                    job.execute(content);
                }
            }, 0, intervalInMillis, TimeUnit.MILLISECONDS);
        }
        futureMap.put(jobMetadata.getName(), future);
    }

    public boolean cancel(String jobName) {
        ScheduledFuture<?> future = futureMap.get(jobName);
        JobMetadata jobMetadata = jobMetadataMap.get(jobName);
        if (future != null && jobMetadata != null) {
            jobMetadata.setCancelled(true);
            future.cancel(false);
        }
        return false;
    }

    public void shutdown() {
        scheduledExecutorService.shutdown();
    }
}
