package edu.utah.openinfobutton.externalresource.api;

import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CodedContextElement;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;



public interface ExternalSetHandler {
	
	Boolean matchExternalSet(Code code,List<Id> subsetIdList);

}
