package edu.utah.further.profiledb.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrew on 4/7/2016.
 */
@Entity
@Table( name = "profile_black_list" )
public class ProfileBlackList implements Serializable
{
    // ========================= CONSTANTS =================================
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /**
     * The unique identifier of this entity.
     */

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    public Integer id;

    /** The title. */
    @Column( name = "profileTitle" )
    public String profileTitle;

    /** The profile Id. */
    @Column( name = "profileID" )
    public int profileID;

    /** The userId. */
    @Column( name = "userId" )
    public String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfileTitle() {
        return profileTitle;
    }

    public void setProfileTitleTitle(String profileTitle) {
        this.profileTitle = profileTitle;
    }

    public int getProfileID() {
        return profileID;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
