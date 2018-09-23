package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.LoginDto;
import ftn.uns.ac.rs.domain.dto.UserDto;
import ftn.uns.ac.rs.domain.entity.User;
import ftn.uns.ac.rs.exeptions.MyNotFoundExeption;
import ftn.uns.ac.rs.exeptions.MyValidationFormException;
import ftn.uns.ac.rs.service.KieSessionService;
import ftn.uns.ac.rs.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private KieSessionService kieSessionService;


    private ModelMapper mapper = new ModelMapper();

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        User user = mapper.map(userDto, User.class);
        if (bindingResult.hasErrors()) {
            throw new MyValidationFormException("Parameters aren't valid");
        }
        return ResponseEntity.ok(mapper.map(userService.addUser(user), UserDto.class));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto userDto) {
        User user = userService.login(userDto.getUsername(), userDto.getPassword());
        if (user != null) {
            kieSessionService.createNewInstance(user.getUsername());
            return new ResponseEntity<>(mapper.map(user, UserDto.class), HttpStatus.ACCEPTED);
        } else
            throw new MyNotFoundExeption("Wrong username or password,try again");

    }

    @PostMapping(value = "/logout/{userId}")
    public ResponseEntity<?> logout(@PathVariable Long userId) {
        userService.logout();
        return ResponseEntity.accepted().body("");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("");

    }
}
