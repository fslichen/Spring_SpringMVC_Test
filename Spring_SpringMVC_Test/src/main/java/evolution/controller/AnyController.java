package evolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {
	@GetMapping("/get")
	public void get() {
		System.out.println("Hello World");
	}
}
