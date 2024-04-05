package springreact.aa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springreact.aa.repository.MemberRepository;
import springreact.aa.repository.MemoryMemberRepository;
import springreact.aa.service.MemberService;

@Configuration
public class MemberConfig {

    @Bean
    MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
