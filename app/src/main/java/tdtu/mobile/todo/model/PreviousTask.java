package tdtu.mobile.todo.model;

public class PreviousTask {
    private int status;
    private String taskTitle;
    private String time;

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

    public PreviousTask(int status, String taskTitle, String time) {
        this.status = status;
        this.taskTitle = taskTitle;
        this.time = time;
    }
}
