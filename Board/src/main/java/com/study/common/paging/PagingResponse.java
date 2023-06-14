package com.study.common.paging;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PagingResponse<T> {

    private List<T> list = new ArrayList<>(); // T는 Type을 의미하며, 어떤 타입의 객체던 데이터로 받겠다는 걸 의미합니다.
    private Pagination pagination; //계산된 페이지 정보를 해당 변수에 저장합니다.

    public PagingResponse(List<T> list, Pagination pagination) {
        this.list.addAll(list);
        this.pagination = pagination;
    }

}