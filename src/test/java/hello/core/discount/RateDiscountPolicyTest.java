package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    AppConfig appConfig = new AppConfig();
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVip", Grade.VIP);

        //when
        int disCount = discountPolicy.discount(member, 10000);

        //then
        assertThat(disCount).isEqualTo(1000); //Assertions static 사용하면 alt + enter 사용하면 된다.
    }

    @Test
    @DisplayName("VIP회원이 아니면 할인 적용이 안된다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberVip", Grade.BASIC);

        //when
        int disCount = discountPolicy.discount(member, 10000);

        //then
        assertThat(disCount).isEqualTo(0);
    }

}