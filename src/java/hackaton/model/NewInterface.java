/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackaton.model;

import java.util.List;

/**
 *
 * @author Petr
 */
public interface NewInterface {

    List<Comment> getCommentsForOwnerships(List<Ownership> ownerships);
    
}
