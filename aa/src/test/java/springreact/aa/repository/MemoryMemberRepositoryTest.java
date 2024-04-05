package springreact.aa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springreact.aa.domain.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository memberRepository = new MemoryMemberRepository();

    @Test
    void save() {
        Member member = new Member();
        member.setName("Tom");

        Assertions.assertThat(memberRepository.save(member).getName()).isEqualTo(member.getName());
    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setName("Tom");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("Jane");
        memberRepository.save(member2);

        Member result = memberRepository.findById(0L).get();

        Assertions.assertThat(result.getName()).isEqualTo(member1.getName());
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("Tom");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("Jane");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("Tom").get();

        Assertions.assertThat(result.getName()).isEqualTo(member1.getName());
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("Tom");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("Jane");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}