package com.in4people.bootrestapi.approval.paging;

import com.in4people.bootrestapi.common.PageDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingResponseDTOAP {

    private Object data;
    private PageDTOAP pageInfo;
}
