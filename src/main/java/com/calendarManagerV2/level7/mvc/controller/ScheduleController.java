//package com.calendarManagerV2.level7.mvc.controller;
//
//import com.calendarManagerV2.level7.annotation.IDValidation;
//import com.calendarManagerV2.level7.dto.requestdto.ScheduleDeleteReqDTO;
//import com.calendarManagerV2.level7.dto.requestdto.ScheduleGetReqDTO;
//import com.calendarManagerV2.level7.dto.requestdto.SchedulePatchReqDTO;
//import com.calendarManagerV2.level7.dto.requestdto.SchedulePostReqDTO;
//import com.calendarManagerV2.level7.dto.responsedto.ScheduleDeleteResDTO;
//import com.calendarManagerV2.level7.dto.responsedto.ScheduleGetResDTO;
//import com.calendarManagerV2.level7.dto.responsedto.SchedulePatchResDTO;
//import com.calendarManagerV2.level7.dto.responsedto.SchedulePostResDTO;
//import com.calendarManagerV2.level7.mvc.service.ScheduleService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/schedule")
//@RequiredArgsConstructor
//@Slf4j
//public class ScheduleController extends AbstractController {
//    private final ScheduleService service;
//
//    @GetMapping("/{userID}")
//    public ScheduleGetResDTO getScheduleByUserID(@Valid @IDValidation @PathVariable Long userID) {
//        return new ScheduleGetResDTO(service.findScheduleByUserID(new ScheduleGetReqDTO(userID)));
//    }
//
//    @GetMapping
//    public ScheduleGetResDTO getAllSchedules() {
//        return new ScheduleGetResDTO(service.findAllSchedules());
//    }
//
//    @PostMapping
//    public SchedulePostResDTO postSchedule(@Valid @RequestBody SchedulePostReqDTO dto) {
//        return new SchedulePostResDTO(service.addSchedule(dto));
//    }
//
//    @PatchMapping
//    public SchedulePatchResDTO patchSchedule(@Valid @RequestBody SchedulePatchReqDTO dto, HttpServletRequest req) {
//        return new SchedulePatchResDTO(service.updateSchedule(dto, getSessionUser(req)));
//    }
//
//    @DeleteMapping
//    public ScheduleDeleteResDTO deleteSchedule(@Valid @ModelAttribute ScheduleDeleteReqDTO dto, HttpServletRequest req) {
//        return new ScheduleDeleteResDTO(service.deleteSchedule(dto, getSessionUser(req)));
//    }
//}
