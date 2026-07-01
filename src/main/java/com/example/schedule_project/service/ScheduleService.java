package com.example.schedule_project.service;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.exception.InvalidPasswordException;
import com.example.schedule_project.exception.ScheduleNotFoundException;
import com.example.schedule_project.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository schedule_repository;

    // < 저장(C) >
    @Transactional
    public ScheduleResponse save(ScheduleRequest request) {
        validateCreateRequest(request);

        // 요청 레코드 추가
        Schedule schedule_entity = new Schedule(request.getTitle(), request.getContent(), request.getAuthor(),
                request.getPassword());

        // 표에 저장
        Schedule savedSchedule = schedule_repository.save(schedule_entity);

        // 추가했다고 알려주기
        return new ScheduleResponse(savedSchedule.getId(),
                savedSchedule.getTitle(), savedSchedule.getContent(), savedSchedule.getAuthor(),
                savedSchedule.getCreateAt(), savedSchedule.getUpdatedAt());
    }


    // < 단 건 조회(R) >
    @Transactional(readOnly = true)
    public ScheduleResponse getOne(Long id) {
        Schedule schedule_entity = getScheduleEntity(id);

        // 요청 id에 해당하는 값 알려주기
        return new ScheduleResponse(schedule_entity.getId(),
                schedule_entity.getTitle(), schedule_entity.getContent(), schedule_entity.getAuthor(),
                schedule_entity.getCreateAt(), schedule_entity.getUpdatedAt());
    }

    // < 전체 조회(R) > - 작성자명을 기준으로 등록된 일정 목록을 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponse> getAll(String author) {
        List<Schedule> schedules;

        // URL에서 작성자명 언급 유무에 따라 조회범위 설정
        if (author == null || author.isBlank()) {
            schedules = schedule_repository.findAll();
        } else {
            schedules = schedule_repository.findAllByAuthor(author);
        }

        // 수정일 기준 내림차순 정렬표 반환
        return schedules.stream()
                .sorted(Comparator.comparing(Schedule::getUpdatedAt).reversed())
                .map(schedule -> new ScheduleResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getAuthor(),
                        schedule.getCreateAt(),
                        schedule.getUpdatedAt()
                ))
                .toList();
    }


    // < 수정(U) >
    @Transactional
    public ScheduleResponse update(Long id, ScheduleRequest request) {
        validateUpdateRequest(request);

        Schedule schedule_entity = getScheduleEntity(id);
        validatePassword(request.getPassword(), schedule_entity.getPassword());

        // 요청 id에 해당하는 레코드의 일정제목, 작성자명 덮어쓰기
        schedule_entity.update(request.getTitle(), request.getAuthor());

        // 수정안 알려주기
        return new ScheduleResponse(schedule_entity.getId(),
                schedule_entity.getTitle(), schedule_entity.getContent(), schedule_entity.getAuthor(),
                schedule_entity.getCreateAt(), schedule_entity.getUpdatedAt());
    }


    // < 삭제(D) >
    @Transactional
    public void delete(Long id, ScheduleRequest request) {
        validatePasswordRequest(request);

        Schedule schedule_entity = getScheduleEntity(id);
        validatePassword(request.getPassword(), schedule_entity.getPassword());

        // 요청 id에 해당하는 레코드 삭제
        schedule_repository.delete(schedule_entity);
    }

    private Schedule getScheduleEntity(Long id) {
        return schedule_repository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("존재하지 않는 일정입니다."));
    }

    private void validateCreateRequest(ScheduleRequest request) {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new IllegalArgumentException("일정 제목은 필수입니다.");
        }
        if (request.getContent() == null || request.getContent().isBlank()) {
            throw new IllegalArgumentException("일정 내용은 필수입니다.");
        }
        if (request.getAuthor() == null || request.getAuthor().isBlank()) {
            throw new IllegalArgumentException("작성자명은 필수입니다.");
        }
        validatePasswordRequest(request);
    }

    private void validateUpdateRequest(ScheduleRequest request) {
        if (request.getTitle() == null || request.getTitle().isBlank()) {
            throw new IllegalArgumentException("수정할 일정 제목은 필수입니다.");
        }
        if (request.getAuthor() == null || request.getAuthor().isBlank()) {
            throw new IllegalArgumentException("수정할 작성자명은 필수입니다.");
        }
        validatePasswordRequest(request);
    }

    private void validatePasswordRequest(ScheduleRequest request) {
        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("비밀번호는 필수입니다.");
        }
    }

    private void validatePassword(String requestPassword, String savedPassword) {
        if (!requestPassword.equals(savedPassword)) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }
    }
}
