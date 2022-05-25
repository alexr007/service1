package service1;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class AppController {

  private final MessageRepository repo;

  @GetMapping("/")
  public void write(@RequestParam(name = "name") String contents) {
    Message message = new Message();
    message.setContents(contents);
    repo.save(message);
  }
}
