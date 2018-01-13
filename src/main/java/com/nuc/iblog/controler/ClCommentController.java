package com.nuc.iblog.controler;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.ClCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tyranitarx on 2018/1/13.
 *
 * @Description :
 */
@Controller
@RequestMapping("cl")
public class ClCommentController {
    Logger log = LoggerFactory.getLogger(ClCommentController.class);
    @Autowired
    private ClCommentService clCommentService;
    private User user;
    @RequestMapping("/writeComment")
    public String writeComment(int aid, String comment, HttpServletRequest request){
        user=(User)request.getSession().getAttribute("User");
        log.info("用户"+user.getUsername()+"发表评论");
        clCommentService.InsertComment(user.getUid(),aid,comment);
        return "redirect:/cl/findArticle?aid="+aid;
    }
}
