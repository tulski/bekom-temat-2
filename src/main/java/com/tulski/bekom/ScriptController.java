package com.tulski.bekom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/script")
@RequiredArgsConstructor
class ScriptController {

    private final ScriptRunner scriptRunner;

    @GetMapping("/run")
    public String runScript(@RequestBody String shellScript) {
        return scriptRunner.run(shellScript);
    }

}
