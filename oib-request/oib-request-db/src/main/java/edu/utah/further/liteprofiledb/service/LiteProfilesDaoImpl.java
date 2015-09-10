package edu.utah.further.liteprofiledb.service;


import edu.utah.further.core.api.data.Dao;
import edu.utah.further.liteprofiledb.domain.CloudProfiles;
import edu.utah.further.liteprofiledb.domain.CustomProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class LiteProfilesDaoImpl implements LiteProfilesDao {

    /** The dao. */
    @Autowired
    @Qualifier( "liteprofilesDao" )
    private Dao dao;

    @Transactional
    public List<CustomProfiles> getCustomProfiles()
    {

        List<CustomProfiles> profiles = dao.findAll(CustomProfiles.class);
        return profiles;
    }

    @Transactional
    public List<CloudProfiles> getCloudProfiles()
    {

        List<CloudProfiles> profiles = dao.findAll(CloudProfiles.class);
        return profiles;
    }

    @Transactional
    public CustomProfiles getCustomProfile(Long id)
    {

        CustomProfiles profile = dao.findById(CustomProfiles.class, id);
        return profile;
    }
}
