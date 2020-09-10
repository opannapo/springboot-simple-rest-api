package com.example.napofirestore.api.templates.response;

public class Pagination {
    private long count;
    private long total;
    private int page;
    private int limit;
    private boolean hasNext;

    public long getCount() {
        return count;
    }

    void setCount(long count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public long getTotal() {
        return total;
    }

    void setTotal(long total) {
        this.total = total;
    }
}
