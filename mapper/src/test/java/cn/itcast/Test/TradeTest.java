package cn.itcast.Test;

import cn.itcast.domain.Trade;
import cn.itcast.mapper.TradeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-mapper.xml")
public class TradeTest {
    @Autowired
    private TradeMapper mapper;

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = dateFormat.parse("2019-05-10");
        Date end = dateFormat.parse("2019-06-10");

        List<Trade> list = mapper.findByDate(begin, end, 123);
        list.forEach(System.out::println);
    }
}
