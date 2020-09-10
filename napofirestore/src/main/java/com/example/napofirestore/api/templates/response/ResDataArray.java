package com.example.napofirestore.api.templates.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
class ResDataArray {
    private List list;
    private Pagination paging;

}
