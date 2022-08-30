package com.example.tasktracker.enums;

import io.swagger.annotations.ApiModel;

//This is enum class for task's status values
@ApiModel
public enum TaskStatus {
    ToDo,
    InProgress,
    Done
}
