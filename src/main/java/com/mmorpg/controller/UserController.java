package com.mmorpg.controller;

/**
 * author:ydx
 * create 2019\7\21 0021
 */
import javax.servlet.http.HttpServletRequest;


import com.mmorpg.pojo.User;
import com.mmorpg.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        return "ok";
    }

    @RequestMapping("/2")
    @ResponseBody
    public List returnList(){
        List list= new ArrayList<>();
        list.add(1);
        list.add(2);
        return list;
    }

    @RequestMapping("/json.action")
    @ResponseBody
    public User getJson(@RequestBody User user){
        System.out.println(user.toString());
        user.setEmail("212222");
        return user;
    }

}
