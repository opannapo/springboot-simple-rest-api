package com.example.napofirestore.api.templates.response;

import java.util.List;

public class ResDataArray {
    private List list;
    private Pagination paging;

    public Pagination getPaging() {
        return paging;
    }

    public void setPaging(Pagination paging) {
        this.paging = paging;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
