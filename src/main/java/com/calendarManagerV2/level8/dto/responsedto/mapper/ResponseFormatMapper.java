package com.calendarManagerV2.level8.dto.responsedto.mapper;

import java.util.List;

// 엔티티 리스트 매퍼들은 공통적인 기능만 구현하면 되므로 구현 사항을 정의한 인터페이스
public interface ResponseFormatMapper<T, E> {
    public List<T> mapList(List<E> list);
}
