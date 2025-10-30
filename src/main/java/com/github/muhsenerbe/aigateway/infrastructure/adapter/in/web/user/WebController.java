package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/login")
    public String login() {
        // Bu bir JSON endpoint'i değil.
        // Bu, "templates klasöründeki login.html dosyasını render et" demektir.
        return "login";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model, Authentication authentication) {

        String username = authentication.getName();

        model.addAttribute("username", username);

        return "dashboard";
    }

}
