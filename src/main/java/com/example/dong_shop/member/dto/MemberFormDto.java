package com.example.dong_shop.member.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberFormDto {
    @NotBlank(message = "이름은 필수 항목 입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 항목 입니다.")
    @Email(message = "이메일 형식으로 입력하세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 항목 입니다.")
    @Length(min = 4, max = 12, message = "최소 4자, 최대 12자를 입력하세요.")
    private String password;

    @NotBlank(message = "주소는 필수 항목 입니다.")
    private String address;
}
