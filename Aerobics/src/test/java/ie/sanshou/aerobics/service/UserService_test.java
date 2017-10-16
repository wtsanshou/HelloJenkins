package ie.sanshou.aerobics.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ie.sanshou.aerobics.controller.UserController;
import ie.sanshou.aerobics.model.User;
import ie.sanshou.aerobics.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserService_test {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService studentService;

	User mockUser = User.builder().name("Tao").weight(65.0).height(170.0).age(31).gender(true).build();
	
	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(studentService.findByName(Mockito.anyString())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:null,name:Tao,height:170.0,weight:65.0,age:31,gender:true,metabolic:null}";
		// {"id":null,"name":"Tao","height":170.0,"weight":65.0,"age":31,"gender":true,"metabolic":null}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void GetAUserByName() throws Exception {

		Mockito.when(studentService.findByName(Mockito.anyString())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/Tao").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:null,name:Tao,height:170.0,weight:65.0,age:31,gender:true,metabolic:null}";
		// {"id":null,"name":"Tao","height":170.0,"weight":65.0,"age":31,"gender":true,"metabolic":null}

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}