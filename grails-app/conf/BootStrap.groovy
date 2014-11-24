import com.vaadin.grails.Grails
import org.springframework.jdbc.core.JdbcTemplate

class BootStrap {

    def init = { servletContext ->

        JdbcTemplate jdbcTemplate = Grails.get(JdbcTemplate)
        jdbcTemplate.execute('CREATE TABLE User (id INTEGER, first_name VARCHAR(255))')
        jdbcTemplate.update("INSERT INTO User (id, first_name) VALUES (1, 'John')")
    }
    def destroy = {
    }
}
