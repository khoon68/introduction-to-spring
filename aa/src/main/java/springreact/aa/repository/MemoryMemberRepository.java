package springreact.aa.repository;

import org.springframework.stereotype.Repository;
import springreact.aa.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> memberDB = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence++);
        memberDB.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberDB.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberDB.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberDB.values());
    }

    @Override
    public void clearDB() {
        memberDB.clear();
    }
}
