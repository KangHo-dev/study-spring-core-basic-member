package hello.core.order;


import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //final (필수값) 을 생성자로 만들어 준다 -> RequiredArgsConstructor
    //lombok 제공 , 의존관계 주입이 매우 쉬워진다.  (ctrl+f12 로 확인 가능)
    // compile 시점에 생성자 코드를 자동으로 생성

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //Qualifier
    //Primary
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
