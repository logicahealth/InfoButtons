package org.utah.edu.semmed;
import javax.persistence.*;
import java.util.List;

/**
 * Created by JoeNarus on 5/18/16.
 */
public class Citation {

    @Column(name="email")
    private List<String> citations;
   // private String citations;

//    public String Getcitations() {
//        return citations;
//    }
//
//    public void Setcitations(String s) {
//        this.citations = s;
//    }


    public List<String> GetCitations() {
        return citations;

    }

    public void SetCitations(List<String> citations) {
        this.citations = citations;
    }
}
