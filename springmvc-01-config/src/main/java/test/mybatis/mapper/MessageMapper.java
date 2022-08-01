package test.mybatis.mapper;

import com.qcby.DAO.Message;

public interface MessageMapper {
    /**
     * 以类为参数往数据库插入数据
     */
    int InsertMessage(Message message);
}
