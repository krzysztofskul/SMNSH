package pl.krzysztofskul.Logo;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app-data/logo")
public class LogoController {

    @GetMapping(value = "/logo-ipsum")
    public ResponseEntity<byte[]> logoIpsum() throws IOException {

    	ClassPathResource imageFile = new ClassPathResource("img\\logos\\logo-ipsum.jpg");
    	//imageFile = new ClassPathResource(null);

    	byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());

    	return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    
	
}
