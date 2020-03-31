package user.auth.sample

import groovy.sql.Sql
import org.springframework.jdbc.core.JdbcTemplate

import javax.sql.DataSource

class RolesRepository {

    private DataSource dataSource

    private JdbcTemplate jdbcTemplate

    private Sql sql

    DataSource getDataSource(){
        return this.dataSource
    }

    void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource
    }

    JdbcTemplate getJdbcTemplate() {
        if (this.jdbcTemplate == null) this.jdbcTemplate = new JdbcTemplate(this.getDataSource())
        return this.jdbcTemplate
    }

    Sql getSql() {
        if (this.sql == null) this.sql = new Sql(this.getDataSource())
        return this.sql
    }
}
