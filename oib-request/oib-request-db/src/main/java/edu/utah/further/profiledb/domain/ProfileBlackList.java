package edu.utah.further.profiledb.domain;

import edu.utah.further.core.api.data.PersistentEntity;

import javax.persistence.*;

/**
 * Created by Andrew on 4/7/2016.
 */
@Entity
@Table( name = "profile_black_list" )
public class ProfileBlackList implements PersistentEntity<Long>
{
    // ========================= CONSTANTS =================================
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /**
     * The unique identifier of this entity.
     */

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public Long id;

    /** The title. */
    @Column( name = "title" )
    public String title;

    /** The userId. */
    @Column( name = "userId" )
    public String userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
