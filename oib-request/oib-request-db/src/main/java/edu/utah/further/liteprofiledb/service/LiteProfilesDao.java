package edu.utah.further.liteprofiledb.service;

import edu.utah.further.liteprofiledb.domain.CloudProfiles;
import edu.utah.further.liteprofiledb.domain.CustomProfiles;
import edu.utah.further.profiledb.domain.Profiles;

import java.util.List;

public interface LiteProfilesDao {

    List<CustomProfiles> getCustomProfiles();

    List<CloudProfiles> getCloudProfiles();

    CustomProfiles getCustomProfile(Long id);

    void createOrUpdateCustomProfile (CustomProfiles profile);

    void createOrUpdateCloudProfile (CloudProfiles profile);
}
