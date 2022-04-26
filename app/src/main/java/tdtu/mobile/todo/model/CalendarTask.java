package tdtu.mobile.todo.model;

public class CalendarTask {
    private int status;
    private String taskTitle;
    private String time;
    private int priority;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public CalendarTask(int status, String taskTitle, String time, int priority) {
        this.status = status;
        this.taskTitle = taskTitle;
        this.time = time;
        this.priority = priority;
    }
}
