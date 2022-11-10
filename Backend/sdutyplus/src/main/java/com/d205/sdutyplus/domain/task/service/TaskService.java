package com.d205.sdutyplus.domain.task.service;


import com.d205.sdutyplus.domain.task.dto.ReportResponseDto;
import com.d205.sdutyplus.domain.task.dto.TaskDto;
import com.d205.sdutyplus.domain.task.dto.TaskResponseDto;
import com.d205.sdutyplus.domain.task.dto.TaskUpdateDto;
import com.d205.sdutyplus.domain.task.entity.Task;
import com.d205.sdutyplus.domain.task.repository.SubTaskRepository;
import com.d205.sdutyplus.domain.task.repository.TaskRepository;
import com.d205.sdutyplus.domain.task.repository.querydsl.TaskRepositoryQuerydsl;
import com.d205.sdutyplus.global.error.exception.EntityNotFoundException;
import com.d205.sdutyplus.util.TimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static com.d205.sdutyplus.global.error.ErrorCode.TASK_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TaskService{
    private final TaskRepository taskRepository;
    private final SubTaskRepository subTaskRepository;
    private final TaskRepositoryQuerydsl taskRepositoryQuerydsl;

    @Transactional
    public Task createTask(Long userSeq, TaskDto taskRequestDto){
        Task task = taskRequestDto.toEntity();
        task.setOwnerSeq(userSeq);
        return taskRepository.save(task);
    }

    public ReportResponseDto getDailyReport(Long userSeq, String date){
        LocalDateTime startTime = TimeFormatter.StringToLocalDateTime(date+" 00:00:00");
        LocalDateTime endTime = TimeFormatter.StringToLocalDateTime(date+" 23:59:59");
//        List<Task> tasks = taskRepository.findAllByStartTimeBetween(startTime, endTime);
        List<TaskResponseDto> taskResponseDtos = taskRepositoryQuerydsl.findTaskByStartTime(userSeq, startTime, endTime);

        ReportResponseDto reportResponseDto = new ReportResponseDto(taskResponseDtos);

        return reportResponseDto;
    }

    public TaskResponseDto getTaskDetail(Long taskSeq){
        return taskRepositoryQuerydsl.findTaskBySeq(taskSeq)
                .orElseThrow(()->new EntityNotFoundException(TASK_NOT_FOUND));
    }

    @Transactional
    public void updateTask(Long taskSeq, TaskUpdateDto taskUpdateDto){
        Task task = getTask(taskSeq);
        Task updatedTask = taskUpdateDto.toEntity();
        task.setStartTime(updatedTask.getStartTime());
        task.setEndTime(updatedTask.getEndTime());
        task.setDurationTime(updatedTask.getDurationTime());
        task.setContent(updatedTask.getContent());
    }

    @Transactional
    public void deleteTask(Long taskSeq){
        subTaskRepository.deleteByTaskSeq(taskSeq);
        taskRepository.deleteById(taskSeq);
    }

    public String getReportTotalTime(Long userSeq, String date){
        LocalDateTime startTime = TimeFormatter.StringToLocalDateTime(date+" 00:00:00");
        LocalDateTime endTime = TimeFormatter.StringToLocalDateTime(date+" 23:59:59");
        Integer duration = taskRepositoryQuerydsl.getReportTotalTime(userSeq, startTime, endTime);
        return TimeFormatter.msToTime(duration);
    }

    //get & set => private
    private Task getTask(Long taskSeq){
        return taskRepository.findById(taskSeq)
                .orElseThrow(()->new EntityNotFoundException(TASK_NOT_FOUND));
    }

}