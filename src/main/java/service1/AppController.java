package service1;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AppController {

  private final RestTemplate rest;

  @GetMapping("/")
  public Greeting handle(@RequestParam("name") String name) {
    Greeting result = rest.getForObject("http://localhost:8082?name=Jim", Greeting.class);
    log.info("got: {}", result);
    Greeting greeting = new Greeting(result.getMessage().toUpperCase());
    log.info("modified: {}", greeting);
    return greeting;
  }

}
