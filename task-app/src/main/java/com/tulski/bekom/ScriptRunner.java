package com.tulski.bekom;

import org.springframework.stereotype.Component;

@Component
class ScriptRunner {

    String run(String shellScript) {
        var processBuilder = new ProcessBuilder("bash", "-c", shellScript);
        try {
            var process = processBuilder.start();
            var inputStream = process.getInputStream();
            var bytes = inputStream.readAllBytes();
            return new String(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
