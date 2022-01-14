package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너는 ApplicationContext으로 시작한다.(ApplicationContext를 스프링 컨테이너라고 한다.)
        // ApplicationContext는 인터페이스다.
        // @Configuration 을 사용하기 위함.
        // AppConfig에 있는 정보들을 스프링 컨테이너에 넣어서 관리함.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Appconfig에서 찾아오는 이름과 파일을 가져옴.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP); // id에 L을 붙이는 이유는 Long 타입이라서 붙임
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member  = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
