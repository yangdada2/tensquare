import com.tensquare.rabibtmq.RabbitMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author haoyang
 * @Classname MqTest
 * @Description 测试消息发送者
 * @Date 2020/4/15 0015 15:39
 * @Created by Administrator
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= RabbitMqApplication.class)
public class MqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","我是你杨大大的大爷!");
    }

    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("yangdadaExchange","", "分列模式走起");
    }

    @Test
    public void testSendTopic(){
        rabbitTemplate.convertAndSend("yangdadaTopicExchange","1.2.3", "主题模式走起");
    }
}
