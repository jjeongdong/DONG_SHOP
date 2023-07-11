package com.example.dong_shop.member.service;

import com.example.dong_shop.member.entity.Member;
import com.example.dong_shop.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member) {
        validateDuplicate(member);
        return memberRepository.save(member);
    }

    private void validateDuplicate(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());

        if (findMember != null) {
            throw new IllegalStateException("이미 등록된 사용자 입니다.");
        }
    }
}
