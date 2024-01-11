package com.ex.de.domain.member;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(String username) {
        Optional<Member> member = this.memberRepository.findByusername(username);
        if (member.isEmpty()) {
            throw new RuntimeException("존재하지 않는 사용자입니다.");
        }
        return member.get();
    }

    public Member getMember(Long id) {
        Optional<Member> member = this.memberRepository.findById(id);
        if (member.isEmpty()) {
            throw new RuntimeException("존재하지 않는 사용자입니다.");
        }
        return member.get();
    }



    public void create(String username, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        this.memberRepository.save(member);
    }

}
