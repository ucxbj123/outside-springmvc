package com.qcby;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.qcby.DAO.Person;
import com.qcby.DAO.PersonClass;
import com.qcby.DAO.t1;
import org.apache.ibatis.session.SqlSession;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import until.SqlSessionUntil;

import test.mybatis.mapper.InsertMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/test")
public class PersonController {
//    @RequestMapping(value = {"/person","/test"},method = {RequestMethod.POST,RequestMethod.GET},params = {"username","params!=123456"})
    @GetMapping(value = {"/person","/test"})
    public String message(Model model){
        System.out.println("Person");
        Gson gson=new Gson();
        String t = gson.toJson(new Person(396012,"谢秉均"));
        model.addAttribute("msg",t);
        return "/html/suc.html";
    }

    /**
     * 获取Post上传的参数数据与body内的JSON数据：
     * a > 通过POJO，在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，请求参数就会为此属性赋值。
     * 表单，实际就是跟get方式显示上传的数据一样，只是不是body的数据，而且是隐式上传的
     * b > 使用@RequestBody获取请求体body的数据，@ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为相应报文的1响应体响应到浏览器
     * @param p1
     * @return
     * 以上各种例子综合体参数：@RequestBody String p1,@RequestParam(value = "id") String ids,String name,Person p2
     */
    @RequestMapping(value = {"/person2","/test2"},method = RequestMethod.POST)
    @ResponseBody
    public JsonObject message2(@RequestBody String p1,@RequestParam(value = "id") String ids,String name,Person p2){
        Gson gson=new Gson();
        Person p=gson.fromJson(p1,Person.class);
        System.out.println("Post提交body的数据:"+p.toString());
        System.out.println("Post提交参数以pojo获取的数据:"+p2.toString());
        System.out.println("Post提交参数以参数名相同的形参和@RequestParam映射关系获取上传数据:"+ids+" "+name);
        t1 t1=new t1(22,80);
        Person person1 = new Person(389432,"林俊",t1);
        t1 t2=new t1(23,60);
        Person person2 = new Person(396012,"谢秉均",t2);
        PersonClass personClass = new PersonClass();
        List<Person> people3 = new ArrayList<>();
        people3.add(person1);
        people3.add(person2);
        personClass.setPeople(people3);
        String t = gson.toJson(personClass);
        JsonObject jsonObject=gson.toJsonTree(personClass).getAsJsonObject();
        return jsonObject;
    }

    /**
     * 获取GET参数方式：
     * a > 通过HttpServletRequest的方法参数，HHttpServletRequest request;String s=request.getParameter("")
     * b > 在方法体的参数名设置与上传参数同名，当浏览器发生请求，匹配到请求映射时，在DispatcherServlet中就会将请求参数赋值给相应的形参
     *      String name,int id
     * c > 通过@RequestParam将请求参数与控制器的形参创建映射关系，de_name-->name，de_id-->id
     * @RequestParam(value = "de_name") String name,@RequestParam(value = "de_id") int id
     */
    @RequestMapping(value = {"/person3","/test3"},method = RequestMethod.GET)
    @ResponseBody
    public String message3(@RequestParam(value = "de_name") String name,@RequestParam(value = "de_id") int id,@RequestBody String ss){

        System.out.println("GET上传参数："+id+name);
        System.out.println("GET上传body请求体数据："+ss);
        System.out.println("Person");
        Gson gson=new Gson();
        t1 t1=new t1(22,80);
        Person person1 = new Person(389432,"林俊",t1);
        t1 t2=new t1(23,60);
        Person person2 = new Person(396012,"谢秉均",t2);
        PersonClass personClass = new PersonClass();
        List<Person> people3 = new ArrayList<>();
        people3.add(person1);
        people3.add(person2);
        personClass.setPeople(people3);
        String t = gson.toJson(personClass);
//        JsonObject jsonObject=gson.toJsonTree(personClass).getAsJsonObject();
//        return jsonObject;
        return t;
    }

    /**
     * RequestEntity封装请求报文，需要在控制器方法的形参中设置该类型的形参，可以通过gerHeaders()获取请求头信息，通过
     * getBody()获取请求体信息
     * @return
     */
    @PostMapping(value = {"/person4","/test4"})
    @ResponseBody
    public Object message4(RequestEntity<String> request){
        String p1=request.getBody();
        System.out.println("请求头数据类型："+request.getHeaders().getClass());
        String p2= String.valueOf(request.getHeaders());
        Gson gson=new Gson();
//        Person p=gson.fromJson(p1,Person.class);
        PersonClass p=JSON.parseObject(p1,PersonClass.class);
//        List<Person> p=JSON.parseArray(p1,Person.class);
        System.out.println("Post提交body的数据:"+p);
//        for (Person pp:p){
//            System.out.println("Post提交body的数据:"+pp.toString());
//        }
        String gsonstring=gson.toJson(p);
        String fastjsontring=JSON.toJSONString(p);
        System.out.println("fastjson将对象转换为string:"+gsonstring);
        System.out.println("gson将对象转换为string:"+fastjsontring);
        System.out.println("Post请求头信息"+p2);
        t1 t1=new t1(22,80);
        Person person1 = new Person(389432,"林俊",t1);
        t1 t2=new t1(23,60);
        Person person2 = new Person(396012,"谢秉均",t2);
        PersonClass personClass = new PersonClass();
        List<Person> people3 = new ArrayList<>();
        people3.add(person1);
        people3.add(person2);
        personClass.setPeople(people3);
        String t = gson.toJson(personClass);
        JsonObject jsonObject=gson.toJsonTree(personClass).getAsJsonObject();
        JSONObject jsonObject1=JSONObject.parseObject(t);
        return jsonObject1;
    }

    /**
     * 将获取的数据转换为对象并连接数据库插入数据
     */
    @PostMapping(value = {"/person5","/test5"})
    @ResponseBody
    public Object message5(@RequestBody String msg) throws IOException {
        //gson
        Gson gson=new Gson();
//        Person p=gson.fromJson(msg,Person.class);
//        System.out.println("Post提交body的数据:"+p);

        //fastjson
        //Person p2=JSONObject.parseObject(msg,Person.class);
        Person p2=JSON.parseObject(msg,Person.class);
        System.out.println("Post提交body的数据:"+p2);


        //回传数据
        t1 t1=new t1(22,80);
        Person person1 = new Person(389432,"林俊",t1);
        t1 t2=new t1(23,60);
        Person person2 = new Person(396012,"谢秉均",t2);
        PersonClass personClass = new PersonClass();
        List<Person> people3 = new ArrayList<>();
        people3.add(person1);
        people3.add(person2);
        personClass.setPeople(people3);
        String t = gson.toJson(personClass);
        JsonObject jsonObject=gson.toJsonTree(personClass).getAsJsonObject();

//        //连接数据库并插入
//        String resource = "mybatis-config.xml";
//        SqlSessionUntil sqlSessionUntil = new SqlSessionUntil(resource);
//        SqlSession sqlSession = sqlSessionUntil.getSqlSession();
//        InsertMapper insertMapper=sqlSession.getMapper(InsertMapper.class);
//        Map map= new HashMap<>();
//        map.put("id",p.getId());
//        map.put("name",p.getName());
//        insertMapper.insertPerson(map);
        //gson
        String tt = gson.toJson(person2);
        JsonObject jsonObject1=gson.toJsonTree(person2).getAsJsonObject();
        //fastjson
        //String tt1=JSON.toJSONString(person2);
        String tt1=JSONObject.toJSONString(person2);
        JSONObject jsonObject2=JSONObject.parseObject(tt1,JSONObject.class);
        return jsonObject1;
    }

    /**
     * 从前端获取json数据是数组形式，并返回数组json数据
     * [
     *     {"id":1234,"name":"李四","t":{"age":22,"heigh":80.0}},
     *     {"id":1234,"name":"王五","t":{"age":23,"heigh":70.0}}
     * ]
     */
    @PostMapping(value = {"/person6","/test6"})
    @ResponseBody
    public Object message6(@RequestBody String msg) throws IOException {
        //gson
        Gson gson=new Gson();
        List<Person> p=gson.fromJson(msg,new TypeToken<List<Person>>(){}.getType());
        System.out.println("类："+new TypeToken<List<Person>>(){}.getType());
        for(Person person:p){
            System.out.println("Post提交body的数据(gson):"+person);
        }

        //fastjson
//        List<Person> p2=JSONObject.parseArray(msg,Person.class);
//        for (Person person:p2){
//            System.out.println("Post提交body的数据:"+person);
//        }



        //回传数据
        t1 t1=new t1(22,80);
        Person person1 = new Person(389432,"林俊",t1);
        t1 t2=new t1(23,60);
        Person person2 = new Person(396012,"谢秉均",t2);
        List<Person> people3 = new ArrayList<>();
        people3.add(person1);
        people3.add(person2);
        //fastjson
//        String tt=JSON.toJSONString(people3);//将list对象转为字符串
//        System.out.println("tt:"+tt);
//        JSONArray jsonObject =JSON.parseArray(tt);
        //gson
        String t=gson.toJson(people3);
        /**
         * 数据转JsonArray对象进行回传:
         * 方法1:通过toJsonTree方法，参数是List<类>
         * JsonArray jsonObject1=gson.toJsonTree(people3,new TypeToken<List<Person>>(){}.getType()).getAsJsonArray();
         * or JsonArray jsonObject1=gson.toJsonTree(people3).getAsJsonArray();不带参数
         * 方法2：通过JsonParser().parse()，参数是json字符串
         * JsonArray jsonObject1=new JsonParser().parse(t).getAsJsonArray();
         * 方法3：
         * JsonElement element=gson.toJsonTree(people3,new TypeToken<List<Person>>(){}.getType());
         * JsonArray jsonObject1=element.getAsJsonArray();
         */
        JsonArray jsonObject1=gson.toJsonTree(people3).getAsJsonArray();

        return jsonObject1;
    }

}
