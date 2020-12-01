package dk.dd.user.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepoImpl userRepo;
    private Object user;

    @GetMapping("/{id}")
    public User findUser(@PathVariable String id){
        return userRepo.get(id);
    }
    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return userRepo.create(user);
    }



}
