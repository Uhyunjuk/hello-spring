package hello.hello_springboot;

import hello.hello_springboot.aop.TimeTraceAop;
import hello.hello_springboot.repository.JpaMemberRepository;
import hello.hello_springboot.repository.MemberRepository;
import hello.hello_springboot.repository.MemoryMemberRepository;
import hello.hello_springboot.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /**
     * JPA
     */
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    // Spring Data JPA
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * JPA
     */
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

    // Spring Data JPA
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JpaMemberRepository(em);
//    }

}
