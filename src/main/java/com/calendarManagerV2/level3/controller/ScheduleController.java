package com.calendarManagerV2.level3.controller;

import com.calendarManagerV2.level3.dto.requestdto.ScheduleDeleteReqDTO;
import com.calendarManagerV2.level3.dto.requestdto.ScheduleGetReqDTO;
import com.calendarManagerV2.level3.dto.requestdto.SchedulePatchReqDTO;
import com.calendarManagerV2.level3.dto.requestdto.SchedulePostReqDTO;
import com.calendarManagerV2.level3.dto.responsedto.ScheduleDeleteResDTO;
import com.calendarManagerV2.level3.dto.responsedto.ScheduleGetResDTO;
import com.calendarManagerV2.level3.dto.responsedto.SchedulePatchResDTO;
import com.calendarManagerV2.level3.dto.responsedto.SchedulePostResDTO;
import com.calendarManagerV2.level3.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping("/{userID}")
    public ScheduleGetResDTO getScheduleByUserID(@PathVariable Long userID) {
        return new ScheduleGetResDTO(service.findScheduleByUserID(new ScheduleGetReqDTO(userID)));
    }

    @GetMapping
    public ScheduleGetResDTO getAllSchedules() {
        return new ScheduleGetResDTO(service.findAllSchedules());
    }

    @PostMapping
    public SchedulePostResDTO postSchedule(@RequestBody SchedulePostReqDTO dto) {
        return new SchedulePostResDTO(service.addSchedule(dto));
    }

    @PatchMapping
    public SchedulePatchResDTO patchSchedule(@RequestBody SchedulePatchReqDTO dto) {
        return new SchedulePatchResDTO(service.updateSchedule(dto));
    }

    @DeleteMapping
    public ScheduleDeleteResDTO deleteSchedule(@ModelAttribute ScheduleDeleteReqDTO dto) {
        return new ScheduleDeleteResDTO(service.deleteSchedule(dto));
    }
}
