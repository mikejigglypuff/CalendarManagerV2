package com.calendarManagerV2.advanced_lv1and2.mvc.controller;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import com.calendarManagerV2.advanced_lv1and2.dto.request.PaginationReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.ScheduleDeleteReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.ScheduleGetReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.SchedulePatchReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.SchedulePostReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.schedule.ScheduleDeleteResDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.schedule.ScheduleGetResDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.schedule.SchedulePatchResDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.schedule.SchedulePostResDTO;
import com.calendarManagerV2.advanced_lv1and2.mvc.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@Tag(name = "일정 API", description = "일정 관련 API, 접근 시 로그인 필요")
public class ScheduleController extends AbstractController {
    private final ScheduleService service;

    @Operation(
        summary = "사용자 별 작성 일정 조회",
        description = "수정일 기준 내림차순 조회, query parameter로 ofset, size 전달해 일정 페이징 조회 가능")
    @GetMapping("/{userID}")
    public ScheduleGetResDTO getScheduleByUserID(
        @Validated @ValidPositiveNumber @PathVariable Long userID, @ModelAttribute PaginationReqDTO dto
    ) {
        return new ScheduleGetResDTO(service.findScheduleByUserID(new ScheduleGetReqDTO(userID), dto));
    }

    @Operation(summary = "모든 일정 조회")
    @GetMapping
    public ScheduleGetResDTO getAllSchedules(@ModelAttribute PaginationReqDTO dto) {
        return new ScheduleGetResDTO(service.findAllSchedules(dto));
    }

    @Operation(summary = "일정 등록")
    @PostMapping
    public SchedulePostResDTO postSchedule(@Valid @RequestBody SchedulePostReqDTO dto) {
        return new SchedulePostResDTO(service.addSchedule(dto));
    }

    @Operation(summary = "일정 수정", description = "일정 제목, 내용 수정 가능")
    @PatchMapping
    public SchedulePatchResDTO patchSchedule(@RequestBody SchedulePatchReqDTO dto, HttpServletRequest req) {
        return new SchedulePatchResDTO(service.updateSchedule(dto, getSessionUser(req)));
    }

    @Operation(summary = "일정 삭제")
    @DeleteMapping
    public ScheduleDeleteResDTO deleteSchedule(@Valid @ModelAttribute ScheduleDeleteReqDTO dto, HttpServletRequest req) {
        return new ScheduleDeleteResDTO(service.deleteSchedule(dto, getSessionUser(req)));
    }
}
