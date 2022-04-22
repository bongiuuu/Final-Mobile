package tdtu.mobile.todo.model;

public class Category {
    private String category;
    private int numberOfTask;

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

    public Category(String category, int numberOfTask) {
        this.category = category;
        this.numberOfTask = numberOfTask;
    }
}
