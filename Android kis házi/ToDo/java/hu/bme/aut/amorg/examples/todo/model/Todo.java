package hu.bme.aut.amorg.examples.todo.model;

public class Todo {
    public enum Priority { LOW, MEDIUM, HIGH }

    private String title;
    private Priority priority;
    private String dueDate;
    private String description;

    public Todo(String title, Priority priority, String dueDate, String description) {
        this.title = title;
        this.priority = priority;
        this.dueDate = dueDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}