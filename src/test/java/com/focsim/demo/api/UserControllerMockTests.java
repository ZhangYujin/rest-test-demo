package com.focsim.demo.api;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author zhangyujin
 * @createdOn 2019/11/11.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerMockTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testFindOne() throws Exception {

        // 1.查询列表
        mvc.perform(MockMvcRequestBuilders.get("/api/users/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());// 判断响应状态是否成功

    }

    @Test
    public void testCreate1() throws Exception {
        // 2.添加
        mvc.perform(MockMvcRequestBuilders.post("/api/users")
                .param("password", "123456")
                .param("name", "zhangyujin")
                .param("gender", "male"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testCreate2() throws Exception {
        // 2.添加
        mvc.perform(MockMvcRequestBuilders.post("/api/users")
                .content("{\"name\":\"json\",\"password\":\"1234\",\"gender\":\"male\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("1234"));
    }
}
