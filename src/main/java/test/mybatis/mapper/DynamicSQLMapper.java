package test.mybatis.mapper;

import com.qcby.DAO.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    /**
     * 通过where，if标签进行条件判断
     * @param company
     * @return
     */
    List<Company> getCompanyBywhere(Company company);

    /**
     * select * from com where country in ('China','Taiwan') order by marketcap desc limit 0,10;
     * @return
     */
    List<Company> getCompanyByforeach(@Param("countrys") String[] countrys);
}
