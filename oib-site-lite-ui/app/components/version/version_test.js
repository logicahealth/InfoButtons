'use strict';

describe('oibVersionModule module', function() {
  beforeEach(module('oibVersionModule'));

  describe('version service', function() {
    it('should return current version', inject(function(version) {
      expect(version).toEqual('0.1');
    }));
  });
});
