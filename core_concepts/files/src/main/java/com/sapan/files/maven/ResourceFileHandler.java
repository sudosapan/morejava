package com.sapan.files.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility class for performind different operations on files present in the resources folder for maven build.
 * Includes applications of {@link java.nio.file.Files} and {@link java.nio.file.Paths} too.
 */
public class ResourceFileHandler {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(ResourceFileHandler.class);

    public static File getFileFromResource(final String filename) {
        return new File(ResourceFileHandler.class.getClassLoader().getResource(filename).getFile());
    }

    public static List<String> fileAsString(final String fileName) {
        try (Stream<String> lines = Files.lines(Paths.get(getFileFromResource(fileName).toURI()))) {
            return lines.collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

}
