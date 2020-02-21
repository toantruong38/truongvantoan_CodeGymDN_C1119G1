package com.toantr.app;

import com.toantr.app.controller.PhoneNumberController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class ApplicationTests
{
    private MockMvc mockMvc;
    @BeforeTestMethod
    public void setup(){
        this.mockMvc= MockMvcBuilders
                .standaloneSetup(new PhoneNumberController()).build();
    }
    @Test
    public void contextLoads() throws Exception
    {
/*
        this.mockMvc.perform(MockMvcRequestBuilders
            .post("/")
            .accept(MediaType.TEXT_HTML)
                .param("number","090544047a") ).
                andExpect()
*/
    }

}
