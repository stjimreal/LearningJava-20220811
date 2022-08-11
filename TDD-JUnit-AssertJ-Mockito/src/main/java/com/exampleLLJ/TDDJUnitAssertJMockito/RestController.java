package com.exampleLLJ.TDDJUnitAssertJMockito;

import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class RestController {
    @Resource
    private BandService bandService;
    @GetMapping("/right/number")
    public @ResponseBody String getRightNumber(){
        return "255";
    }

    @PostMapping("/bands")
    public @ResponseBody String addBand(@RequestBody MusicBand band){
        bandService.addBand(band);
        return "Ok!";
    }

    @GetMapping("/bands")
    public @ResponseBody Iterable<MusicBand> getBand(Long id){
        return bandService.getBand(id);
    }
}
