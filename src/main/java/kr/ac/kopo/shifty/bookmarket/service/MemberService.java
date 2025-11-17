package kr.ac.kopo.shifty.bookmarket.service;


import jakarta.transaction.Transactional;
import kr.ac.kopo.shifty.bookmarket.domain.Member;
import kr.ac.kopo.shifty.bookmarket.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {


    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    public Member getMemberById(String memberId){
        Member member = memberRepository.findByMemberId(memberId);
        System.out.println(member.getMemberId());
        return member;
    }

    public void deleteMember(String memberId){
        Member member = memberRepository.findByMemberId(memberId);
        memberRepository.deleteById(member.getNum());


    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByMemberId(member.getMemberId());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(memberId);
        if(member == null){
            throw new UsernameNotFoundException(memberId+"이/가 없는데여");
        }

        return User.builder()
                .username(member.getMemberId())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

}
