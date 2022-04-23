package tdtu.mobile.todo.model;

public class Task {
    private int status;
    private String taskTitle;
    private int priority;
    private int percent;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Task(int status, String taskTitle, int priority, int percent) {
        this.status = status;
        this.taskTitle = taskTitle;
        this.priority = priority;
        this.percent = percent;
    }
}
