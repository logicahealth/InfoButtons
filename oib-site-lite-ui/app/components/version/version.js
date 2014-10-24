'use strict';

angular.module('oibVersionModule', [
  'oibConfigurationApp.version.interpolate-filter',
  'oibConfigurationApp.version.version-directive'
])

.value('version', '0.1');
