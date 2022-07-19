package com.qcby;

import com.qcby.DAO.Message;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.mybatis.mapper.MessageMapper;
import until.SqlSessionUntil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

@RestController
@RequestMapping(value = "msg")
public class MessageController {
    @PostMapping(value = "test1")
    public Object InsertMessage(Message message) throws IOException {
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter simple= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datetime=date.format(simple);
        message.setDatetime(datetime);
        String states="失败";
        SqlSessionUntil sqlSessionUntil=new SqlSessionUntil("mybatis-config.xml");
        SqlSession sqlSession= sqlSessionUntil.getSqlSession();
        try {
            MessageMapper mapper=sqlSession.getMapper(MessageMapper.class);
            int i=mapper.InsertMessage(message);
            states="成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result："+states);
        return states;
    }

}
