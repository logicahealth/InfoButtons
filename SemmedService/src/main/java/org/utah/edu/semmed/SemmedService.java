package org.utah.edu.semmed; /**
 * Created by JoeNarus on 5/16/16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utah.edu.semmedDao.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class SemmedService {

    @Autowired
    private SemmedServiceDao semmedServiceDao;
    private String JSONTemp1 = "{\"atom:entry\": {\"atom:category\": [{\"@label\": \"(ingredient)\",\"@scheme\": \"CHEM\",\"@term\": \"C0717951\"}, {\"@label\": \"PREVENT\",\"@scheme\": \"CHEM\",\"@term\": \"C0309872\"}, {\"@label\": \"deliver\",\"@scheme\": \"CHEM\",\"@term\": \"C0308779\"}, {\"@label\": \"0.483700007200241\", \"@scheme\": \"org.openinfobutton.qualityProbability\"}, {\"@label\": \"0\", \"@scheme\": \"org.openinfobutton.comparativeStudy\"}, {\"@label\": \"0\", \"@scheme\": \"org.openInfobutton.editorialComments\"}, {\"@label\": \"10.1111/jcpp.12320\", \"@scheme\": \"org.openInfobutton.DOI\"}], \"atom:content\": {\"atom:section\": [{\"@id\": \"BACKGROUND\",\"@label\": \"BACKGROUND\",\"atom:fragment\": [{ \"$\": \"There is a lack of knowledge about specific effective ingredients of prevention programs for youth at risk for persistent delinquent behavior. The present study combines findings of previous studies by examining the effectiveness of programs in preventing persistent juvenile delinquency and by studying which particular program, sample, and study characteristics contribute to the effects. Information on effective ingredients offers specific indications of how programs may be improved in clinical practice.\"}]}, {\"@id\": \"METHODS\",\"@label\": \"METHOD\",\"atom:fragment\": [{\"$\": \"A literature search in PsychINFO, ERIC, PubMed, Sociological Abstracts, Criminal Justice Abstracts, and Google Scholar was performed. Only (quasi)experimental studies and studies that focused on adolescents at risk for (persistent) delinquent behavior were included. Multilevel meta-analysis was conducted on 39 studies (N = 9,084). Participants' ages ranged from 6 to 20 years (M = 14 years, SD = 2.45).\"}]}, {\"@id\": \"RESULTS\",\"@label\": \"RESULTS\", \"atom:fragment\": [{\"$\": \"The overall effect size was significant and small in magnitude (d = 0.24, p < .001). Behavioral-oriented programs, focusing on parenting skills training, behavioral modeling, or behavioral contracting yielded the largest effects. Multimodal programs and programs carried out in the family context proved to be more beneficial than individual and group-based programs. Less intensive programs yielded larger effects.\"}]}, {\"@id\": \"CONCLUSIONS\",\"@label\": \"CONCLUSIONS\",\"atom:fragment\": [ {\"$\": \"Prevention programs have positive effects on preventing persistent juvenile delinquency. In order to improve program effectiveness, interventions should be behavioral-oriented, delivered in a family or multimodal format, and the intensity of the program should be matched to the level of risk of the juvenile.\"}]}]},\"atom:id\": {\"$\": \"25143121\"},\"atom:link\": {\"@href\": \"http://www.ncbi.nlm.nih.gov/pubmed/25143121\",\"@title\": \"Practitioner review: Effective ingredients of prevention programs for youth at risk of persistent juvenile delinquency--recommendations for clinical practice.\"},\"atom:source\": {\"$\": \"J Child Psychol Psychiatry\"},\"atom:summary\": { \"atom:section\": [{\"atom:fragment\": [{\"$\": \"CONCLUSIONS: Prevention programs have positive effects on preventing persistent juvenile delinquency.\"}]}]},\"atom:title\": { \"$\": \"Practitioner review: Effective ingredients of prevention programs for youth at risk of persistent juvenile delinquency--recommendations for clinical practice.\"}, \"atom:updated\": {\"$\": \"2015\"}}}";
    private String JSONTemp2 = "{”atom:entry”: {”atom:category”: [{“@label”: “drotaverine”,”@scheme”: “CHEM”,”@term”: “C0058762”}, {“@label”: “Antispasmodics”,”@scheme”: “CHEM”, “@term”: “C0037766”}, {“@label”: “Antispasmodic Drugs”,”@scheme”: “CHEM”,”@term”: “C0037766”}, {“@label”: “SHAM”,”@scheme”: “CHEM”,”@term”: “C0073980”}, {“@label”: “Drotaverine Hydrochloride”,”@scheme”: “CHEM”,”@term”: “C3273737”}, { “@label”: “deliver”,”@scheme”: “CHEM”,”@term”: “C0308779”}, {“@label”: “0.777800023555756”,”@scheme”: “org.openinfobutton.qualityProbability”}, {“@label”: “0”, “@scheme”: “org.openinfobutton.comparativeStudy”}, {“@label”: “0”,”@scheme”: “org.openInfobutton.editorialComments”}, {“@label”: “10.1016/j.ijgo.2013.08.013”,”@scheme”: “org.openInfobutton.DOI”}], “atom:content”: {“atom:section”: [{ “@id”: “OBJECTIVE”,”@label”: “OBJECTIVE”,”atom:fragment”: [{“$”: “To reevaluate the role of the antispasmodic drug drotaverine in shortening the length of the active first stage of labor among nulliparous women.”}]}, {“@id”: “METHODS”,”@label”: “METHODS”,”atom:fragment”: [{“$”: “In a randomized, double-blind, placebo-controlled trial, 422 young nulliparous women admitted to Ain-shams University Maternity Hospital, Cairo, Egypt, in spontaneous labor were initially enrolled between May and December 2012. Drotaverine hydrochloride (40mg) or placebo was given at the start of the active phase of labor and then repeated every 2hours (maximum 3 doses). All participants were consistently managed in accordance with the local institutional intrapartum protocol. The primary outcome was the rate of cervical dilation.”}]}, {“@id”: “RESULTS”,”@label”: “RESULTS”,”atom:fragment”: [{“$”: “After excluding women who delivered by cesarean, data were analyzed from 320 women. There was a significant difference in post-treatment labor pain scores, duration of the active phase of labor, and rate of cervical dilatation between the 2 groups (P<0.001 for all). There was no difference in maternal adverse effects. Kaplan-Meier survival analysis showed a greater probability of faster delivery among patients treated by drotaverine hydrochloride (log rank test; P<0.001).”}]}, {“@id”: “CONCLUSIONS”,”@label”: “CONCLUSION”,”atom:fragment”: [{“$”: “Drotaverine hydrochloride was used effectively and safely to shorten the duration of the first stage of labor among nulliparous women with active spontaneous labor. ClinicalTrials.gov: NCT01639027.”}]}]},”atom:id”: {“$”: “24299975”},”atom:link”: {“@href”: “http://www.ncbi.nlm.nih.gov/pubmed/24299975“,”@title”: “Drotaverine to improve progression of labor among nulliparous women.”},”atom:source”: {“$”: “Int J Gynaecol Obstet”},”atom:summary”: {“atom:section”: [{“atom:fragment”: [ { “$”: “CONCLUSION: Drotaverine hydrochloride was used effectively and       safely to shorten the duration of the first stage of labor among nulliparous       women with active spontaneous labor.”}]} ]},”atom:title”: {“$”: “Drotaverine to improve progression of labor among nulliparous women.”},”atom:updated”: {“$”: “2014”}}}";

    @RequestMapping(value = "/json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<RecentCitationsEntity>getCitations(@RequestBody List<String> citations) {
        List<RecentCitationsEntity> cites;
        System.out.println(citations);

        cites = semmedServiceDao.getCitations(citations);


        return cites;
       // return new ArrayList<String>();
    }



    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public List<String> get() {

        Citation cit = new Citation();
        List<String> h = new ArrayList<String>();
        h.add("10002");
        cit.SetCitations(h);

        return cit.GetCitations();
    }

}
