package hackaton.model;

import java.util.List;

public interface DAO {

    public List<Task> getMyTasks(Long userId);
    public Task getTask(Long id);
    public List<Task> getAllTasks();
    public void newTask(Task task);
    public void newUser(User user);
    public List<User> getAllUsers();
    public User getUser(Long id);
    public List<Tag> getTagsForTaskByUser(Long taskId, Long userId);
    public Ownership getOwnershipForTaskByUser(Long taskId, Long userId);
    public void newTagToTask(Tag tag);
    public List<Comment> getCommentToTask(Long taskId);
    public void newComment(Comment comment);
    public List<Ownership> getOwnershipByUser(Long userId);
    public List<Ownership> getOwnershipByTaks(Long taskId);
}
