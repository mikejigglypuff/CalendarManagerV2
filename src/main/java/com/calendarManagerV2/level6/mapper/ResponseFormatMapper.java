package com.calendarManagerV2.level6.mapper;

import java.util.List;

public interface ResponseFormatMapper<T, E>{
    public List<T> mapList(List<E> list);
}