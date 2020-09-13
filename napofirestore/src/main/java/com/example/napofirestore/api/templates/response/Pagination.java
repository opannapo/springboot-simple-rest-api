package com.example.napofirestore.api.templates.response;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonView(View.BaseResponse.class)
class Pagination {
    private long count;
    private long total;
    private int page;
    private int limit;
    private boolean hasNext;
}
