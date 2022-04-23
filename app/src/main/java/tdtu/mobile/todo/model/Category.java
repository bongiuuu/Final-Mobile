package tdtu.mobile.todo.model;

public class Category {
    private String category;
    private int numberOfTask;
    private String color;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumberOfTask() {
        return numberOfTask;
    }

    public void setNumberOfTask(int numberOfTask) {
        this.numberOfTask = numberOfTask;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category(String category, int numberOfTask, String color) {
        this.category = category;
        this.numberOfTask = numberOfTask;
        this.color = color;
    }
}
