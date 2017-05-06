package org.openinfobutton.liteprofiledb.service;

import org.openinfobutton.liteprofiledb.domain.CloudProfiles;
import org.openinfobutton.liteprofiledb.domain.CustomProfiles;
import org.openinfobutton.liteprofiledb.domain.UserAuthentication;

import java.util.List;

public interface LiteProfilesDao {

    List<CustomProfiles> getCustomProfiles();

    List<CloudProfiles> getCloudProfiles();

    CustomProfiles getCustomProfile(Long id);

    void createOrUpdateCustomProfile (CustomProfiles profile);

    void createOrUpdateCloudProfile (CloudProfiles profile);

    UserAuthentication getUser(String user, String password);

    void createOrUpdateUser (UserAuthentication user);

    void deleteUser (UserAuthentication user);

    List<UserAuthentication> getUsers();
}
