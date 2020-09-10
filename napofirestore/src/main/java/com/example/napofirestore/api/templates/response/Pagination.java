package com.example.napofirestore.api.templates.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Pagination {
    private long count;
    private long total;
    private int page;
    private int limit;
    private boolean hasNext;
}
