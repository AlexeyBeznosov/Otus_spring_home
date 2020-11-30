import Domain.Question;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ServiceImpl service = context.getBean(ServiceImpl.class);
        List<Question> list = service.getAllQuestions();
        list.forEach(p -> System.out.println(p.getQuestion()));
    }
}
