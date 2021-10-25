package bymin4.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	ResourcePatternResolver resourcePatternResolver;
	@Value("classpath:configs/*")
	private Resource[] files;

	@Value("classpath:configs/test-prod.yml")
	private Resource file;

	@GetMapping("hi")
	public String hello() {
		for (Resource resource : files) {
			System.out.println(resource.toString());
		}

		System.out.println("hello");
		return "hello";
	}
}
