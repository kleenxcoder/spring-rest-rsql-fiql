package at.stritzingerit.demo.springrestrsql.controller;

import at.stritzingerit.demo.springrestrsql.entity.User;
import at.stritzingerit.demo.springrestrsql.repository.UserRepository;
import at.stritzingerit.demo.springrestrsql.rsql.CustomRsqlVisitor;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/")
    Iterable<User> all() {
        return repository.findAll();
    }

    @GetMapping("/search")
    List<User> search(@RequestParam(value = "search") String search) {
        Node rootNode = new RSQLParser().parse(search);
        Specification<User> spec = rootNode.accept(new CustomRsqlVisitor<>());
        return repository.findAll(spec);
    }

    @GetMapping("/{id}")
    Optional<User> one(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping("/")
    User create(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    User update(@RequestBody User user, @PathVariable Integer id) {
        return repository.save(user); //check if exists first ...
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

}
