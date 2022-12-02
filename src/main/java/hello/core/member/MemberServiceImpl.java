package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberService2")
public class MemberServiceImpl implements MemberService{

    /**
     * MemberServiceImpl 이 추상화와 구현체 까지 의존해 있다.
     *  => DIP위반
     *  https://devlog.joonas.io/design-pattern/solid-priciple/5-dip
     *  => OCP도 지켜지지 않는 상황.
     *  https://ko.wikipedia.org/wiki/%EA%B0%9C%EB%B0%A9-%ED%8F%90%EC%87%84_%EC%9B%90%EC%B9%99#%EC%B6%94%EC%83%81%ED%99%94%EB%A5%BC_%ED%86%B5%ED%95%9C_%EA%B0%9C%EB%B0%A9-%ED%8F%90%EC%87%84_%EC%9B%90%EC%B9%99
     *
     *  private final MemberRepository memberRepository = new MemberRepositoryImpl();
     */

    /**
     * 관심사의 분리
     * 추상화에만 의존하게 된다. (DIP를 지켜지게 된다.)
     * -> 생성자 주입.
     */
    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
