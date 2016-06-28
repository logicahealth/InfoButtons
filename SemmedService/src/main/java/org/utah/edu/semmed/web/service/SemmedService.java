package org.utah.edu.semmed.web.service; /**
 * Created by JoeNarus on 5/16/16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.utah.edu.semmed.db.dao.SemmedServiceDao;
import org.utah.edu.semmed.db.domain.RecentCitationsEntity;
import org.utah.edu.semmed.web.wrappers.CitationWrapper;
import org.utah.edu.semmed.web.wrappers.Filter;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SemmedService {

    @Autowired
    private SemmedServiceDao semmedServiceDao;
    @Autowired
    private PropertiesHandler props;
    @RequestMapping(value = "/json", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<CitationWrapper>getCitations(@RequestBody List<String> citations, @RequestHeader(value = "Authorization", required=false) String credentials) {
        String[] splitt = credentials.split(":");
        System.out.println(props.username);
        if(splitt[0].equals(props.username) && splitt[1].equals(props.password)) {
            System.out.println(splitt[0] + " " + splitt[1]);

            List<RecentCitationsEntity> cites;
            List<Filter> concepts;
            concepts = semmedServiceDao.getFilters(citations);
            cites = semmedServiceDao.getCitations(citations);
            CitationWrapper d = new CitationWrapper(cites, concepts);
            List<CitationWrapper> a = new ArrayList<CitationWrapper>();
            a.add(d);

            return a;
        }
        else
            return null;
    }

}
