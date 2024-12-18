package com.calendarManagerV2.level8.mvc.controller;

import com.calendarManagerV2.level8.annotation.IDValidation;
import com.calendarManagerV2.level8.dto.requestdto.*;
import com.calendarManagerV2.level8.dto.responsedto.ScheduleDeleteResDTO;
import com.calendarManagerV2.level8.dto.responsedto.ScheduleGetResDTO;
import com.calendarManagerV2.level8.dto.responsedto.SchedulePatchResDTO;
import com.calendarManagerV2.level8.dto.responsedto.SchedulePostResDTO;
import com.calendarManagerV2.level8.mvc.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "일정 API", description = "일정 관련 API, 사용 시 로그인 필요")
public class ScheduleController extends AbstractController {
    private final ScheduleService service;

    @Operation(
        summary = "사용자 별 작성 일정 조회",
        description = "수정일 기준 내림차순 조회, query parameter로 ofset, size 전달해 일정 페이징 조회 가능")
    @GetMapping("/{userID}")
    public ScheduleGetResDTO getScheduleByUserID(
        @Valid @IDValidation @PathVariable Long userID,
        @Valid @ModelAttribute PaginationReqDTO dto
    ) {
        return new ScheduleGetResDTO(service.findScheduleByUserID(new ScheduleGetReqDTO(userID), dto));
    }

    @Operation(summary = "모든 일정 조회")
    @GetMapping
    public ScheduleGetResDTO getAllSchedules() {
        return new ScheduleGetResDTO(service.findAllSchedules());
    }

    @Operation(summary = "일정 등록")
    @PostMapping
    public SchedulePostResDTO postSchedule(@Valid @RequestBody SchedulePostReqDTO dto) {
        return new SchedulePostResDTO(service.addSchedule(dto));
    }

    @Operation(summary = "일정 수정", description = "일정 제목, 내용 수정 가능")
    @PatchMapping
    public SchedulePatchResDTO patchSchedule(@Valid @RequestBody SchedulePatchReqDTO dto, HttpServletRequest req) {
        return new SchedulePatchResDTO(service.updateSchedule(dto, getSessionUser(req)));
    }

    @Operation(summary = "일정 삭제")
    @DeleteMapping
    public ScheduleDeleteResDTO deleteSchedule(@Valid @ModelAttribute ScheduleDeleteReqDTO dto, HttpServletRequest req) {
        return new ScheduleDeleteResDTO(service.deleteSchedule(dto, getSessionUser(req)));
    }
}
