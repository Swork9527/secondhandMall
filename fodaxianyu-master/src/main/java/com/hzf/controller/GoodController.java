package com.hzf.controller;

import com.hzf.entity.Good;
import com.hzf.entity.GoodPicture;
import com.hzf.entity.Pictures;
import com.hzf.entity.User;
import com.hzf.service.GoodService;
import com.hzf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;
    //定义一页商品的个数
    public static final int PAGE_SIZE = 8;

//    查找所有的商品信息(没有实际作用，只是在开发中用来参考和测试)
    @ResponseBody
    @GetMapping("/queryAll")
    public ModelAndView queryAll(
            @RequestParam(value="pageNo",required=false,defaultValue="1")int pageNo)
    {
        ModelAndView mv =new ModelAndView();
//        PageHelper.startPage(pageNo,PAGE_SIZE);
        List<Good> list = goodService.findAll();


//        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("goodList",list);
//        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("index");
        for (Good good:list
             ) {
            System.out.println(good);
        }
        return mv;
    }

//    查找所有的商品的信息以及一张图片
    @ResponseBody
    @GetMapping("/queryAllGoodPicture")
    public ModelAndView queryAllGoodPicture(
            @RequestParam(value="pageNo",required=false,defaultValue="1")int pageNo)
    {
        ModelAndView mv =new ModelAndView();
//        PageHelper.startPage(pageNo,PAGE_SIZE);
        List<GoodPicture> list = goodService.findAllGoodPicture();


//        PageInfo pageInfo = new PageInfo<>(list);
        mv.addObject("goodPictureList",list);
//        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("index");
        for (GoodPicture goodPicture:list
                ) {
            System.out.println(goodPicture);
        }
        return mv;
    }

//    根据用户点击输入的id查找商品，以及相关的用户，图片信息
    @RequestMapping(value="/showGoodDetail/{goodid}",method=RequestMethod.GET)
    public ModelAndView showGoodDetail(@PathVariable Integer goodid){
        System.out.println(goodid);
//    通过商品id获取商品信息
        Good good = goodService.findGoodById(goodid);
        int uid = good.getUserid();
        System.out.println(uid);
//     通过商品的用户id查找用户的详细信息
        User user = userService.findUserById(uid);
//    通过商品的id获取图片信息
        List<Pictures> list= goodService.findPictureById(goodid);
        ModelAndView mv =new ModelAndView();
        mv.addObject("good", good);
        mv.addObject("user", user);
        mv.addObject("pictures", list);
        mv.setViewName("GoodDetail");
        System.out.println(good);
        System.out.println(user);
        for (Pictures pic:list
             ) {
            System.out.println(pic);
        }
        return mv;
    }

    @RequestMapping("/saveGood")
    public ModelAndView saveGood(HttpServletRequest request, Good good2, Pictures ima, MultipartFile pic){
        ModelAndView modelAndView = new ModelAndView();

        User cur_user = (User)request.getSession().getAttribute("user");
        int uid=cur_user.getUid();
        good2.setUserid(uid);
        good2.setStatus(0);
        System.out.print(good2);
        goodService.saveGood(good2);


       // String path=request.getSession().getServletContext().getRealPath("/uploads/");

        String path = System.getProperty("user.dir");
        String picturePath = path + "\\src\\main\\resources\\static\\goodPicture";
        File file=new File(picturePath);
        if (!file.exists()){
            file.mkdir();
        }

        String picname=pic.getOriginalFilename();
       // picname = picname.substring(picname.lastIndexOf("\\")+1);
        String uuid= UUID.randomUUID().toString().replace("-","");
        picname=uuid+"_"+picname;
        System.out.print(picname+"---------");
        System.out.print(picturePath);
        try {
            pic.transferTo(new File(picturePath,picname));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Pictures pictures=new Pictures();

        int gid=goodService.findLastGood();
        System.out.println("-------------------------");
        System.out.println(gid);
        pictures.setGoodid(gid);
        pictures.setPictureurl(picname);
        System.out.println(pictures);
        goodService.savePic(pictures);

        modelAndView.addObject("good2",good2);
        modelAndView.addObject("pictures",pictures);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @ResponseBody
    @GetMapping("/path")
    public  String Path(){
        String path = System.getProperty("user.dir");
//        String path = session.getServletContext().getRealPath("images");
        System.out.println("打印图片存储位置   打印图片存储位置   打印图片存储位置");
        System.out.println(path);
        String picturePath = path + "\\src\\main\\resources\\static\\goodPicture";
        System.out.println("打印图片存储位置   打印图片存储位置   打印图片存储位置");
        System.out.println(picturePath);
        return null;
    }
}
