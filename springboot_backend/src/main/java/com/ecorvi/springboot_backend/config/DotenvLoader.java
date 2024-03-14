package com.ecorvi.springboot_backend.config;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvLoader {
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static Dotenv getDotenv() {
        return dotenv;
    }
}