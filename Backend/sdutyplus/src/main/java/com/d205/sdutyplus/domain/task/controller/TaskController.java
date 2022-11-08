package com.d205.sdutyplus.domain.task.controller;

import com.d205.sdutyplus.domain.task.dto.ReportResponseDto;
import com.d205.sdutyplus.domain.task.dto.TaskDto;
import com.d205.sdutyplus.domain.task.dto.TaskUpdateDto;
import com.d205.sdutyplus.domain.task.entity.Task;
import com.d205.sdutyplus.domain.task.service.TaskService;
import com.d205.sdutyplus.global.response.ResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.d205.sdutyplus.global.response.ResponseCode.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @ApiOperation(value = "테스크 등록")
    @PostMapping("")
    public ResponseEntity<?> createTask(@RequestBody TaskDto taskRequestDto){
        Task registedTask = taskService.createTask(new Long(1), taskRequestDto);
        return ResponseEntity.ok().body(ResponseDto.of(CREATE_TASK_SUCCESS, registedTask));
    }

    @ApiOperation(value = "데일리 테스크 조회(리포트조회)")
    @GetMapping("/{date}")
    public ResponseEntity<?> getDailyTask(@PathVariable String date){
        ReportResponseDto reportResponseDto = taskService.getTaskByDate(new Long(1), date);
        return ResponseEntity.ok().body(ResponseDto.of(GET_DAILYTASK_SUCCESS, reportResponseDto));
    }


    @ApiOperation(value = "테스크 수정")
    @PutMapping("/{task_seq}")
    public ResponseEntity<?> updateTask(@PathVariable(value="task_seq") Long taskSeq, @RequestBody TaskUpdateDto taskUpdateDto){
        taskService.updateTask(taskSeq, taskUpdateDto);
        return ResponseEntity.ok().body(ResponseDto.of(UPDATE_TASK_SUCCESS));
    }

    @ApiOperation(value = "테스크 삭제")
    @DeleteMapping("/{task_seq}")
    public ResponseEntity<?> deleteTask(@PathVariable(value="task_seq") Long taskSeq){
        taskService.deleteTask(taskSeq);
        return ResponseEntity.ok().body(ResponseDto.of(DELETE_TASK_SUCCESS));
    }
}
