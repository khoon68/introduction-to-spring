package springreact.aa.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springreact.aa.domain.Member;
import springreact.aa.repository.MemberRepository;
import springreact.aa.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberRepository memberRepository;
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearDB();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("Tom");

        Long result = memberService.join(member);
        Assertions.assertThat(result).isEqualTo(member.getId());
    }

    @Test
    void joinError() {
        Member member1 = new Member();
        member1.setName("Tom");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("Tom");

        Assertions.assertThatThrownBy(() -> memberService.join(member2)).isInstanceOf(IllegalStateException.class);
    }

}