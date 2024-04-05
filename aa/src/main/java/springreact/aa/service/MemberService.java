package springreact.aa.service;

import org.springframework.stereotype.Service;
import springreact.aa.domain.Member;
import springreact.aa.repository.MemberRepository;
import springreact.aa.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("중복된 이름입니다.");
        });
    }
}
