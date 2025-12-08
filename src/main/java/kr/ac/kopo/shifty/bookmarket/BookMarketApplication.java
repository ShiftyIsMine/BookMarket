package kr.ac.kopo.shifty.bookmarket;

import kr.ac.kopo.shifty.bookmarket.domain.Member;
import kr.ac.kopo.shifty.bookmarket.domain.Role;
import kr.ac.kopo.shifty.bookmarket.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMarketApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(MemberService memberService) {
        return args -> {
            // 이미 있으면 아무 것도 안 함
            Member existing = null;
            try {
                existing = memberService.getMemberById("Admin");
            } catch (Exception e) {
                // getMemberById가 null 반환/예외 어느 쪽이든 처리
            }

            if (existing != null) {
                return;
            }

            Member member = new Member();
            member.setMemberId("Admin");
            member.setName("관리자");
            member.setPhone("");
            member.setEmail("");
            member.setAddress("");
            String password = new BCryptPasswordEncoder().encode("shifty");
            member.setPassword(password);
            member.setRole(Role.ADMIN);

            memberService.saveMember(member);
        };
    }


}
