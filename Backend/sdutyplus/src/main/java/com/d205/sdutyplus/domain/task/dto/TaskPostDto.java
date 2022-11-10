package com.d205.sdutyplus.domain.task.dto;

import com.d205.sdutyplus.domain.task.entity.Task;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class TaskPostDto {
    private String startTime;
    private String endTime;
    private String title;
    private List<String> contents = new LinkedList<>();

    public Task toEntity(){
        return Task.builder()
                .startTime(startTime)
                .endTime(endTime)
                .title(title)
                .build();
    }
}
