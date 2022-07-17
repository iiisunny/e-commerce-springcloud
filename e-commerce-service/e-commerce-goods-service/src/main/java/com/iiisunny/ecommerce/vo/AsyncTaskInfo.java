package com.iiisunny.ecommerce.vo;

import com.iiisunny.ecommerce.constant.AsyncTaskStatusEnum;

import java.util.Date;

/**
 * <h1>异步任务执行信息</h1>
 * */
public class AsyncTaskInfo {

    /** 异步任务 id */
    private String taskId;

    /** 异步任务执行状态 */
    private AsyncTaskStatusEnum status;

    /** 异步任务开始时间 */
    private Date startTime;

    /** 异步任务结束时间 */
    private Date endTime;

    /** 异步任务总耗时 */
    private String totalTime;

    public AsyncTaskInfo() {
    }

    public AsyncTaskInfo(String taskId, AsyncTaskStatusEnum status, Date startTime, Date endTime, String totalTime) {
        this.taskId = taskId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalTime = totalTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public AsyncTaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AsyncTaskStatusEnum status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }
}
