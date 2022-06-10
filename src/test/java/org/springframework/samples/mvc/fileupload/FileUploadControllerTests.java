package org.springframework.samples.mvc.fileupload;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
public class FileUploadControllerTests extends AbstractContextControllerTests {

	@Test
	public void readString() throws Exception {

		MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());

		webAppContextSetup(this.wac).build()
				.perform(fileUpload("/fileupload").file(file))
				.andExpect(model().attribute("message", "File 'orig' uploaded successfully"));
	}

}
