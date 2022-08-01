import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcby.DAO.Company;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import test.mybatis.mapper.DynamicSQLMapper;
import until.SqlSessionUntil;

import java.io.IOException;
import java.util.List;

public class DynamicSQLTest {

    @Test
    public void getCompanyBywhere() throws IOException {
        SqlSession sqlSession= new SqlSessionUntil("mybatis-config.xml").getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        //分页
        PageHelper.startPage(22,10);
        List<Company> companies=mapper.getCompanyBywhere(new Company(null,null,null,null,128.0,"United States"));
        for(Company c1:companies){
            System.out.println(c1);
        }
        //获取分页的信息，例如导航分页
        int navigatePages=5;
        PageInfo<Company> pageInfo=new PageInfo<>(companies,navigatePages);
        System.out.println("pageinfo:"+pageInfo);
    }

    @Test
    public void getgetCompanyByforeach() throws IOException {
        SqlSession sqlSession= new SqlSessionUntil("mybatis-config.xml").getSqlSession();
        DynamicSQLMapper mapper=sqlSession.getMapper(DynamicSQLMapper.class);
        String[] s=new String[]{"China","Taiwan"};
        List<Company> companies=mapper.getCompanyByforeach(s);
        for(Company c1:companies){
            System.out.println(c1);
        }
    }

}
