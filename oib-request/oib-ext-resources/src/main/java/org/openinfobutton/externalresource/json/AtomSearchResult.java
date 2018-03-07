package org.openinfobutton.externalresource.json;

import java.util.List;

public class AtomSearchResult {

    private int pageSize;
    private int pageNumber;
    private int pageCount;
    private List<SourceAtomCluster> result;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<SourceAtomCluster> getResult() {
        return result;
    }

    public void setResult(List<SourceAtomCluster> result) {
        this.result = result;
    }
}
