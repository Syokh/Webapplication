package education.spring.java.lesson.controllers;


import education.spring.java.lesson.check.CheckLogic;
import education.spring.java.lesson.model.ListRole;
import education.spring.java.lesson.model.User;
import education.spring.java.lesson.model.UserRole;
import education.spring.java.lesson.services.ServiceUser;
import education.spring.java.lesson.utils.PasswordHelper;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;


@Controller
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ControllerRegister {

    @Inject
    private ServiceUser serviceUser;

    @RequestMapping(value = "/adduser")
    public
    @ResponseBody
    String adduser(@RequestParam(value = "username") String username,
                   @RequestParam(value = "password") String password,
                   @RequestParam(value = "password2") String password2) {

        CheckLogic checkLogic = new CheckLogic();
        boolean checkName = checkLogic.checkUserName(username);
        boolean checkPass = checkLogic.checkPassword(password);

        if (username.equals("")) {
            return "Please enter the User Name";
        }
        if (!checkName){
            return "This User Name can not be";
        }

        try {
            User user = (User) serviceUser.loadUserByUsername(username);
            String userUsername = user.getUsername();
            if (userUsername.equals(username)){
                return "This User Name already exists";
            }
        }catch (UsernameNotFoundException e){
            e.printStackTrace();
        }

        if (password.equals("")) {
            return "Please enter the correct password";
        }
        if (!checkPass){
            return "This Password can not be";
        }
        if (!password.equals(password2)) {
            return "Please enter bous the correct password";
        }

        PasswordHelper passwordHelper = new PasswordHelper();
        String passwordEncode = passwordHelper.encode(password);

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncode);

        UserRole userRole = new UserRole();
        userRole.setListRole(ListRole.USER);

        Set<UserRole> userRoleSet = new HashSet<UserRole>();
        userRoleSet.add(userRole);

        newUser.setUserRoles(userRoleSet);

        serviceUser.save(newUser);
        return "OK";
    }

}
