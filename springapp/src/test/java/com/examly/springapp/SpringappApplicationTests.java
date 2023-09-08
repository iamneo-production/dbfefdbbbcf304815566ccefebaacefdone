package com.examly.springapp;

import com.examly.springapp.controller.ApiController;
import com.examly.springapp.model.ChildBean;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ApiController.class) // Specify the controller class to test
@AutoConfigureMockMvc
public class SpringappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ChildBean childBean; // Mock the child bean

	@Before
	public void setUp() {
		// You can set up mock behavior for the child bean here if necessary
	}

	@Test
	public void testGetMessageStatus() throws Exception {
		// Arrange: Mock the behavior of the childBean
		 // Adjust as needed
		// Replace the behavior of childBean.getMessage() with the expected message
		when(childBean.getMessage()).thenReturn("Hello");

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/demo/message")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test

	public void controllerfolder() {
		String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your
																				// directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void controllerfile() {
		String filePath = "src/main/java/com/examly/springapp/controller/ApiController.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/examly/springapp/model/ParentBean.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFilee() {
		String filePath = "src/main/java/com/examly/springapp/model/ChildBean.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}
}
