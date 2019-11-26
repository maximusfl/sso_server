package by.artezio.role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addrole")
public class AddRoleController {

    @GetMapping
    public String showAddRolePage(){
        return "addRolePage";
    }
}
