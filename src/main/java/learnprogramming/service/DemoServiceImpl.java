package learnprogramming.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class DemoServiceImpl implements DemoService{

    @Override
    public String getHelloMsg(String user) {
        return "Ahoj " + user;
    }

    @Override
    public String getWelcomeMsg() {
        return "Pozdrowionka z przed-wakacji";
    }
}
