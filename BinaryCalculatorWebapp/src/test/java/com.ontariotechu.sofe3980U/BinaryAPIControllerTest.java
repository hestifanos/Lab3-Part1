package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","011").param("operand2","010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("110"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void subtract() throws Exception {
        this.mvc.perform(get("/subtract").param("operand1","1010").param("operand2","0011"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("111"));
    }

    @Test
    public void subtract_json() throws Exception {
        this.mvc.perform(get("/subtract_json").param("operand1","1010").param("operand2","0011"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1010))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(11))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("subtract"));
    }

    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","1010").param("operand2","0011"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("11110"));
    }
    




}