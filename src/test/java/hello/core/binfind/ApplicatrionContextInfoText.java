package hello.core.binfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicatrionContextInfoText {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    public void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // ac.getBean = 빈 이름으로 빈 객체 조회한다.
            System.out.println("name : " + beanDefinitionName + ", object : " + bean);
        } //iter 시 배열 자동 for문 만듬
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean(){
        // ac.getBeanDefinitionNames(); = 스프링에 등록된 모든 빈 이름을 조회.
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // Role ROLE_APPLICATION = 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE = 스프링 내부에서 사용하는 빈
            if(beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name : " + beanDefinitionName + ", object : " + bean);
            }
        } //iter 시 배열 자동 for문 만듬
    }
}
