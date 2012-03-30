package hackaton.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;
import java.util.ArrayList;
import java.util.List;

public class DAOImpl extends DAOBase implements DAO {

    public List<Task> getMyTasks(Long userId) {
        List<Ownership> ownership = getOwnershipByUser(userId);
        List<Task> task = new ArrayList<Task>();
        for (Ownership own : ownership) {
            task.add(ofy().get(own.getTask()));
        }
        return task;
    }

    public List<Task> getAllTasks() {
        return ofy().query(Task.class).list();
    }

    public void newTask(Task task) {
        ofy().put(task);
    }

    public Task getTask(Long id) {
        return ofy().get(Task.class, id);
    }

    public void newUser(User user) {
        ofy().put(user);
    }

    public List<User> getAllUsers() {
        return ofy().query(User.class).list();
    }

    public User getUser(Long id) {
        return ofy().get(User.class, id);
    }

    public Ownership getOwnershipForTaskByUser(Long taskId, Long userId) {
        return ofy().query(Ownership.class).filter("user =", new Key<User>(User.class, userId))
                                           .filter("task =", new Key<Task>(Task.class, taskId)).get();
    }

    public List<Tag> getTagsForTaskByUser(Long taskId, Long userId) {
        Ownership ownership = getOwnershipForTaskByUser(taskId, userId);
        return ofy().query(Tag.class).filter("ownership =", new Key<Ownership>(Ownership.class, ownership.getId())).list();
    }

    public void newTagToTask(Tag tag) {
        ofy().put(tag);
    }

    public List<Comment> getCommentToTask(Long taskId) {
        List<Ownership> ownerships = getOwnershipByTaks(taskId);
        List<Comment> comments = new ArrayList<Comment>();

        for (Ownership ownership : ownerships) {
            comments.addAll(ofy().query(Comment.class).filter("ownership =", ownership.getId()).list());
        }

        return comments;
    }

    public void newComment(Comment comment) {
        ofy().put(comment);
    }

    public List<Ownership> getOwnershipByUser(Long userId) {
        return ofy().query(Ownership.class).filter("user =", new Key<User>(User.class, userId)).list();
    }

    public List<Ownership> getOwnershipByTaks(Long taskId) {
        return ofy().query(Ownership.class).filter("task =", new Key<Task>(Task.class, taskId)).list();
    }





}