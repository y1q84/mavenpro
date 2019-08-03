package com.mmorpg.controller;

/**
 * author:ydx
 * create 2019\7\21 0021
 */
import javax.servlet.http.HttpServletRequest;


import com.mmorpg.pojo.User;
import com.mmorpg.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }

    @RequestMapping("/1")
    public String getSomething(Model model){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        model.addAttribute("itemList",list);
        Map<Integer,String> map = new HashMap<>();
        map.put(10,"jame");
        map.put(20,"amy");
        map.put(30,"john");
        model.addAttribute("itemMap",map);
        logger.info("打印1{},还有{}","asdfsa",100000);
        logger.debug("打印2{},还有{}","asdfsa5",100000);
        logger.warn("打印3{},还有{}","asdfsa3",100000);
        logger.error("打印4{},还有{}","asdfsa2",100000);
        return "ok";
    }

    @RequestMapping("/2")
    @ResponseBody
    public List returnList(){
        List list= new ArrayList<>();
        list.add(1);
        list.add(2);
        logger.info("发送消息啦。。。。");
        logger.info("热部署生效了吗...");
        logger.info("sdfsf");
        logger.info("11111111111111111");
        logger.info("ertewr是的方法");
        return list;
    }

    // 由ok.jsp页面发送ajax请求来访问此方法
    @RequestMapping("/json.action")
    @ResponseBody
    public User getJson(@RequestBody User user){
        System.out.println(user.toString());
        user.setEmail("212222");
        return user;
    }

}
