package com.example.napofirestore.api.templates.response;

import com.example.napofirestore.api.common.exceptions.NoResultException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(value = HttpStatus.OK)
public class Res {
    @Getter
    private Object data;

    @Setter
    @Getter
    private boolean isSuccess;

    @Setter
    @Getter
    private ResError error;

    public void setData(Object data, int page, int limit) {
        System.out.print("LOG DATA -> " + data);
        if (data == null || data.equals(Optional.empty())) {
            throw new NoResultException("Content Not Found");
        }

        if (data instanceof List) {
            ResDataArray dArray = new ResDataArray();
            Pagination pagination = new Pagination();

            pagination.setCount(((List) data).size());
            pagination.setPage(page + 1);
            pagination.setLimit(limit);
            pagination.setHasNext(false);
            pagination.setTotal(((List) data).size());

            dArray.setList((List) data);
            dArray.setPaging(pagination);

            this.data = dArray;
        } else if (data instanceof Page) {
            ResDataArray dArray = new ResDataArray();
            Page p = (Page) data;
            Pagination pagination = new Pagination();

            pagination.setCount(p.getContent().size());
            pagination.setPage(p.getNumber() + 1);
            pagination.setLimit(p.getSize());
            pagination.setHasNext(!p.isLast());
            pagination.setTotal(p.getTotalElements());

            dArray.setList(p.getContent());
            dArray.setPaging(pagination);
            this.data = dArray;
        } else {
            this.data = data;
        }
    }

}

