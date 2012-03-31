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
//    public void newTagToTask(Tag tag, Long taskId, Long userId);
    public List<Tag> getAllTagsToUser(User user);
    public Ownership getOwnershipForTaskByUser(Long taskId, Long userId);
    public List<Ownership> getOwnershipByUser(Long userId);
    public List<Ownership> getOwnershipByTaks(Long taskId);
    public List<Comment> getCommentToTask(Long taskId);
    public void newComment(Comment comment, Long taskId, Long userId); 
    public void newState(State state);
    public List<State> getAllStates();
    public State getState(String name);
    public Type getType(String name);
    public void newType(Type type);
    public List<Type> getAllTypes();
    public Tag getTag(Long id);
    public void storeTag(Tag tag);
    public void storeTag(String text, String color, User user);
    public void storeOwnership(Ownership Ownership);

    public User getUserByEmail(String email);
    
}
