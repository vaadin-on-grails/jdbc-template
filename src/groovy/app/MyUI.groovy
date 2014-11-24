package app

import com.vaadin.grails.Grails
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout()

        // Jdbc example
        JdbcTemplate jdbcTemplate = Grails.get(JdbcTemplate)

        Map userFromDb = jdbcTemplate.queryForMap("SELECT * FROM User WHERE id=?", 1)

        String firstName = userFromDb.get('first_name')
        layout.addComponent(new Label(firstName))

        // Named Jdbc example
        NamedParameterJdbcTemplate namedJdbcTemplate = Grails.get(NamedParameterJdbcTemplate)

        Map params = [id: 1]

        List<Map> usersX = namedJdbcTemplate.queryForList("SELECT * FROM User WHERE id=:id", params)

        usersX.each {
            String first_name = it.get('first_name')
            layout.addComponent(new Label(first_name))
        }

        setContent(layout)
    }
}
