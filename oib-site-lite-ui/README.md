# OIB Site LITE UI
Site LITE is the Librarian Infobutton Tailoring Environment for Openinfobutton implementation sites.
This project is specific to UI components of Site LITE and is based on the AngularJS technology.

## Dependencies

### Project Dependencies
* NodeJS project: oib-site-lite-rest-server
* OpenInfobutton databases from oib-request and oib-responder; minor modifications have been added to the oib-request database.  See the db directory for update scripts.

### Install Dependencies

We have two kinds of dependencies in this project: tools and angular framework code.  The tools help
us manage and test the application.

* We get the tools we depend upon via `npm`, the [node package manager][npm].
* We get the angular code via `bower`, a [client-side code package manager][bower].

We have preconfigured `npm` to automatically run `bower` so we can simply do:

```
npm install
```

Behind the scenes this will also call `bower install`.  You should find that you have two new
folders in your project.

* `node_modules` - contains the npm packages for the tools we need
* `app/bower_components` - contains the angular framework files

*Note that the `bower_components` folder would normally be installed in the root folder but
angular-seed changes this location through the `.bowerrc` file.  Putting it in the app folder makes
it easier to serve the files by a webserver.*

### Run the Application

We have preconfigured the project with a simple development web server.  The simplest way to start
this server is:

```
npm start
```

Now browse to the app at `http://localhost:8000/app/index.html`.




## Testing (NEEDS Work)

There are two kinds of tests in the angular-seed application: Unit tests and End to End tests.

### Running Unit Tests (NEEDS WORK...)

* the configuration is found at `karma.conf.js`
* the unit tests are found in next to the code they are testing and are named as `..._test.js`.

The easiest way to run the unit tests is to use the supplied npm script:

```
npm test
```

### End to end testing
