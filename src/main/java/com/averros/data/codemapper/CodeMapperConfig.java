package com.averros.data.codemapper;

import com.averros.data.codemapper.model.Row;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CodeMapperConfig {
    @Bean
    public Row getRow() {
        return new Row();
    }

}
