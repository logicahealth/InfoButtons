package edu.utah.openinfobutton.externalresource.api;

import java.util.List;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CD;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.CDset;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Code;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.Id;
import edu.duke.mc.cfm.dci.infobutton.schemas.kb.TerminologyInference.CodeInference;

/*
$Rev:: 2327          $:  Revision of last commit
$Author:: ai28       $:  Author of last commit
$Date:: 2011-03-08 1#$:  Date of last commit
*/

public interface ExternalResourceHandler {
	
	 public edu.duke.mc.cfm.dci.infobutton.Code transformCode(
			CodeInference codeInference,
			edu.duke.mc.cfm.dci.infobutton.Code code);

	boolean matchCodeSet(List<Id> subsetIdList, edu.duke.mc.cfm.dci.infobutton.Code code);

}
