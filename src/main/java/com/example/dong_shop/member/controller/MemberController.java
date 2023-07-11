package com.example.dong_shop.member.controller;

import com.example.dong_shop.member.dto.MemberFormDto;
import com.example.dong_shop.member.entity.Member;
import com.example.dong_shop.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String memberForm(MemberFormDto memberFormDto) {
        memberService.saveMember(Member.createMember(memberFormDto, passwordEncoder));
        log.info("POST NEW");
        return "redirect:/";
    }

}
