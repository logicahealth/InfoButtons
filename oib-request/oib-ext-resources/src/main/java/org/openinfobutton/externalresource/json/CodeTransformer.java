package org.openinfobutton.externalresource.json;

/**
 * Created by JoeNarus on 7/19/16.
 */
public class CodeTransformer {
    private int pageSize;
    private int pageNumber;
    private CodeTransformerResult result;

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


    public CodeTransformerResult getResult() {
        return result;
    }

    public void setResult(CodeTransformerResult result) {
        this.result = result;
    }
}
