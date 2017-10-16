package ie.sanshou.aerobics.service;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ie.sanshou.aerobics.controller.UserController;
import ie.sanshou.aerobics.model.User;
import ie.sanshou.aerobics.service.UserService;
import lombok.extern.slf4j.XSlf4j;

@XSlf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserService_test {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	private User mockUser = User.builder().name("Tester").weight(65.0).height(170.0).age(31).gender(true).build();
	private String exampleUserJson = "{\"id\": \"null\" ,\"name\":\"Tester\",\"height\":\"170.0\",\"weight\":\"65.0\",\"age\":31,\"gender\":true,\"metabolic\":null }";
	private String expected = "{id:null,name:Tester,height:170.0,weight:65.0,age:31,gender:true,metabolic:null}";
	// {"id":null,"name":"Tester","height":170.0,"weight":65.0,"age":31,"gender":true,"metabolic":null}
	private String expectedArray = "[{id:null,name:Tester,height:170.0,weight:65.0,age:31,gender:true,metabolic:null}]";

	@Test
	public void ShouldReturnAllUserInfo_whenPutAllAfterUserPath() throws Exception {

		ArrayList<User> users = new ArrayList<User>();
		users.add(mockUser);
		Mockito.when(userService.getAllUsers()).thenReturn(users.iterator());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/all").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(expectedArray, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void ShouldReturnTheUserInfo_whenPutAUserNameAfterUserPath() throws Exception {

		Mockito.when(userService.findByName(Mockito.anyString())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/Tester").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void shouldSaveTheUser_whenPOSTaUserToServer() throws Exception {

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(mockUser);
		log.debug(exampleUserJson);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user").accept(MediaType.APPLICATION_JSON)
				.content(exampleUserJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/user/Tester", response.getHeader(HttpHeaders.LOCATION));
	}

}