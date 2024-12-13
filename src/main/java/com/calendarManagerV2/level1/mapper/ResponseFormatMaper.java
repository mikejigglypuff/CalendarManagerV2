package com.calendarManagerV2.level1.mapper;

import java.util.List;

public interface ResponseFormatMaper <T, E>{
    public List<T> mapList(List<E> list);
}
