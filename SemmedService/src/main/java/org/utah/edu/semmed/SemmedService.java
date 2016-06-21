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

    @RequestMapping(value = "/json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<CitationWrapper>getCitations(@RequestBody List<String> citations) {
        List<RecentCitationsEntity> cites;
        List<Filter> concepts;
        concepts = semmedServiceDao.getFilters(citations);
        cites = semmedServiceDao.getCitations(citations);
        CitationWrapper d = new CitationWrapper(cites, concepts);
        List<CitationWrapper> a = new ArrayList<CitationWrapper>();
        a.add(d);
        return a;
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
