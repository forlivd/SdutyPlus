package com.d205.sdutyplus.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ErrorCode Convention
 * - 도메인 별로 나누어 관리
 * - [주체_이유] 형태로 생성
 * - 코드는 도메인명 앞에서부터 1~2글자로 사용
 * - 메시지는 "~~다."로 마무리
 */

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // User
    USER_NOT_FOUND(400, "U001", "존재하지 않는 유저입니다."),

    // Task
    TASK_NOT_FOUND(400, "T001", "존재하지 않는 테스크입니다."),


    // Warn
    WARN_ALREADY_EXIST(400, "W001", "이미 신고한 유저입니다."),
    WARN_MYSELF_FAIL(400,"W002","자기 자신은 신고 할 수 없습니다."),

    ;

    private final int status;
    private final String code;
    private final String message;
}
