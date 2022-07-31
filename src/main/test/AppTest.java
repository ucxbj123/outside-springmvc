import com.google.gson.Gson;
import com.qcby.DAO.Person;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;

public class AppTest {

    @Test
    public void testuploaddata(){
        String url = "http://localhost:8080/springmvc/test/test2";

        Person t=new Person(396012,"谢秉均");
        Gson gson=new Gson();
        String json = gson.toJson(t);
        System.out.println("json:"+json);
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        StringEntity entity = new StringEntity(json, "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("text/json");
        httpPost.setEntity(entity);
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            //获取返回值
            HttpEntity entity1 = httpResponse.getEntity();
            String content= EntityUtils.toString(entity1,"utf8");
            System.out.println("结果返回"+content);
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
            System.out.println("错误抛出：");
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        String path = Test.class.getResource("/").toString();
        System.out.println("path = " + path);
    }
}
