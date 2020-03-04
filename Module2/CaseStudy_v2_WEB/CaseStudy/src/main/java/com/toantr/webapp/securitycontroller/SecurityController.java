package com.toantr.webapp.securitycontroller;

import com.toantr.webapp.security.Authority;
import com.toantr.webapp.security.AuthorityType;
import com.toantr.webapp.security.User;
import com.toantr.webapp.security.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController
{
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/login")
    public String handleLoginRequest(){
        return "security/login";
    }
    @GetMapping("/login-failed")
    public String handleLoginFail(Model model){
        model.addAttribute("status","Incorrect username or password!");
        return "security/login";
    }
    @GetMapping("/logout-oke")
    public String handleLogoutOke(){ // deprecated function
        return "redirect:/";
    }
    @GetMapping("/logout")
    public void handleLogout(@ModelAttribute User currentUser){
        System.out.printf("User {%s} logged out",currentUser.getUsername());
        SecurityContextHolder.getContext().setAuthentication(null);
        currentUser=null;
    }
    @GetMapping("/register")
    public String handleRegisterRequest(Model model){
        model.addAttribute("user",new User());
        return "security/register";
    }
    @PostMapping("/user/new")
    public String handleSaveUser(User user, RedirectAttributes redirectAttributes){
        Authority authority=new Authority();
        authority.setAuthorityType(AuthorityType.ROLE_USER);
        Set<Authority> authorities=new HashSet<>();
        authorities.add(authority);
        user.setAuthorities(authorities);

        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10)));

        userRepo.save(user);
        redirectAttributes.addFlashAttribute("status","Register successfully!");
        return "redirect:/login";
    }
    @GetMapping("/admin")
    public String handleAdminSite(){
        return "security/admin";
    }
}
