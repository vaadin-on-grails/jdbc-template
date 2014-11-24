import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

beans = {

    jdbcTemplate(JdbcTemplate, ref('dataSource'))

    namedJdbcTemplate(NamedParameterJdbcTemplate, ref('dataSource'))
}