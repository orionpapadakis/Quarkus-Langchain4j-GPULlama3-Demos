package org.example._1_summarization_service;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    SummarizationService ai;

    @Override
    public int run(String... args) throws Exception {

        System.out.println("Summarization Service Application");
        System.out.println("=================================");

        var article = Files.readString(
                Paths.get(Main.class.getClassLoader().getResource("SampleTextToSummarize.txt").toURI())
        );

        System.out.println("Original Article:");
        System.out.println("=================");
        System.out.println(article);

        //var article = Files.readString(new File("resources/SampleTextToSummarize.txt").toPath());
        System.out.println(ai.summarize(article));
        return 0;

    }

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
}