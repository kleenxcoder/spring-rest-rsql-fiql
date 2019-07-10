package at.stritzingerit.demo.springrestrsql.controller;

import at.stritzingerit.demo.springrestrsql.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class UserControllerRSQLIntegrationTest {

    @Autowired
    UserController controller;

    @Test
    public void searchEqual() {
        List<User> users = controller.search("id==1");
        assertTrue("user not found", users.size() == 1);
        assertTrue("user id incorrect", users.get(0).getId() == 1);
    }

    @Test
    public void searchNotEqual() {
        List<User> users = controller.search("firstName!=Peter");
        assertTrue("user not found", users.size() == 11);
    }

    @Test
    public void searchGreaterThan() {
        List<User> users = controller.search("id=gt=1");
        assertTrue("user not found", users.size() == 11);
    }

    @Test
    public void searchGreaterOrEqualTo() {
        List<User> users = controller.search("id=ge=1");
        assertTrue("user not found", users.size() == 12);
    }

    @Test
    public void searchLessThan() {
        List<User> users = controller.search("id=lt=2");
        assertTrue("user not found", users.size() == 1);
    }

    @Test
    public void searchLessOrEqualTo() {
        List<User> users = controller.search("id=le=2");
        assertTrue("user not found", users.size() == 1);
    }

    @Test
    public void searchIn() {
        List<User> users = controller.search("firstName=in=(Peter,Hannes)");
        assertTrue("user not found", users.size() == 2);
    }

    @Test
    public void searchOut() {
        List<User> users = controller.search("firstName=out=(Peter,Hannes)");
        assertTrue("user not found", users.size() == 10);
    }


}
