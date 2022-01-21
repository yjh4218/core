package hello.core.binfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    public void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService" + memberService);
//        System.out.println("memberService.class" + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    public void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
//        System.out.println("memberService" + memberService);
//        System.out.println("memberService.class" + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    public void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
//        System.out.println("memberService" + memberService);
//        System.out.println("memberService.class" + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    public void findBeanByNameX(){
//        MemberService xxxx = ac.getBean("xxxx",MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx",MemberService.class));
        //  ac.getBean("xxxx",MemberService.class) 실행 시 예외가 발생하여 오류 발생해야 함.
//        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
