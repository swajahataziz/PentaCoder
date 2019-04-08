package com.averros.data.codemapper.readers;

import org.davidmoten.rx.jdbc.Database;
import reactor.core.publisher.Flux;

public class DatabaseReader {

    private Flux<String> data;

    public static void connectDb(String url, int maxPoolSize) {
        Database db = Database.from(url, maxPoolSize);
        db.connections();
    }
}
