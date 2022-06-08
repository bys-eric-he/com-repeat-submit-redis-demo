package com.repeat.submit.redis.controller;

import com.repeat.submit.redis.annotation.RepeatSubmit;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repeatSubmit")
public class RepeatSubmitController {
    /**
     * 保存Param
     *
     * @param name
     * @return
     */
    @RepeatSubmit
    @PostMapping("/saveParam/{name}")
    public String saveParam(@PathVariable("name") String name) {
        return "保存Param成功";
    }

    /**
     * 保存Param
     *
     * @param name
     * @return
     */
    @RepeatSubmit
    @PostMapping("/saveBody")
    public String saveBody(@RequestBody List<String> name) {
        return "保存Body成功";
    }
}
