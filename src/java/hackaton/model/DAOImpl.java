package hackaton.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;
import java.util.ArrayList;
import java.util.List;

public class DAOImpl extends DAOBase implements DAO {

    static {
        ObjectifyService.register(User.class);
        ObjectifyService.register(Comment.class);
        ObjectifyService.register(Ownership.class);
        ObjectifyService.register(State.class);
        ObjectifyService.register(Tag.class);
        ObjectifyService.register(Type.class);
        ObjectifyService.register(Task.class);
        ObjectifyService.register(OwnershipTag.class);
        Objectify ofy = ObjectifyService.beginTransaction();
        User user = new User(1L, "Jmeno", "Prijmeni", "test@example.com", "", Role.ADMIN);
        ofy.put(user);
        ofy.getTxn().commit();
     }


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
        return ofy().query(Ownership.class).filter("user =", new Key<User>(User.class, userId)).filter("task =", new Key<Task>(Task.class, taskId)).get();
    }

    public List<Tag> getTagsForTaskByUser(Long taskId, Long userId) {
        Ownership ownership = getOwnershipForTaskByUser(taskId, userId);
        if (ownership != null) {
            return ofy().query(Tag.class).filter("ownership =", new Key<Ownership>(Ownership.class, ownership.getId())).list();
        } else {
            return new ArrayList<Tag>();
        }
    }

    public List<Comment> getCommentToTask(Long taskId) {
        List<Ownership> ownerships = getOwnershipByTaks(taskId);
        List<Comment> comments = new ArrayList<Comment>();

        for (Ownership ownership : ownerships) {
            comments.addAll(ofy().query(Comment.class).filter("ownership =", new Key<Ownership>(Ownership.class, ownership.getId())).list());
        }

        return comments;
    }

    public void newComment(Comment comment, Long taskId, Long userId) {
        Ownership ownership = getOwnershipForTaskByUser(taskId, userId);
        if (ownership != null) {
            comment.setOwnership(new Key<Ownership>(Ownership.class, ownership.getId()));
            ofy().put(comment);
        }
    }

    public List<Ownership> getOwnershipByUser(Long userId) {
        return ofy().query(Ownership.class).filter("user =", new Key<User>(User.class, userId)).list();
    }

    public List<Ownership> getOwnershipByTaks(Long taskId) {
        return ofy().query(Ownership.class).filter("task =", new Key<Task>(Task.class, taskId)).list();
    }

    public List<Tag> getAllTagsToUser(User user) {
        return ofy().query(Tag.class).filter("owner =", new Key<User>(User.class, user.getId())).list();
    }

    public void newState(State state) {
        ofy().put(state);
    }

    public void newType(Type type) {
        ofy().put(type);
    }

    public List<State> getAllStates() {
        return ofy().query(State.class).list();
    }

    public List<Type> getAllTypes() {
        return ofy().query(Type.class).list();
    }

    public Tag getTag(Long id) {
        return ofy().get(Tag.class, id);
    }

    public void storeTag(String text, String color, User user) {
        storeTag(new Tag(null, text, color, user));
    }
    
    public void storeTag(Tag tag) {
        ofy().put(tag);
    }

    public State getState(String name) {
        return ofy().query(State.class).filter("name =", name).get();
    }

    public Type getType(String name) {
        return ofy().query(Type.class).filter("name =", name).get();
    }

    public User getUserByEmail(String email) {
        return ofy().query(User.class).filter("email =", email).get();
    }

    public void storeOwnership(Ownership ownership) {
        ofy().put(ownership);
    }

    public void storeComment(Comment comment) {
        ofy().put(comment);
    }

    public List<Comment> getComments() {
        return ofy().query(Comment.class).list();
    }

}
