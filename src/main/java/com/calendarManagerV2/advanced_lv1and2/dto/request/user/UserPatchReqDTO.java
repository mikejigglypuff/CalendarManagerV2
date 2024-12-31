package com.calendarManagerV2.advanced_lv1and2.dto.request.user;

import com.calendarManagerV2.advanced_lv1and2.exception.ValidationFailedException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class UserPatchReqDTO {
    private final String username;
    @Schema(description = "선택 항목", nullable = true)
    private final String email;

    public UserPatchReqDTO(String username, String email) {
        this.username = username;
        this.email = email;
        validate();
    }

    // 값에 null이 들어올 수 있는 경우에 대한 Validation 구현
    private void validate() {
        if(username != null && username.length() > 10) throw new ValidationFailedException("이름은 10자 이하여야 합니다.");
        if(email != null && !validEmail()) throw new ValidationFailedException("올바른 이메일 형식이어야 합니다.");
    }

    private boolean validEmail() {
        return email.matches("^[a-zA-Z0-9._%+-]+@$[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
}
