package com.example.napofirestore.api.templates.response;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonView(View.BaseResponse.class)
class ResDataArray {
    private List list;
    private Pagination paging;

}
