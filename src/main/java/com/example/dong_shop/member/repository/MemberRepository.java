package com.example.dong_shop.member.repository;

import com.example.dong_shop.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.management.MemoryNotificationInfo;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
}
