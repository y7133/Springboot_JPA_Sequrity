package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRespository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){

        this.dataSource=dataSource;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRespository());
    }

    @Bean
    public MemberRespository memberRespository(){
        //return new JdbcMemberRepository(dataSource);
        //인터페이스는 new가 안됨
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
