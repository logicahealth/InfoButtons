Steps to be followed for the resource profiles drupal website.
1)Make sure drupal's version is 7 and php , mysql are configured .
2)In the same database as drupal(where all of drupal's tables are present , create a new table 'resource_profiles' )(Sql file attached)
3)In drupal_home/sites/default/settings.php , add the database settings
$databases = array (
  'default' => 
  array (
    'default' => 
    array (
      'database' => 'drupal',
      'username' => 'drupal',
      'password' => 'drupal',
      'host' => 'localhost',
      'port' => '',
      'driver' => 'mysql',
      'prefix' => '',
    ),
  ));
  Make changes above as required.
4)place the download_profiles.php in the drupal home folder and make changes in the file(database settings).
5)Install the modules(in folder drupal_modules).Enable php and all of the installed profiles.
6)Go to Structure->Data Tables and adopt table 'resource_profiles'
7)Go to Structure -> Views -> importview . Copy and paste the text file(profiles_view_for_drupal) in the folder , the view will be generated.
8)Replace the file style.css in drupal\themes\bartik with the one in the folder
9)Replace sites\all\modules\views\theme with the theme.inc file in the folder.
9)In Content , create two basic pages as follows:
	- Give the page Update status a url alias 'update_status'
	- Copy and paste the php code in the update_status text file and update the URL's to your server.(Search for "localhost")
	- Make sure the text format is php.
	
	*Same way another page,Update existing item , with url alias 'update_existing'
	*Content is in the file update_existing.Update URL's
10)restart apache.
11) you can use other access control modules to restrict access.	
	

