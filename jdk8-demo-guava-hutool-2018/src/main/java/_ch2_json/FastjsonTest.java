package _ch2_json;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.classic.PersonEntity;
import entity.school.StudentEntity;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FastjsonTest {

    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    private List<PersonEntity> listOfPersonEntities = new ArrayList<>();

    @Before
    public void setUp() {
        listOfPersonEntities.add(new PersonEntity(15, "John Doe", new Date()));
        listOfPersonEntities.add(new PersonEntity(20, "Janette Doe", new Date()));
    }

    @Test
    public void whenJavaList_thanConvertToJsonCorrect() {
//        Console.log(new Person(15, "John Doe", new Date()));
        String jsonOutput = JSON.toJSONString(listOfPersonEntities);

        // 只会打印空的  [{},{}]
        Console.log(jsonOutput);
        System.out.println(jsonOutput);
    }

//    @Test
//    public void copyDemo() {
//        UserVo userVo = new UserVo();
//        userVo.setName("张伟").setAge(22);
//
//        User user = new User();
//        user.setName("陈磊").setAge(null).setPassword("123456");
//
//        BeanCopyUtils.copyNotNullBean(user, userVo);
//        Console.log(userVo);
//        // --> UserVo(name=陈磊, age=22)
//    }


    @Test
    @Deprecated
    public void readJSON() {
        List listOfPersons = new ArrayList<PersonEntity>();
        listOfPersons.add(new PersonEntity(15, "John Doe", new Date()));
        listOfPersons.add(new PersonEntity(20, "Janette Doe", new Date()));

        String jsonOutput = JSON.toJSONString(listOfPersons);
//        Console.log(JSON.toJSON(new Person(15, "John Doe", new Date())));
        Console.log(jsonOutput); // --> [{},{}]


        jsonOutput = JSON.toJSONString(listOfPersons.toString());
        Console.log(jsonOutput);

//        Object parse = JSONArray.parse(jsonOutput);
//        Console.log(parse);
    }

    @Test
    public void parseJSON() {
        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        Console.log("age:{} name:{}", jsonObject.getString("studentAge"), jsonObject.getString("studentName"));

        // 给出具体
        StudentEntity studentEntity = JSON.parseObject(JSON_OBJ_STR, StudentEntity.class);
        Console.log("age:{} name:{}", studentEntity.getStudentAge(), studentEntity.getStudentName());
    }

    @Test
    public void parseJSONArr() {
        JSONArray objects = JSON.parseArray(JSON_ARRAY_STR);

        for (Object object : objects) {
            JSONObject jsonObject = (JSONObject) object;
            Console.log(jsonObject.getString("studentAge"));
            Console.log(jsonObject.getString("studentName"));
        }
    }

    @Test
    public void parseComplexJSON() {
        JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
//        String teacherName = jsonObject.getString("teacherName");
//        Integer teacherAge = jsonObject.getInteger("teacherAge");
//        JSONObject course = jsonObject.getJSONObject("course");

        JSONArray students = jsonObject.getJSONArray("students");
        Console.log(students);

    }


    @Test
    public void test() {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        String s = JSON.toJSONStringWithDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
        Console.log(s);// --> "2019-09-03 13:41:01.329"

        Console.log(JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat)); // --> "2019-09-03"
    }

    @Test
    public void demoxx() {

    }

}
