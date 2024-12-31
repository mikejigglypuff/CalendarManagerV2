package com.calendarManagerV2.advanced_lv1and2.dto.request.user;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDeleteReqDTO {
    @ValidPositiveNumber
    private final long userID;
}
