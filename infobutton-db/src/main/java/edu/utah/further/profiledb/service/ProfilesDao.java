package edu.utah.further.profiledb.service;

import java.io.File;

import edu.utah.further.core.api.context.Api;

@Api
public interface ProfilesDao {

	public void getResourceProfile(long id,int status,FileandMarker fm);

	public long count(int status);
}
