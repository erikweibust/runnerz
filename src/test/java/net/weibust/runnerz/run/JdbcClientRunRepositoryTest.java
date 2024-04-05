package net.weibust.runnerz.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

@JdbcTest
public class JdbcClientRunRepositoryTest {

    @Autowired
    JdbcClientRunRepository repository;

    // copy / paste from github repo
}
