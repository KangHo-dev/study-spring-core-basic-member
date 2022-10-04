package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        //given  ( 무엇이 주어졌을 때 )
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when   ( 어떤식으로 했을 때 )
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then   ( 결과 )
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
